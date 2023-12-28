public class AQ1_10 extends Thread{
      public void run(){
             Thread t = Thread.currentThread();
             System.out.println(t.isAlive());
             try {
                  Thread.sleep(1000);
             }
             catch (InterruptedException e) {
                   e.printStackTrace();
             }
            System.out.println(t.isAlive());
      }
      public static void main(String[] args) {
       AQ1_10 t1=new AQ1_10();
           t1.start();
      }
}