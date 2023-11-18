interface Mock_Quiz1_7_Planet {
    default void show() {
        System.out.println("Planet interface");
    }
}
class Mock_Quiz1_7_Earth implements Mock_Quiz1_7_Planet {
    // Gives compilation error, because public method in interface 
    // can't be redefined as default method in child class
    // void show() {
    //     System.out.println("Earth class");
    // }

    public void show() {
        System.out.println("Earth class");
    }
    public void getPeriod() {
        System.out.println("365.26");
    }
}
public class Mock_Quiz1_7 {
    public static void main(String[] args) {
        // Planet p1 = new Earth(); //Planet interface reference type doesn't have getPeriod method.
        Mock_Quiz1_7_Earth p1 = new Mock_Quiz1_7_Earth();
        p1.show();
        p1.getPeriod();
    }
}
