public enum Gamer {
 //VÉDŐ, TÁMADÓ
 DEFENDER, ATTACKER;

  public Gamer getAdversary() {
   if (this.equals(Gamer.DEFENDER))
     return Gamer.ATTACKER;
   else
     return Gamer.DEFENDER;
 }
 
 }
