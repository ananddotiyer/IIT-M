abstract class Ipl{
      public abstract void team(String name);
}
class CSK extends Ipl{
      public void team(String name) {
            System.out.println(name+" is CSK team");
     }        
}
class SRH extends Ipl{
      public void team(String name) {
            System.out.println(name+" is SRH team");
      }        
}
class Player{
      Ipl ipl;
      String name;
      public Player(Ipl ipl,String name) {
            this.ipl = ipl;
            this.name = name;
      }
      public void team(){
            ipl.team(name);
      }
}
public class AQ1_9 {
      public static void main(String[] args) {
            Player player1=new Player(new CSK(), "Ravi Jadeja");
            player1.team(); 
            Player player2=new Player(new SRH(), "Manish Pandey");
            player2.team();
      }
}