//This is an example of method reference.  THis is possible because AQ3_5_Example::show() has the same signature as AQ3_5_X.display()
 interface AQ3_5_X{
     boolean display(int a);
 }
 class AQ3_5_Example{
      public static boolean show(int b){
         return b>10;
     }
 }
 public class AQ3_5{
     public static void main(String[] args){
	 X ref=Y::show;
	 System.out.println(ref.display(1));
     }
 }