   class PA6_Rectangle{
       private final void computeArea(){
             System.out.println("area of rectangle");
       }
   }
   class PA6_Cube extends PA6_Rectangle{
       public final void computeArea(){
            System.out.println("area of cube");
       }
   }
   public class PA6{
       public static void main(String[] args){
            PA6_Cube r = new PA6_Cube();
            r.computeArea();
       }
   }