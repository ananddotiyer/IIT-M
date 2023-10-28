 abstract class PA7_Base{
        public PA7_Base(){
              System.out.println("Base class constructor");
        }
   }   
   class PA7_Sub extends PA7_Base{
        public PA7_Sub(){
              System.out.println("Subclass constructor");
        }
   }
   public class PA7 {
        public static void main(String[] args){
               PA7_Base base=new PA7_Sub();
        }
   }