class PA1_Passenger implements Runnable {
    private String name;
    private int coach_no, seat_no;
    public boolean booked = false;

    public PA1_Passenger(String pass_name) {
        name = pass_name;
    }

    public void run() {
        coach_no = 10;
        seat_no = 52;
        booked = true;
    }

    public String getSeatAndPNR() {
        return (coach_no + " " + seat_no);
    }

    public String getName() {
        return name;
    }
}

public class PA1 {
    public static void main(String args[]) {
        PA1_Passenger p1 = new PA1_Passenger("P1");
        PA1_Passenger p2 = new PA1_Passenger("P2");
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        if (p1.booked == false && p2.booked == false) {
            t1.start();
        }
        if (p1.booked == false && p2.booked == false) {
            t2.start();
        }
        System.out.println(p1.getName() + " " + p1.getSeatAndPNR());
        System.out.println(p2.getName() + " " + p2.getSeatAndPNR());
    }
}