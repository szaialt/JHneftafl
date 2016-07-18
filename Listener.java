import java.awt.event.*;

class Listener implements ActionListener {
    Settings settings;
    
   //JDialog dataFrame;
    boolean performedSize;
    boolean performedType;
    boolean performedAttacker;
    boolean performedDefender;
    boolean performedBeginner;
    
    
    public Listener(Settings settings){
      this.settings = settings;
    }
    
   //The complier of the new operating system couldn't remark that we use Java 7.
  public void actionPerformed(ActionEvent e) {
      synchronized(settings){

        if (e.getActionCommand() == "9"){
          settings.setSize(Size.LITTLE);
          performedSize = true;
        } 
        else if (e.getActionCommand() == "11") {
          settings.setSize(Size.MIDDLE);
          performedSize = true;
        }
        else if (e.getActionCommand() ==  "13") {
          settings.setSize(Size.GRAND);
          performedSize = true;
        }
        if (e.getActionCommand() ==  "angle") {
          settings.setType(GameType.ANGLE);
          performedType = true;
        }
        else if (e.getActionCommand() ==  "edge") {
          settings.setType(GameType.EDGE);
          performedType = true;
        }
        if (e.getActionCommand() ==  "attRed") {
          settings.setAttacker("piros.png");
          performedAttacker = true;
        }
        else if (e.getActionCommand() ==  "attGreen") {
          settings.setAttacker("zold.png");
          performedAttacker = true;
        }
        else if (e.getActionCommand() ==  "attBlue") {
          settings.setAttacker("kek.png");
          performedAttacker = true;
        }
        if (e.getActionCommand() ==  "defRed") {
          settings.setDefender("piros.png");
          performedDefender = true;
        }
        else if (e.getActionCommand() ==  "defGreen") {
          settings.setDefender("zold.png");
          performedDefender = true;
        }    
        else if (e.getActionCommand() ==  "defBlue") {
          settings.setDefender("kek.png");
          performedDefender = true;
        }
        if (e.getActionCommand() ==  "attacker") {
         settings.setBeginner(Gamer.ATTACKER);
          performedBeginner = true;
        }    
        else if (e.getActionCommand() ==  "defender") {
          settings.setBeginner(Gamer.DEFENDER);
          performedBeginner = true;
        }
     
      //notification();
      }
  }
  
     public void notification(){
      if (performed()) notify();
  }
  
   public boolean performed(){
      return (performedSize && performedType && performedAttacker && performedDefender 
      && performedBeginner);
  }
  
}