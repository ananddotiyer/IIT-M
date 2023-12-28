class PA17_A{
     public String features(){
           return "Write Once, Run Anywhere.";
     }
}
class PA17_B extends PA17_A{
      public String features(){
            return "Object Oriented.";
      }
}
class PA17_C extends PA17_A{
   public String features(){
     return "Multithreaded.";
   }
}
public class PA17{
       public static void main(String args[]){
              PA17_A obj1 = new PA17_A();
              PA17_A obj2 = new PA17_B();
              PA17_A obj3 = new PA17_C();
              System.out.print(obj1.features()+"\n"
              +obj2.features()+"\n"+obj3.features());
       }
}