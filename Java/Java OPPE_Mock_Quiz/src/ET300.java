abstract class ET300_Op implements Runnable{
    static int product = 1;
}

class ET300_Op1 extends ET300_Op{
    public void run() {
        if (product != 3) {
            product *= 2;
        }
    }
}

class ET300_Op2 extends ET300_Op{
    public void run() {
        if (product != 2) {
            product *= 3;
        }
    }
}

public class ET300 {
    public static void main(String[] args) {
        ET300_Op o1 = new ET300_Op1();
        ET300_Op o2 = new ET300_Op2();
        Thread t1 = new Thread(o1);
        Thread t2 = new Thread(o2);

        t1.start();
        t2.start();

        System.out.println(ET300_Op.product);
    }
}
