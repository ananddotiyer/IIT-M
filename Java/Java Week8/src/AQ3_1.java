 interface AQ3_1_Example{
	void show();
	default void display(){
 	    System.out.println(2);
      }
	static void reveal(){
	   System.out.println(3);
        }
 }
 public class AQ3_1{
     public static void main(String[] args){
	  AQ3_1_Example ref = ()-> System.out.println(1);
	  ref.show();
     }
}