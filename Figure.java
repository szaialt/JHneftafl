
public class Figure {
  int x;
  int y;
  Gamer gamer;

  Figure(int x, int y, Gamer gamer){
    this.x = x;
    this.y = y;
    this.gamer = gamer;
  }

  int getX(){
    return this.x;
  }

  int getY(){
    return this.y;
  }

  Gamer getGamer(){
    return this.gamer;
  }
  
  void setX(int a){
    this.x = a;
  }

  void setY(int b){
    this.y = b;
  }
  
}