abstract class AQ1_9_Ipl{
      public abstract void team(String name);
}
class AQ1_9_CSK extends AQ1_9_Ipl{
      public void team(String name) {
            System.out.println(name+" is CSK team");
     }        
}
class AQ1_9_SRH extends AQ1_9_Ipl{
      public void team(String name) {
            System.out.println(name+" is SRH team");
      }        
}
class AQ1_9_Player{
      AQ1_9_Ipl ipl;
      String name;
      public AQ1_9_Player(AQ1_9_Ipl ipl,String name) {
            this.ipl = ipl;
            this.name = name;
      }
      public void team(){
            ipl.team(name);
      }
}
public class AQ1_9 {
      public static void main(String[] args) {
            AQ1_9_Player player1=new AQ1_9_Player(new AQ1_9_CSK(), "Ravi Jadeja");
            player1.team(); 
            AQ1_9_Player player2=new AQ1_9_Player(new AQ1_9_SRH(), "Manish Pandey");
            player2.team();
      }
}