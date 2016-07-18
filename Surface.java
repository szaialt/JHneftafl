import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;
 
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.util.Vector;

public class Surface extends JPanel {
  
   private String imgFileName = "faKDK.jpg"; // relative to project root (or bin)
   private Image img;  // a BufferedImage object
   private int numOfSteps;
   private Driver driver;
   private Images images;
   private int w;
   private int h;
   private int size;
   private int frameWidth;
   private int step;
   private int mx;
   private int correction;
   
   Surface(int numOfSteps, Driver driver, Images images){
     this.setFocusable(true);
     this.numOfSteps = numOfSteps;
     this.driver = driver;
     this.images = images;
     Dimension bounds = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
     w = (int)Math.round(bounds.getWidth());
     h = (int)Math.round(bounds.getHeight());
     size = Math.min(w, h);
     frameWidth = 100;

     step = (size - frameWidth) / (numOfSteps + 1);
     mx = step * (numOfSteps - 1) + frameWidth;
     correction = frameWidth - step;
     
     MouseMotionHandler mmh = new MouseMotionHandler(frameWidth, step);
     addMouseListener(mmh);
     addMouseMotionListener(mmh);

   }
   
  @Override
  public void paint(Graphics g) { 
    Graphics2D g2 = (Graphics2D)g;

    Gamer next = driver.getNext();

    URL imgUrl = getClass().getClassLoader().getResource(imgFileName);
      if (imgUrl == null) {
         System.err.println("Couldn't find file: " + imgFileName);
      } else {
         try {
            img = ImageIO.read(imgUrl);
         } catch (IOException ex) {
            ex.printStackTrace();
         }
      }
        
    g2.setColor(Color.blue);
    g2.fillRect(0, 0, this.getWidth(), this.getHeight());
    
    g2.setColor(Color.lightGray);
    g2.fillRect(frameWidth, frameWidth, mx - correction, 
         mx - correction);
 
 
    int imWidth = img.getWidth(this);
    int imHeight = img.getHeight(this);
    
    int imgXNum = size / imWidth;
    int imgYNum = size / imHeight;
    
    for (int i = 0; i <= imgXNum + 1; i++){
      for (int j = 0; j <= imgYNum + 1; j++){
        g2.drawImage(img, i * imWidth, 
           j * imHeight, null);
      }
    }
     
    if (driver.isGameOver()) {
      Gamer winner = driver.getWinner();
      String wonString = "";
      //Valamiért nem jelenik meg a felirat.
      if (winner != null){
        if (winner == Gamer.DEFENDER){
          wonString = "Védő nyert.";
        }
        else if (winner == Gamer.ATTACKER){
          wonString = "Támadó nyert.";
        }        
      }
      else {
        wonString = "Döntetlen.";
      }
      g2.setColor(Color.red);
      g2.drawString(wonString, frameWidth, frameWidth / 2);
      try {
        Thread.sleep(30000);
      }
      catch (InterruptedException ex){
        System.exit(0);
      }
      System.exit(0);
    }
     
    String message = "";
     
    if (driver.getNext() == Gamer.DEFENDER){
      message = "Támadó lép.";
    } 
    else if (driver.getNext() == Gamer.ATTACKER){
      message = "Védő lép.";
    } 

    g2.setColor(Color.red);
    g2.drawString(message, frameWidth, frameWidth / 2);
     
    g2.setColor(Color.black);
    for (int i = 0; i <= numOfSteps + 1; i++){
      //Függőlegesek
      g2.drawLine(frameWidth + i*step, frameWidth, frameWidth + i*step, 
         mx + step);
      //Vízszintesek
      g2.drawLine(frameWidth, frameWidth + i*step, 
         mx + step, frameWidth + i*step);
    }
    
    Vector<Figure> defender = driver.getDefender();
    Vector<Figure> attacker = driver.getAttacker();
    Figure king = driver.getKing();
    
    for (int i = 0; i < defender.size(); i++){
      Figure def = defender.elementAt(i);
      Image defImage = images.getDefImg();
      int x = def.getX();
      int y = def.getY();
      g2.drawImage(defImage, frameWidth + x * step, 
           frameWidth + y * step, step, step, null);
    }
    
    for (int i = 0; i < attacker.size(); i++){
      Figure att = attacker.elementAt(i);
      Image attImage = images.getAttImg();
      int x = att.getX();
      int y = att.getY();
      g2.drawImage(attImage, frameWidth + x * step, 
           frameWidth + y * step, step, step, null);
    }

    { //Legyen x és y helyi
    Image kingImage = images.getKingImg();
    int x = king.getX();
    int y = king.getY();
    g2.drawImage(kingImage, frameWidth + x * step, 
           frameWidth + y * step, step, step, null);
    }
     
    driver.setNext(next.getAdversary());
  }
 
  class MouseMotionHandler 
         implements MouseListener, MouseMotionListener {
  
    private int frameWidth;
    private int step;
    private int x;
    private int y;
    //private boolean movedAttacker;
        
    MouseMotionHandler(int frameWidth, int step){
      this.frameWidth = frameWidth;
      this.step = step;
    }
    
    public void mousePressed(MouseEvent e){
        int x1 = e.getX();
        int y1 = e.getY();
        x = (x1 - frameWidth) / step;
        y = (y1 - frameWidth) / step;
    }
    
    public void mouseClicked(MouseEvent e){}
    
    public void mouseReleased(MouseEvent e){
       int x1 = e.getX();
       int y1 = e.getY();
       int a = (x1 - frameWidth) / step;
       int b = (y1 - frameWidth) / step;
       System.out.println(x);
       System.out.println(y);
       Gamer next = driver.getNext();

       System.out.println(next);
       if (driver.hasYouAFigureThere(next, x, y)){
         Figure figure = driver.yourFigureAt(x, y);
         System.out.println(figure.getGamer());
         driver.move(figure, a, b);
         driver.caught();
       }
       repaint();
    }
    
    public void mouseEntered(MouseEvent e){}
    
    public void mouseExited(MouseEvent e){}
    
    public void mouseMoved(MouseEvent e){}
    
    public void mouseDragged(MouseEvent e){}
    
  }
}







