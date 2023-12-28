class GA5_BookTicket{
     int available=3;
     synchronized void extract(String name,int book){
          if (book<=available){
                 System.out.println(name + " booked " + book + " ticket.");
                 available = available - book;
                //  System.out.println(available + " tickets left.");
          }
          else {
                 System.out.println(name + ", you can not book " + book + " ticket.");
                 System.out.println("Tickets available: " + available);
           }
      }
}
class GA5_Passenger implements Runnable{
       GA5_BookTicket bt;
       String name;
        int number;
        GA5_Passenger(GA5_BookTicket b, String n, int num){
             this.bt = b;
             this.name = n;
             this.number = num;
         }
         public void run(){
                bt.extract(name, number);
         }
}
public class GA5 {
     public static void main(String[] args){
        //Note that t1, t2 and t3 are working on different objects,  That's why it's able to book more than 3 tickets.  If they were working on a single object, then only 3 tickets will be available in total.
           GA5_BookTicket obj = new GA5_BookTicket();
           GA5_BookTicket obj1 = new GA5_BookTicket();
           GA5_BookTicket obj2 = new GA5_BookTicket();
           Thread t1 = new Thread(new GA5_Passenger(obj, "Sun", 2));
           Thread t2 = new Thread(new GA5_Passenger(obj1, "Moon", 1));
           Thread t3 = new Thread(new GA5_Passenger(obj2, "Earth", 2));
            t1.start();
            t2.start();
            t3.start();
     }
}