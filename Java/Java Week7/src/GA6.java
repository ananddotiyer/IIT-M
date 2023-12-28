public class GA6{
      public static void main(String[] args) {
           try{
               int a=10/0;
           }
           finally{
                System.out.println("In finally block");
           }
           System.out.println("Program execution finished");
      }
}