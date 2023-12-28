class TotalEarned{
      int sum=0;
      public TotalEarned() {}
      void calculate(int n,int price){
         synchronized(this){
             for(int i=0;i<n;i++){
                sum=sum+price;
        }
             this.notifyAll();
        }
     }
}
class Ticket extends Thread{
     TotalEarned obj;
     int number;
     int price;
     public Ticket(TotalEarned obj, int number, int price) {
        this.obj = obj;
        this.number = number;
        this.price = price;
    }
    public void run(){
       obj.calculate(number,price);
    }
}
public class AQ11_1{
   public static void main(String[] args) throws InterruptedException{
        TotalEarned obj=new TotalEarned();
        Ticket t=new Ticket(obj,10,5);
        t.start();
        synchronized(obj){
              obj.wait(100);
              System.out.println(obj.sum);
        }
   }
}