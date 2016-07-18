public class Settings {
    Size size;
    GameType type;

    Gamer beginner;
    String defender;
    String attacker;

    synchronized public Size getSize(){
      return this.size;
    }
    
    synchronized public GameType getType(){
      return this.type;
    }

    synchronized public Gamer getBeginner(){
      return this.beginner;
    }
    
    synchronized public String getDefender(){
      return this.defender;
    }
    
    synchronized public String getAttacker(){
      return this.attacker;
    }


    synchronized public void setSize(Size size){
      this.size = size;
    }
    
    synchronized public void setType(GameType type){
      this.type = type;
    }

    synchronized public void setBeginner(Gamer beginner){
      this.beginner = beginner;
    }
    
    synchronized public void setDefender(String defender){
      this.defender = defender;
    }
    
    synchronized public void setAttacker(String attacker){
      this.attacker = attacker;
    }

}