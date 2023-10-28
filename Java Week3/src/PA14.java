class PA14_A{
       public static void print(){
            System.out.println("Class A print");
       }
       public void show(){
             System.out.println("Class A show");
       }
   }
   class PA14_B extends PA14_A{
       public static void print(){
             System.out.println("Class B print");
       }
       public void show(){
             System.out.println("Class B show");
      }
   }
   public class PA14{
       public static void main(String args[]){
              PA14_A oa=new PA14_B();
              oa.print();
              oa.show();
       }
   }