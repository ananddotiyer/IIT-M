import java.util.logging.*;
class GA7_Example extends Thread{
       Thread t;
       GA7_Example(Thread t){
            this.t = t;
        }
        public void run(){
              try {
                   t.join();
             } catch (InterruptedException ex) {
                    Logger.getGlobal().log(Level.SEVERE, ex.getMessage());
             }
             for(int i = 1; i < 3; i++){
                       System.out.print(i + " ");
             }
       }
}
public class GA7{
        public static void main(String[] args) throws InterruptedException{
            Thread t1 = Thread.currentThread();
             GA7_Example t2 = new GA7_Example(t1);
             t2.start();
             for(int i = 3; i <= 5; i++){
                  System.out.print(i + " ");
             }
        }
}