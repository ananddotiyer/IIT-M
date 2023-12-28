class AQ4_7_Developer{
      static String message(String Designation){
           return Designation+" Throw illegal value exception if X>100";
      }
}
public class AQ4_7{
     public static void main(String[] args){
            int x=100;
            // assert(x<100): "How";
            assert(x<=100): AQ4_7_Developer.message("Tester: ");
            System.out.println(x);
     }
}