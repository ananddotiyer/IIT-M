class AQ4_10_Example{
      boolean bool;
      AQ4_10_Example(boolean bool){
              this.bool=bool;
     }
     public void check(){
             boolean turnOn=bool;
             assert(turnOn):turnOn=false;
             if(turnOn){
                     System.out.println("Assertion enabled.");
             }
     }
}
public class AQ4_10{
       public static void main(String[] args){
              new AQ4_10_Example(true).check();
     }
}