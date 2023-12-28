class DOBRegistration {
    private int day, month, year;

    public DOBRegistration(int day, int month, int year) {
        assert 0 < day && day <= 31 : "day :" + day; // assert-1
        this.day = day;
        assert 0 < month && month <= 12 : "day :" + day; // assert-2
        this.month = month;
        this.year = year;
    }
}

class JobApplication {
    private int age, exp;

    public JobApplication(int age, int exp) {
        assert age >= 18 : "invalid age for job"; // assert-3
        this.age = age;
        assert exp >= 3 : "invalid experience for job"; // assert-4
        this.exp = exp;
    }
}

public class PA4 {
    public static void main(String[] args) {
        DOBRegistration dr = new DOBRegistration(2, 23, 1879);
        JobApplication ja = new JobApplication(20, 1);
    }
}