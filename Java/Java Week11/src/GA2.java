class GA2_CakeOperation {
      int available_cake_count=0;
      boolean eating_permit = false;

      synchronized void eatCake() {
             while(eating_permit == false) {
                    try {
                    wait();
                   }catch(InterruptedException e) {}
             }
             available_cake_count--;
             System.out.println("Ate one cake. Cakes left: "+ available_cake_count);

             eating_permit = false;
             notify();
      }
      synchronized void makeCake() {

             if (eating_permit == true) {
                try {
                    wait();
                } catch(InterruptedException Ex) {}
             }
             available_cake_count++;
             System.out.println("Made one cake. Cakes left: "+ available_cake_count);
             eating_permit = true;
             notify();
        }
    }
    class GA2_Baker implements Runnable {
    GA2_CakeOperation obj;
    GA2_Baker(GA2_CakeOperation o) {
         obj = o;
         Thread Producer = new Thread(this);
         Producer.start();
    }
    public void run() {
         int cake_number = 1;
         while(cake_number <= 2) {
               obj.makeCake();
               cake_number++;
         }
     }
}
class GA2_Consumer implements Runnable {
 GA2_CakeOperation obj;
 GA2_Consumer(GA2_CakeOperation o) {
     obj = o;
     Thread consumer = new Thread(this);
     consumer.start();
  }
  public void run() {
         int iteration = 0;
         while(iteration < 2) {
                 obj.eatCake();
                 iteration++;
         }
   }
}
public class GA2 {
       public static void main(String args[]) {
             GA2_CakeOperation obj = new GA2_CakeOperation();
             GA2_Baker b1 = new GA2_Baker(obj);
             GA2_Consumer c1 = new GA2_Consumer(obj);
       }
}