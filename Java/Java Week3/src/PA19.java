class PA19_A{
        public void show(){
             System.out.println("A class show()");
        }
   }
   class PA19_B extends PA19_A{
        public void show(){
              System.out.println("B class show()");
        }
   }
   class PA19_C extends PA19_B{
   }
   public class PA19{
          public static void main(String[] args){
                PA19_C oc=new PA19_C();
                oc.show();
          }
   }