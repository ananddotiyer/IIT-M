class Mock_Quiz1_3_Base {
    public Mock_Quiz1_3_Base() {
        System.out.println("Inside Base");
    }

    public Mock_Quiz1_3_Base(String arg) {
        System.out.println("Inside Base " + arg);
    }
}

class Mock_Quiz1_3_Sub extends Mock_Quiz1_3_Base {
    public Mock_Quiz1_3_Sub(String arg) {
        System.out.println("Inside Sub " + arg);
    }
}

public class Mock_Quiz1_3 {
    public static void main(String args[]) {
        Mock_Quiz1_3_Base b = new Mock_Quiz1_3_Sub("Test");
    }
}