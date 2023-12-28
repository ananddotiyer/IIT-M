import java.util.logging.*;

class AQ1_3_Example implements Runnable {
    int start;

    AQ1_3_Example(int start) {
        this.start = start;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Child Thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AQ1_3_Example.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int end = (int) System.currentTimeMillis();
        int sec = (end - start) / 1000;
        System.out.println(sec + " seconds");
    }
}

class AQ1_3 {
    public static void main(String[] args) throws InterruptedException {
        int start = (int) System.currentTimeMillis();
        AQ1_3_Example e = new AQ1_3_Example(start);
        Thread t = new Thread(e);
        t.start();
        for (int i = 0; i < 2; i++) {
            System.out.println("Main Thread");
            Thread.sleep(1000);
        }
    }
}