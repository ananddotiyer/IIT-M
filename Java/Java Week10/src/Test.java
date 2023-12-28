class AriThread implements Runnable{
    int a, b, c;
    public AriThread(int a1, int b1, int c1) {
        a = a1;
        b = b1;
        c = c1;
    }
    public void arithOp(){
        a = a + b;
        a = a - c;
    }
    public void run() {
        arithOp();
        System.out.println("Final: " + a);
    }
}

public class Test{
    public static void main(String[] args) {
        AriThread s = new AriThread(5, 3, 2);
        // AriThread s1 = new AriThread(5, 3, 2);
        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        t1.start();
        t2.start();
    }
}