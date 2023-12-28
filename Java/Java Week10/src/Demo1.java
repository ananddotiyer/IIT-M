class Demo1_Example implements Runnable {
    public void run() {
        for (int i = 1; i < 3; i++) {
            System.out.print(i + " ");
        }
    }
}

public class Demo1 {
    public static void main(String[] args){
        Demo1_Example e = new Demo1_Example();
        Thread t = new Thread(e);
        t.start();
        for (int i = 3; i <= 5; i++) {
            System.out.print(i + " ");
        }
    }
}