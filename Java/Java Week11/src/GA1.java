class GA1_PrlSequence extends Thread{
      int init;
      public GA1_PrlSequence(int i) {        
           init = i;
      }
      public void run(){
             for(int i = init; i <= init + 5; i++) {
                   System.out.print(i + " ");
                    try {
                         sleep(500);
                         }
                        catch(InterruptedException e) {}
              }
        }
}
public class GA1{
      public static void main(String[] args) throws InterruptedException{
            Thread th1 = new GA1_PrlSequence(10);
            Thread th2 = new GA1_PrlSequence(20);
            Thread th3 = new GA1_PrlSequence(30);
             th1.start();
             th2.start();
             th1.join();
             th2.join();
             th3.start();
   }
}