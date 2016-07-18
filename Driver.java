import java.util.Vector;
import javax.swing.*;
import java.awt.BorderLayout;

public class Driver {

  State state;
  
  Driver(State state){
    this.state = state;
  }

  public  boolean hasYouAFigureThere(Gamer gamer, int x, int y)/**/{
    if (gamer.equals(Gamer.ATTACKER)){
      for(int i=0;i<state.getAttacker().size();i++){
        int x1 = state.getAttacker().elementAt(i).getX();
        int y1 = state.getAttacker().elementAt(i).getY();
        if (x1 == x){
          if (y1 == y){
            return true;
          }
        }
      }
    }
    else if (gamer.equals(Gamer.DEFENDER)){
        int x1 = state.getKing().getX();
        int y1 = state.getKing().getY();
        if (x1 == x){
          if (y1 == y){
          return true;
          }
        }

      for(int i=0;i<state.getDefender().size();i++){
        x1 = state.getDefender().elementAt(i).getX();
        y1 = state.getDefender().elementAt(i).getY();
        if (x1 == x){
          if (y1 == y){
          return true;
          }
        }
      }
    }
  return false;
  }

  public  Figure yourFigureAt(int x, int y)/**/{
    if (state.getNext().equals(Gamer.ATTACKER)){
      for(int i=0;i<state.getAttacker().size();i++){
        int x1 = state.getAttacker().elementAt(i).getX();
        int y1 = state.getAttacker().elementAt(i).getY();
        if (x1 == x){
          if (y1 == y){
            return state.getAttacker().elementAt(i);
          }
        }
      }
    }
    else if (state.getNext().equals(Gamer.DEFENDER)){
        int x1 = state.getKing().getX();
        int y1 = state.getKing().getY();
        if (x1 == x){
          if (y1 == y){
            return state.getKing();
          }
        }

      for(int i=0;i<state.getDefender().size();i++){
        x1 = state.getDefender().elementAt(i).getX();
        y1 = state.getDefender().elementAt(i).getY();
        if (x1 == x){
          if (y1 == y){
            return state.getDefender().elementAt(i);
          }
        }
      }
    }
  return null;
  }
  
  public  boolean isMoveLegal(Figure figure, int a, int b){
  //Ezt még fejleszteni kell
    int x = figure.getX();
    int y = figure.getY();
    //Csak vízszintesen és függőlegesen lehet lépni
    if ((a != x) && (b != y)) return false;
    //Csak a tábla széléig lehet menni
    if (a < 0) return false;
    if (b < 0) return false;
    if (a >= state.getSize().getValue()) return false;
    if (b >= state.getSize().getValue()) return false;
    //Szimmetria!
    //Csak a következő bábuig lehet lépni
    if (a < x){
    //Ha van közben bábud, akkor nem léphetsz oda
      for (int i = a; i < x; i++){
        //Saját bábu
        if (hasYouAFigureThere(state.getNext(), i, y)) return false;
        //Ellenfél bábuja
        if (hasYouAFigureThere(state.getNext().getAdversary(), i, y)) return false;
      }
    }
    if (a > x){
        //Ha van közben bábud, akkor nem léphetsz oda
      for (int i = x + 1; i <= a; i++){
        //Saját bábu
        if (hasYouAFigureThere(state.getNext(), i, y)) return false;
        //Ellenfél bábuja
        if (hasYouAFigureThere(state.getNext().getAdversary(), i, y)) return false;
      }
    }
    if (b < y){
        //Ha van közben bábud, akkor nem léphetsz oda
      for (int j = b; j < y; j++){
        //Saját bábu
        if (hasYouAFigureThere(state.getNext(), x, j)) return false;
        //Ellenfél bábuja
        if (hasYouAFigureThere(state.getNext().getAdversary(), x, j)) return false;
      }
    }
    if (b > y){
      //Ha van közben bábud, akkor nem léphetsz oda
      for (int j = y + 1; j <= b; j++){
        //Saját bábu
        if (hasYouAFigureThere(state.getNext(), x, j)) return false;
        //Ellenfél bábuja
        if (hasYouAFigureThere(state.getNext().getAdversary(), x, j)) return false;
      }
    }
    return true;
  }

  public void move(Figure figure, int a, int b){
    if (isMoveLegal(figure, a, b)){
      figure.setX(a);
      figure.setY(b);
      state.setMovedLast(figure);
    }
  }
 
   public  boolean caught(){
    //Szimmetria!
    int at = 0;
    boolean isLastMovedNeighbour = false;
    boolean caught = false;
    Vector<Figure> lista1 = new Vector<Figure>();
    Vector<Figure> lista2 = new Vector<Figure>();

    //at >= 2, katona halott
      
    if (state.getNext().equals(Gamer.ATTACKER)){
      lista1 = state.getDefender();
      lista2 = state.getAttacker();
    }
    else {
      lista1 = state.getAttacker();
      lista2 = state.getDefender();
    }
      
    for(int i=0;i<lista1.size();i++){
      isLastMovedNeighbour = false;

      //Az ütés csak akkor érvényes, ha az utoljára lépett bábu is 
      //szomszéd

        if (state.isNeighbour(state.getMovedLast(), lista1.elementAt(i)))
          isLastMovedNeighbour = true;

        //Ha nem lett szomszédja az utoljára lépett bábu,
        //akkor ne is vizsgáljuk
        if (isLastMovedNeighbour){
          for(int j=0;j<lista2.size();j++){
            if (state.getMovedLast().equals(lista2.elementAt(j)) == false){
              if (state.isNeighbour(lista2.elementAt(j), lista1.elementAt(i)))
                at = at +1;
            }
          }
         //A királyra külön szabályok vonatkoznak, nem itt vizsgáljuk
         //hanem az attackerWon() és a draw() függvényekben
        }
      
      caught = isLastMovedNeighbour;
      if (at < 1) caught = false;
        if (caught) {
           //Nemcsak egy ütés lehet, ezért folytatni kell a vizsgálódást
           state.remove(i);
        }
      }
      return caught;
    
   //Nem volt ütés
   //return false;
  }
 
//Döntsük el, hogy ki nyert
//A király eljutott a menedékbe: védő nyert
//A királyt körülvették: a támadó nyert
//
  public  boolean defenderWon(){
    boolean won = false;
    if (state.getType().equals(GameType.EDGE)){
      if (state.getKing().getX() == 0)
        won = true;
      else if (state.getKing().getX() == state.getSize().getValue()-1)
        won = true;
      if (state.getKing().getY() == 0)
        won = true;
      else if (state.getKing().getY() == state.getSize().getValue()-1)
        won = true;
      }
    else {
      if (state.getKing().getX() == 0){
        if (state.getKing().getY() == 0)
          won = true;
        else if (state.getKing().getY() == state.getSize().getValue()-1)
          won = true;
        }
      else if (state.getKing().getX() == state.getSize().getValue()-1){
        if (state.getKing().getY() == 0)
          won = true;
        else if (state.getKing().getY() == state.getSize().getValue()-1)
          won = true;
      }
    }

    if (won){
      state.setWinner(Gamer.DEFENDER);
      String message = "A védő nyert.";
      System.out.println(message);
      window(message);
      }
    return won;
  } 
 
//A király körüli összes mező foglalt,
//és a támadó van ott
  public  boolean attackerWon(){
    boolean won = false;
    int at = 0;
    for(int i=0;i<state.getAttacker().size();i++){
      if (state.isNeighbour(state.getAttacker().elementAt(i), state.getKing())) {
        at = at +1;
      }
      if (at >= 4)
        won = true;
      if (won){
        state.setWinner(Gamer.DEFENDER);
        String message = "A támadó nyert.";
        System.out.println(message);
        window(message);
        }
      }
      return won;
    }
    
//Döntetlen: a soron következő játékos nem tud lépni
  public  boolean draw() {

    if (state.getType().equals(GameType.EDGE)) 
      return false;
    if (state.getNext().equals(Gamer.ATTACKER))
      return false;
    boolean edge = false;
    if (defenderWon()==false){
      if (state.getKing().getX() == 0)
        edge = true;
      else if (state.getKing().getX() == state.getSize().getValue()-1)
        edge = true;
      if (state.getKing().getY() == 0)
        edge = true;
      else if (state.getKing().getY() == state.getSize().getValue()-1)
        edge = true;
      }
    if (edge == false)
      return false;
    if (state.getDefender().size() == 0)
      return true;
    else return false;
  }

  public  boolean isGameOver(){
    if (defenderWon()) return true;
    else if (draw()) return true;
    else if (attackerWon()) return true;
    else return false;
  } 
   
  public void window(String message){
    //1. Create the frame.
    JFrame frame = new JFrame("JHneftafl");

    //2. Optional: What happens when the frame closes?
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //3. Create components and put them in the frame.    
    JLabel label = new JLabel(message);
    frame.getContentPane().add(label, BorderLayout.CENTER);

    //4. Size the frame.
    frame.pack();

    //5. Show it.
    frame.setVisible(true);
  } 
   
  public Vector<Figure> getDefender(){
    return state.getDefender();
  } 
  
  public Vector<Figure> getAttacker(){
    return state.getAttacker();
  } 
  
  public Figure getKing(){
    return state.getKing();
  }  
   
  public Gamer getNext(){
    return state.getNext();
  }

  public Gamer getWinner(){
    return state.getWinner();
  } 
  
  public void setNext(Gamer gamer){
    state.setNext(gamer);
  }
   

   
}
