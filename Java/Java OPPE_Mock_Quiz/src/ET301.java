class ET301_Baker{
    int bread_count;
    public synchronized void make(int order_amt) {
        bread_count += order_amt;
        System.out.println("Inside make(), bread count = " + bread_count);
    }
    public synchronized void eat(int order_amt) {
        if (bread_count >= order_amt) {
            bread_count -= order_amt;
            System.out.println("Inside make(), bread count = " + bread_count);
        }
    }
}

class ET301_ThreadUtil extends Thread{
    ET301_Baker obj;
    public ET301_ThreadUtil(ET301_Baker o, String t_name) {
        super(t_name);
        obj = o;
    }
    public void run(){
        if (Thread.currentThread().getName().contains("maker"))
            obj.make(5);
        else
            obj.eat(10);
    }
}

public class ET301{
    public static void main(String[] args) {
        ET301_Baker my_acc = new ET301_Baker();
        ET301_ThreadUtil t1 = new ET301_ThreadUtil(my_acc, "maker1");
        ET301_ThreadUtil t2 = new ET301_ThreadUtil(my_acc, "eater1");
        ET301_ThreadUtil t3 = new ET301_ThreadUtil(my_acc, "maker2");
        ET301_ThreadUtil t4 = new ET301_ThreadUtil(my_acc, "eater2");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}