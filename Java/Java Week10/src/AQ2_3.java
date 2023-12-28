public class AQ2_3 extends Thread{
     public void run(){
          Thread thread=Thread.currentThread();
          System.out.println(thread.getName()+" "+thread.getPriority());
     }
     public static void main(String[] args) {
         AQ2_3 t1=new AQ2_3();
         AQ2_3 t2=new AQ2_3();
         AQ2_3 t3=new AQ2_3();
         t1.setPriority(10);
         t2.setPriority(5);
         t3.setPriority(1);
         t1.start();
         t2.start();
         t3.start();
     }
}