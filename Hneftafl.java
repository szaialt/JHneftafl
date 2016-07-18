import java.awt.*;
import javax.swing.*;
import java.io.IOException;

public class Hneftafl {

  public void hneftafl() {
    //try {
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      int w = (int)Math.round(screenSize.getWidth());
      int h = (int)Math.round(screenSize.getHeight());
      int size = Math.min(w, h);
      Settings settings = new Settings();
      Listener listener = new Listener(settings);
      
      //Object lock = new Object();
      //Miért erőlteti ez a finalt?
      //SwingUtilities.invokeLater(new Runnable(){
      //@Override
      //public void run(){
      DataFrame df = new DataFrame(listener); 
      JFrame f = new JFrame();
      f.add(df);
      df.setBackground(Color.ORANGE);
      f.pack();
      //df.setPreferredSize(new Dimension(size/2,size/2));
      f.setSize(new Dimension(size/2, size/2));
      f.setResizable(false);
      f.setVisible(true);      //dataFrame. 
      f.repaint();
    //}});
      try {
        Thread.sleep(20*1000);
        JFrame frame = new JFrame("JHneftafl");
        frame.setSize(size, size);
        //Miután bejöttek az adatok...

        //Eldöntöd a jellemzőket
        Size sz = settings.getSize();
        GameType type = settings.getType();

        Gamer beginner = settings.getBeginner();
        String def = settings.getDefender();
        String att = settings.getAttacker();
    
        int last = def.lastIndexOf('.');
        String king = def.substring(0, last-1) + "_kiraly" + def.substring(last);
    
        int s = sz.getValue();
 
        State state = new State(beginner, sz, type);
        Driver driver = new Driver(state);
    
        //Ez tárolja a képeket a bábukhoz
        Images images = null;
        try {
          images = new Images(def, att, king);
        }
        catch (IOException ex) {
          System.out.println("Couldn't find image files");
          System.exit(3);
        }
 
        Surface p = new Surface(s, driver, images);
        frame.add(p);
 
        frame.setVisible(true);
    }
    
     catch (InterruptedException ex) {
       System.out.println("Interrupted.");
     }
  }
}