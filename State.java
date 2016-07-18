import java.util.Vector;

public class State {
  private Gamer next; // = Gamer.ATTACKER;
  private Figure movedLast;
  private Vector<Figure> defender; //a védő katonái
  private Vector<Figure> attacker; //a támadó katonái
  private Size size; 
  private GameType type; 
  private Figure king;
  private Gamer winner;
  
  State(Gamer next, Size size, GameType type){
    this.next = next;
    this.size = size;
    this.type = type;
    this.movedLast = null;
    this.defender = new Vector<Figure>(); 
    this.attacker = new Vector<Figure>(); 
    this.king = new Figure((size.getValue()-1)/2, (size.getValue()-1)/2, Gamer.DEFENDER);
    this.winner = null;
    
    if (size.getValue() == 9){

      //A védő bábui: a király és 12 katona
      defender.add(new Figure(4, 3, Gamer.DEFENDER));
      defender.add(new Figure(4, 2, Gamer.DEFENDER));
      defender.add(new Figure(4, 1, Gamer.DEFENDER));
      defender.add(new Figure(3, 4, Gamer.DEFENDER));
      defender.add(new Figure(2, 4, Gamer.DEFENDER));
      defender.add(new Figure(1, 4, Gamer.DEFENDER));
      defender.add(new Figure(4, 5, Gamer.DEFENDER));
      defender.add(new Figure(4, 6, Gamer.DEFENDER));
      defender.add(new Figure(4, 7, Gamer.DEFENDER));
      defender.add(new Figure(5, 4, Gamer.DEFENDER));
      defender.add(new Figure(6, 4, Gamer.DEFENDER));
      defender.add(new Figure(7, 4, Gamer.DEFENDER));


        //A támadó bábui: 12 katona

      attacker.add(new Figure(0, 3, Gamer.ATTACKER));
      attacker.add(new Figure(0, 4, Gamer.ATTACKER));
      attacker.add(new Figure(0, 5, Gamer.ATTACKER));
      attacker.add(new Figure(3, 0, Gamer.ATTACKER));
      attacker.add(new Figure(4, 0, Gamer.ATTACKER));
      attacker.add(new Figure(5, 0, Gamer.ATTACKER));
      attacker.add(new Figure(8, 3, Gamer.ATTACKER));
      attacker.add(new Figure(8, 4, Gamer.ATTACKER));
      attacker.add(new Figure(8, 5, Gamer.ATTACKER));
      attacker.add(new Figure(3, 8, Gamer.ATTACKER));
      attacker.add(new Figure(4, 8, Gamer.ATTACKER));
      attacker.add(new Figure(5, 8, Gamer.ATTACKER));





      }
    else if (size.getValue() == 11){
      //A védő bábui: a király és 12 katona
      defender.add(new Figure(5, 4, Gamer.DEFENDER));
      defender.add(new Figure(5, 6, Gamer.DEFENDER));
      defender.add(new Figure(4, 5, Gamer.DEFENDER));
      defender.add(new Figure(6, 5, Gamer.DEFENDER));
      defender.add(new Figure(6, 4, Gamer.DEFENDER));
      defender.add(new Figure(4, 6, Gamer.DEFENDER));
      defender.add(new Figure(6, 6, Gamer.DEFENDER));
      defender.add(new Figure(4, 4, Gamer.DEFENDER));
      defender.add(new Figure(3, 5, Gamer.DEFENDER));
      defender.add(new Figure(5, 3, Gamer.DEFENDER));
      defender.add(new Figure(5, 7, Gamer.DEFENDER));
      defender.add(new Figure(7, 5, Gamer.DEFENDER));

      //A támadó bábui: 24 katona

      attacker.add(new Figure(0, 3, Gamer.ATTACKER));
      attacker.add(new Figure(0, 4, Gamer.ATTACKER));
      attacker.add(new Figure(0, 5, Gamer.ATTACKER));
      attacker.add(new Figure(0, 6, Gamer.ATTACKER));
      attacker.add(new Figure(0, 7, Gamer.ATTACKER));
      attacker.add(new Figure(1, 5, Gamer.ATTACKER));
      attacker.add(new Figure(3, 0, Gamer.ATTACKER));
      attacker.add(new Figure(4, 0, Gamer.ATTACKER));
      attacker.add(new Figure(5, 0, Gamer.ATTACKER));
      attacker.add(new Figure(6, 0, Gamer.ATTACKER));
      attacker.add(new Figure(7, 0, Gamer.ATTACKER));
      attacker.add(new Figure(5, 1, Gamer.ATTACKER));
      attacker.add(new Figure(10, 3, Gamer.ATTACKER));
      attacker.add(new Figure(10, 4, Gamer.ATTACKER));
      attacker.add(new Figure(10, 5, Gamer.ATTACKER));
      attacker.add(new Figure(10, 6, Gamer.ATTACKER));
      attacker.add(new Figure(10, 7, Gamer.ATTACKER));
      attacker.add(new Figure(9, 5, Gamer.ATTACKER));
      attacker.add(new Figure(3, 10, Gamer.ATTACKER));
      attacker.add(new Figure(4, 10, Gamer.ATTACKER));
      attacker.add(new Figure(5, 10, Gamer.ATTACKER));
      attacker.add(new Figure(6, 10, Gamer.ATTACKER));
      attacker.add(new Figure(7, 10, Gamer.ATTACKER));
      attacker.add(new Figure(5, 9, Gamer.ATTACKER));




      }
    else if (size.getValue() == 13){

      //A védő bábui: a király és 12 katona
      defender.add(new Figure(6, 5, Gamer.DEFENDER));
      defender.add(new Figure(6, 4, Gamer.DEFENDER));
      defender.add(new Figure(6, 3, Gamer.DEFENDER));
      defender.add(new Figure(5, 6, Gamer.DEFENDER));
      defender.add(new Figure(4, 6, Gamer.DEFENDER));
      defender.add(new Figure(3, 6, Gamer.DEFENDER));
      defender.add(new Figure(6, 7, Gamer.DEFENDER));
      defender.add(new Figure(6, 8, Gamer.DEFENDER));
      defender.add(new Figure(6, 9, Gamer.DEFENDER));
      defender.add(new Figure(7, 6, Gamer.DEFENDER));
      defender.add(new Figure(8, 6, Gamer.DEFENDER));
      defender.add(new Figure(9, 6, Gamer.DEFENDER));

        //A támadó bábui: 24 katona

      attacker.add(new Figure(0, 4, Gamer.ATTACKER));
      attacker.add(new Figure(0, 5, Gamer.ATTACKER));
      attacker.add(new Figure(0, 6, Gamer.ATTACKER));
      attacker.add(new Figure(0, 7, Gamer.ATTACKER));
      attacker.add(new Figure(0, 8, Gamer.ATTACKER));
      attacker.add(new Figure(1, 6, Gamer.ATTACKER));
      attacker.add(new Figure(4, 0, Gamer.ATTACKER));
      attacker.add(new Figure(5, 0, Gamer.ATTACKER));
      attacker.add(new Figure(6, 0, Gamer.ATTACKER));
      attacker.add(new Figure(7, 0, Gamer.ATTACKER));
      attacker.add(new Figure(8, 0, Gamer.ATTACKER));
      attacker.add(new Figure(6, 1, Gamer.ATTACKER));
      attacker.add(new Figure(12, 4, Gamer.ATTACKER));
      attacker.add(new Figure(12, 5, Gamer.ATTACKER));
      attacker.add(new Figure(12, 6, Gamer.ATTACKER));
      attacker.add(new Figure(12, 7, Gamer.ATTACKER));
      attacker.add(new Figure(12, 8, Gamer.ATTACKER));
      attacker.add(new Figure(11, 6, Gamer.ATTACKER));
      attacker.add(new Figure(4, 12, Gamer.ATTACKER));
      attacker.add(new Figure(5, 12, Gamer.ATTACKER));
      attacker.add(new Figure(6, 12, Gamer.ATTACKER));
      attacker.add(new Figure(7, 12, Gamer.ATTACKER));
      attacker.add(new Figure(8, 12, Gamer.ATTACKER));
      attacker.add(new Figure(6, 11, Gamer.ATTACKER));
      
     }
  }
  
  public Gamer getNext(){
    return this.next;
  } 
  
  public Figure getMovedLast(){
    return this.movedLast;
  }
  
  public Vector<Figure> getDefender(){
    return this.defender;
  } 
  
  public Vector<Figure> getAttacker(){
    return this.attacker;
  } 
  
  public Size getSize(){
    return this.size;
  }
  
  public GameType getType(){
    return this.type;
  } 
  
  public Figure getKing(){
    return this.king;
  }
  
  public Gamer getWinner(){
    return this.winner;
  } 
  
  public void setMovedLast(Figure figure){
    this.movedLast = figure;
  }
  
  public void setNext(Gamer gamer){
    this.next = gamer;
  }
  
  public void setWinner(Gamer gamer){
    this.winner = gamer;
  }
    
  public static boolean isNeighbour(Figure b1, Figure b2){

            int x1 = b1.getX();
            int y1 = b1.getY();
            int x2 = b2.getX();
            int y2 = b2.getY();

            if(x1 == x2){
              if(y1 == y2-1)
                return true;
              else if(y1 == y2+1)
                return true;
            }
            else if(x1 == x2-1){
            if (y1 == y2)
                return true;
            }
            else if(x1 == x2+1){
            if (y1 == y2)
                return true;
            }
      return false;

  }

  public void remove(int i){
    if (next.equals(Gamer.ATTACKER)){
      defender.remove(i);
    }
    else {
      attacker.remove(i);
    }
  }
  
}