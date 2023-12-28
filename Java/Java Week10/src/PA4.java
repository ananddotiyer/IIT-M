class PA4_PrlCls extends Thread{
     private int init;
     public PA4_PrlCls(int n){
         init = n;
     }
     public void run(){
         for(int i = init; i <= init + 5; i++){
              System.out.print(i + " ");
              try{
                   Thread.sleep(1000);
              }
              catch(InterruptedException e){}
         }
     }
}
public class PA4{
     public static void main(String[] args){
         Thread t1 = new PA4_PrlCls(10);
         Thread t2 = new PA4_PrlCls(20);
         t1.start();
         for(int i = 30; i < 35; i++){
              System.out.print(i + " ");
         }
         t2.start();
     }
}
