import java.awt.*;

import java.net.URL;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Images {
   //Ezeket majd konstruktorban kell megadni

   private String defImgFileName = "kek.png"; // a védő katonáinak képe
   private Image defImg;  // a BufferedImage object

   private String attImgFileName = "zold.png"; // a támadó katonáinak képe
   private Image attImg;  // a BufferedImage object

   private String kingImgFileName = "kek_kiraly.png"; // a király képe
   private Image kingImg;  // a BufferedImage object

   public Images() throws IOException {
       URL defImgUrl = getClass().getClassLoader().getResource(defImgFileName);
      if (defImgUrl == null) {
         throw new IOException();
      } else {
     
        defImg = ImageIO.read(defImgUrl);

      }
      
          URL attImgUrl = getClass().getClassLoader().getResource(attImgFileName);
      if (attImgUrl == null) {
        throw new IOException();
        } else {

            attImg = ImageIO.read(attImgUrl);

      }
      
          URL kingImgUrl = getClass().getClassLoader().getResource(kingImgFileName);
      if (kingImgUrl == null) {
         throw new IOException();
      } else {

            kingImg = ImageIO.read(kingImgUrl);

      }
      
   }
   
      public Images(String defImgFileName, String attImgFileName, String kingImgFileName) throws IOException {
       URL defImgUrl = getClass().getClassLoader().getResource(defImgFileName);
      if (defImgUrl == null) {
         throw new IOException();
      } else {
     
        defImg = ImageIO.read(defImgUrl);

      }
      
          URL attImgUrl = getClass().getClassLoader().getResource(attImgFileName);
      if (attImgUrl == null) {
        throw new IOException();
        } else {

            attImg = ImageIO.read(attImgUrl);

      }

      URL kingImgUrl = getClass().getClassLoader().getResource(kingImgFileName);
      if (kingImgUrl == null) {
         throw new IOException();
      } else {

            kingImg = ImageIO.read(kingImgUrl);

      }
      
   }
   
   
   
   Image getDefImg(){
     return this.defImg;
   }
   
   Image getAttImg(){
     return this.attImg;
   }
   
   Image getKingImg(){
     return this.kingImg;
   }
}