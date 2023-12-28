interface AQ3_3_X{
void message();
}
 class AQ3_3_Example{
       int a=1;
       static int b=2;
  }
 public class AQ3_3 {
     void show(){
         AQ3_3_X ref = () -> {
         System.out.println("Instance variable: "+ new AQ3_3_Example().a);
         System.out.println("Static variable: "+ AQ3_3_Example.b);
         int number=3;
         System.out.println("Local variable: "+ number);
         };
       ref.message();
  }
  public static void main(String args[]) {
      new AQ3_3().show();
  }
}