import java.util.Date;

class Timer {
    private PA10 e;

    public Timer(PA10 e) {
        this.e = e;
    }

    @SuppressWarnings("deprecation")
    void start(Date date) {
        if (date.getDay() == 6 || date.getDay() == 0) {
            e.notification1();
        } else {
            e.notification2();
        }
    }
}

public class PA10 {
    public void check() {
        Timer obj = new Timer(this);
        Date d = new Date();
        obj.start(d);
    }

    public void notification1() {
        System.out.println("Happy weekend...");
    }

    public void notification2() {
        System.out.println("Today is a working day, stay at work.");
    }

    public static void main(String[] args) {
        PA10 e = new PA10();
        e.check();
    }
}