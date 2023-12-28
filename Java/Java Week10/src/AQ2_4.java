class AQ2_4_BookMyMovie implements Runnable{
     int available=1,wanted;
     public AQ2_4_BookMyMovie(int wanted) {
          this.wanted=wanted;
     }
     public void run() {
          String name=Thread.currentThread().getName();
          if(wanted<=available) {
              System.out.println("Ticket booked for "+name);
              try {
                    Thread.sleep(1000);
              }
              catch (InterruptedException e) {
                   e.printStackTrace();
              }
              available = available - wanted;
        }
        else {
             System.out.println("No tickets are available for "+name);
         }
    }
}
public class AQ2_4 {
    public static void main(String[] args) {
         AQ2_4_BookMyMovie ticket = new AQ2_4_BookMyMovie(1);
         Thread t1 = new Thread(ticket,"Jock");
         Thread t2 = new Thread(ticket,"John");
         t1.start();
         t2.start();
     }
}