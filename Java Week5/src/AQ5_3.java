class AQ5_3_Example<T1,T2 extends Number>{
      T1 ob1;
      T2 ob2;
      void push(T1 obj){
          this.ob1=obj;
          System.out.println(ob1);
      }
      void push(T2 obj){
          this.ob2=obj;
          System.out.println(ob2);
      }
 }
 class AQ5_3{
      public static void main(String[] args){
          AQ5_3_Example<String,Integer> s = new AQ5_3_Example<String,Integer>();
          s.push("Hello");
      }
 }