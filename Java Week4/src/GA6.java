   class GA6_Language{
        public void show(){
              System.out.println("In Language class");
        }
        public class Programming{
              public void show(){
                    System.out.println("In Programming class");
              }
        }
   }
   public class GA6 {
         public static void main(String[] args) {
            new GA6_Language().new Programming().show();
        }
   }