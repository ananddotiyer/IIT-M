interface AQ3_6_X{
   int display(int a);
 }
class AQ3_6_Example{
  public int show(int b){
      return (int)Math.pow(b,2);
    }
 }
 public class AQ3_6{
    public static void main(String[] args){
         AQ3_6_X ref=new AQ3_6_Example()::show;
         System.out.println(ref.display(5));
     }
  }