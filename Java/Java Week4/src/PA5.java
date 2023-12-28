abstract class NewYear {
    abstract String resolution();

    public NewYear() {
        System.out.println("Resolution: ");
    }
}

public class PA5 extends NewYear {
    public String resolution() {
        return "Walk up early, exercise and take shower everyday.";
    }

    public static void main(String args[]) {
        System.out.print(new PA5().resolution());
    }
}