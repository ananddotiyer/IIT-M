class AQ1_2_Example{
      int x;
      int y;
      AQ1_2_Example(){

      }
      AQ1_2_Example(int a,int b){
            this.x=a;
            this.y=b;
      }
      public String toString(){
             return ""+x+y;
      }
}
public class AQ1_2{
      public static void main(String[] args){
             AQ1_2_Example obj=new AQ1_2_Example(0,1);
             AQ1_2_Example obj2=new AQ1_2_Example();
             obj2.x=obj.x;
             obj2.y=obj.y;
             obj2.x=2;
             System.out.println(obj);
             System.out.println(obj2);
      }
}