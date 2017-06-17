package com.company;

import org.jfugue.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class KeyboardInstrument extends JFrame{
  private Frame mainFrame;
  private Panel controlPanel;
  private ArrayList<JButton> keys;
  private Player player;

  public KeyboardInstrument(){
    this.keys = new ArrayList<>();
    this.player = new Player();
    prepareGUI();
  }

  public static void main(String[] args){
    KeyboardInstrument keyboard = new KeyboardInstrument();
    keyboard.showKeyListenerDemo();
  }

  private void prepareGUI(){
    mainFrame = new Frame("Java Keyboard Listener");
    mainFrame.setSize(500,150);
    mainFrame.setLayout(new GridLayout(1, 6));
    mainFrame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent windowEvent){
        System.exit(0);
      }
    });

    JButton cButton = new JButton("C");
    JButton dButton = new JButton("D");
    JButton eButton = new JButton("E");
    JButton fButton = new JButton("F");
    JButton gButton = new JButton("G");
    JButton aButton = new JButton("A");
    JButton bButton = new JButton("B");

    keys.add(cButton);
    keys.add(dButton);
    keys.add(eButton);
    keys.add(fButton);
    keys.add(gButton);
    keys.add(aButton);
    keys.add(bButton);

    controlPanel = new Panel();
    controlPanel.setLayout(new FlowLayout());

    for (JButton k : keys) {
      mainFrame.add(k);
    }

    mainFrame.setVisible(true);
  }

  private void showKeyListenerDemo(){

    for (JButton key : keys) {
      key.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          player.play(String.valueOf(key.getText()));
        }
      });
    }

    mainFrame.setVisible(true);
  }
}
