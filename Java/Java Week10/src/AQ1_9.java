public class AQ1_9 extends Thread {
    public void run() {
        System.out.println("Thread running");
    }

    public static void main(String[] args) {
        AQ1_9 t1 = new AQ1_9();
        t1.start();
        t1.start(); //Can't start same thread twice, will result in IllegalThreadStateException.
    }
}