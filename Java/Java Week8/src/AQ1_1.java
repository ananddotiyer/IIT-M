class AQ1_1_Example{
    int x;
    int y;
    AQ1_1_Example(int a,int b){
         this.x=a;
         this.y=b;
    }
    public String toString(){
          return ""+x+y;
    }
}
public class AQ1_1{
    public static void main(String[] args){
          AQ1_1_Example obj=new AQ1_1_Example(0,1);
          AQ1_1_Example obj2=obj;
          obj2.x=2;
          System.out.println(obj);
          System.out.println(obj2);
    }
}