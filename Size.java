public enum Size {
  LITTLE, MIDDLE, GRAND;
 
  private int value;
 
   public void setValue(int n) {
     value = n;
   }
 
   public int getValue() {
     switch (this) {
       case LITTLE:
         return 9;
       case MIDDLE:
         return 11;
       case GRAND:
         return 13;
    }
    return -1;
  }
}