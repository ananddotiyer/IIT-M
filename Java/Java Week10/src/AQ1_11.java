class AQ_11_A implements Runnable {
    public void run() {
        int i = 2;
        while (i != 0) {
            System.out.println("t2 thread");
            i = i - 1;
        }
    }
}

public class AQ1_11 {
    public static void main(String args[]) {
        AQ_11_A obj = new AQ_11_A();
        Thread t2 = new Thread(obj);
        t2.start();
        int i = 2;
        while (i != 0) {
            System.out.println("Main thread");
            i = i - 1;
        }
    }
}