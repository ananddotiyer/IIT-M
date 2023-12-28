class GA8_PrlCls1 extends Thread{
     public void run(){
          for(int i = 1; i <= 10; i++){
               System.out.print(i + " ");
               try{
                    Thread.sleep(1000);
               }
               catch(InterruptedException e){}
          }
     }
}
class GA8_PrlCls2 extends Thread{
     public void run(){
          for(int i = 11; i <= 20; i++){
               System.out.print(i + " ");
               try{
                    Thread.sleep(1000);
               }
               catch(InterruptedException e){}
          } 
     }
}
public class GA8{
     public static void main(String[] args){
          Thread t1 = new GA8_PrlCls1();
          Thread t2 = new GA8_PrlCls2();
          t1.run(); //This will run t1 first and then t2.
            // t1.start(); //This would interleave the output from t1 and t2.
          t2.start();
     }
}