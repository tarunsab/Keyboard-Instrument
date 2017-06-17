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

  public static void main(String[] args){
    KeyboardInstrument keyboard = new KeyboardInstrument();
    keyboard.showKeyListenerDemo();
  }

  public KeyboardInstrument(){
    this.keys = new ArrayList<>();
    this.player = new Player();
    prepareGUI();
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

    //Adding keys to keys ArrayList
    keys.add(new JButton("C"));
    keys.add(new JButton("D"));
    keys.add(new JButton("E"));
    keys.add(new JButton("F"));
    keys.add(new JButton("G"));
    keys.add(new JButton("A"));
    keys.add(new JButton("B"));

    controlPanel = new Panel();
    controlPanel.setLayout(new FlowLayout());

    //Adding all keys in Keys to ArrayList
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
