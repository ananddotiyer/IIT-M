   interface GA7_Animal{
        void sound();
        default void eat(String animal){
              System.out.println(animal+" eats every day");
         }
   }
   class GA7_Cat implements GA7_Animal{
        public void sound(){
             System.out.println("Cat meows");
        }
   }
   class GA7_Dog implements GA7_Animal{
         public void sound(){
              System.out.println("Dog barks");
          }
   }
   public class GA7{
        public static void main(String[] args){
              GA7_Animal oa1=new GA7_Cat();
              oa1.sound();
              oa1.eat("Cat");
              GA7_Animal oa2=new GA7_Dog();
              oa2.sound();
              oa2.eat("Dog");
          }
   }