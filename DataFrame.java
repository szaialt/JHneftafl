/*Kell egy ablak, ahol beállítható:
a méret 3
a típus 2
a színek 3 + 3
ki kezd 2*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

  //Miért nem sikerül adatot nyerni ettől?
  class DataFrame extends JPanel {
    
    Listener listener;

    public DataFrame(Listener listener){
      this.listener = listener;
      //dataFrame = new JDialog();

      //dataFrame.
      //setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

      GridLayout layout = new GridLayout(10,3);
      this.setLayout(layout);
      
      //1. sor
      add(new Label("Méret: "));
      JPanel jp1 = new JPanel();
      JPanel jp2 = new JPanel();
      jp1.setBackground(Color.ORANGE);
      jp2.setBackground(Color.ORANGE);

      add(jp1);
      add(jp2);

      //2. sor
      //Méret
      JRadioButton littleButton = new JRadioButton("9");
      littleButton.setMnemonic(KeyEvent.VK_L);
      littleButton.setActionCommand("9");
      add(littleButton);
      littleButton.setBackground(Color.ORANGE);
      JRadioButton middleButton = new JRadioButton("11");
      middleButton.setMnemonic(KeyEvent.VK_M);
      middleButton.setActionCommand("11");
      add(middleButton);
      middleButton.setBackground(Color.ORANGE);
      JRadioButton grandButton = new JRadioButton("13");
      grandButton.setMnemonic(KeyEvent.VK_D);
      grandButton.setActionCommand("13");
      add(grandButton);
      grandButton.setBackground(Color.ORANGE);
    
    
      //Group the radio buttons.
      ButtonGroup sizeGroup = new ButtonGroup();
      sizeGroup.add(littleButton);
      sizeGroup.add(middleButton);
      sizeGroup.add(grandButton);


     //3. sor
      JPanel jp3 = new JPanel();
      JPanel jp4 = new JPanel();
      jp3.setBackground(Color.ORANGE);
      jp4.setBackground(Color.ORANGE);
      add(new Label("Típus: "));
      add(jp3);
      add(jp4);
     
     //4.sor
      //Típus
      JRadioButton angleButton = new JRadioButton("Sarokba");
      angleButton.setMnemonic(KeyEvent.VK_A);
      angleButton.setActionCommand("angle");
      add(angleButton);
      angleButton.setBackground(Color.ORANGE);

      JRadioButton edgeButton = new JRadioButton("Szélére");
      edgeButton.setMnemonic(KeyEvent.VK_P);
      edgeButton.setActionCommand("edge");
      add(edgeButton);
      edgeButton.setBackground(Color.ORANGE);

      JPanel jp5 = new JPanel();
      jp5.setBackground(Color.ORANGE);
      add(jp5);
    
    
      //Group the radio buttons.
      ButtonGroup typeGroup = new ButtonGroup();
      typeGroup.add(angleButton);
      typeGroup.add(edgeButton);    
    
      JPanel jp6 = new JPanel();
      JPanel jp7 = new JPanel();
      jp6.setBackground(Color.ORANGE);
      jp7.setBackground(Color.ORANGE);
      //5. sor
      add(new Label("A támadó színe: "));
      add(jp6);
      add(jp7);
      
      //6. sor
      //Színek
      JRadioButton red1Button = new JRadioButton("Piros");
      red1Button.setMnemonic(KeyEvent.VK_R);
      red1Button.setActionCommand("attRed");
      add(red1Button);
      red1Button.setBackground(Color.ORANGE);

      JRadioButton green1Button = new JRadioButton("Zöld");
      green1Button.setMnemonic(KeyEvent.VK_G);
      green1Button.setActionCommand("attGreen");
      add(green1Button);
      green1Button.setBackground(Color.ORANGE);

      JRadioButton blue1Button = new JRadioButton("Kék");
      blue1Button.setMnemonic(KeyEvent.VK_B);
      blue1Button.setActionCommand("attBlue");
      add(blue1Button);
      blue1Button.setBackground(Color.ORANGE);

    
    
    
      //Group the radio buttons.
      ButtonGroup attackerGroup = new ButtonGroup();
      attackerGroup.add(red1Button);
      attackerGroup.add(green1Button);
      attackerGroup.add(blue1Button);
    
    
      //7. sor
      JPanel jp8 = new JPanel();
      JPanel jp9 = new JPanel();
      jp8.setBackground(Color.ORANGE);
      jp9.setBackground(Color.ORANGE);
      add(new Label("A védő színe: "));
      add(jp8);
      add(jp9);
      
      //8. sor
      //Színek
      JRadioButton red2Button = new JRadioButton("Piros");
      red2Button.setMnemonic(KeyEvent.VK_1);
      red2Button.setActionCommand("defRed");
      add(red2Button);
      red2Button.setBackground(Color.ORANGE);

      JRadioButton green2Button = new JRadioButton("Zöld");
      green2Button.setMnemonic(KeyEvent.VK_2);
      green2Button.setActionCommand("defGreen");
      add(green2Button);
      green2Button.setBackground(Color.ORANGE);

      JRadioButton blue2Button = new JRadioButton("Kék");
      blue2Button.setMnemonic(KeyEvent.VK_3);
      blue2Button.setActionCommand("defBlue");
      add(blue2Button);
      blue2Button.setBackground(Color.ORANGE);

    
    
    
      //Group the radio buttons.
      ButtonGroup defenderGroup = new ButtonGroup();
      defenderGroup.add(red2Button);
      defenderGroup.add(green2Button);
      defenderGroup.add(blue2Button);
    
    
      //9. sor
      JPanel jp10 = new JPanel();
      JPanel jp11 = new JPanel();
      jp10.setBackground(Color.ORANGE);
      jp11.setBackground(Color.ORANGE);
      
      add(new Label("A kezdőjátékos: "));
      add(jp10);
      add(jp11);
    
      //10. sor
      //Ki kezd?
      JRadioButton attackerButton = new JRadioButton("Támadó");
      attackerButton.setMnemonic(KeyEvent.VK_T);
      attackerButton.setActionCommand("attacker");
      add(attackerButton);
      attackerButton.setBackground(Color.ORANGE);

      JRadioButton defenderButton = new JRadioButton("Védő");
      defenderButton.setMnemonic(KeyEvent.VK_F);
      defenderButton.setActionCommand("defender");
      add(defenderButton);
      defenderButton.setBackground(Color.ORANGE);
      
      JPanel jp12 = new JPanel();
      jp12.setBackground(Color.ORANGE);
      add(jp12);


    
      //Group the radio buttons.
      ButtonGroup beginsGroup = new ButtonGroup();
      beginsGroup.add(attackerButton);
      beginsGroup.add(defenderButton);
    
        

      littleButton.addActionListener(listener);
      middleButton.addActionListener(listener);
      grandButton.addActionListener(listener);
      angleButton.addActionListener(listener);
      edgeButton.addActionListener(listener);
      red1Button.addActionListener(listener);
      green1Button.addActionListener(listener);
      blue1Button.addActionListener(listener);
      red2Button.addActionListener(listener);
      green2Button.addActionListener(listener);
      blue2Button.addActionListener(listener);
      attackerButton.addActionListener(listener);
      attackerButton.addActionListener(listener);
        
        
        
      //dataFrame.
      //pack();

      //setLocationRelativeTo(null);

  
    }
    
}


