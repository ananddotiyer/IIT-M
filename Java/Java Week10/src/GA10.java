class GA10_ATM implements Runnable{
    private String name;
    static double balance = 100.0;
    public GA10_ATM(String name){
        this.name = name;
    }
    public void deposit(double a){
        balance = balance + a;
    }
    public void withdraw(double a){
        balance = balance - a;
    }
    public void displayBalance(){
        System.out.println(balance);
    }
    public void run(){
        if(name.equals("deposit")){
             deposit(100);
             displayBalance();
        }
        if(name.equals("withdraw")){
              withdraw(200);
              displayBalance();
        }
    }
}
public class GA10 {
    public static void main(String[] args) {
         GA10_ATM m1 = new GA10_ATM("deposit");
         GA10_ATM m2 = new GA10_ATM("withdraw");
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);
        t1.start();
        t2.start();
    }
}