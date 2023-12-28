
class ET90_Counter implements Runnable {
    boolean stopRequested = false;
    long count = 0;

    public void run() {
        while (!stopRequested) {
            count++;
            if (count == 1000000) {
                stopRequested = true;
            }
        }
    }

    public void setStop(boolean stop) {
        stopRequested = stop;
    }

    public long getCount() {
        return count;
    }
}

public class ET90 {
    public static void main(String[] args) throws InterruptedException {
        ET90_Counter ctr = new ET90_Counter();
        Thread backgroundThread = new Thread(ctr);
        backgroundThread.start();

        Thread.sleep(1); //If changed to 1000, the program will print 1000000
        ctr.setStop(true);
        System.out.println(ctr.getCount());
    }
}
