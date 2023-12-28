public class AQ2_2 extends Thread{
     public void run(){
          String name=Thread.currentThread().getName();
          System.out.println("Name of the thread is "+name);
     }
     public static void main(String[] args) {
          AQ2_2 t1=new AQ2_2();
          AQ2_2 t2=new AQ2_2();
          AQ2_2 t3=new AQ2_2();
           t1.start();
           t2.start();
           t3.start();
      }
}