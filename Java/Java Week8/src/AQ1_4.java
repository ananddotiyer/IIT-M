class AQ1_4_Example implements Cloneable{
     int x;
     int y;
     AQ1_4_Example(int a,int b){
         this.x=a;
         this.y=b;
     }
     public String toString(){
          return ""+x+y;
     }
     public Object clone() throws CloneNotSupportedException{
          return super.clone();
     }
}
public class AQ1_4{
      public static void main(String[] args) throws Exception{
           AQ1_4_Example obj=new AQ1_4_Example(0,1);
           AQ1_4_Example obj2=(AQ1_4_Example)obj.clone();
           obj2.x=2;
           System.out.println(obj);
           System.out.println(obj2);
      }
}