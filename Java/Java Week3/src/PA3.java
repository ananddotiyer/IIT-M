class Animals {
    // final public void swim() { // final cannot be overridden in subclass.
    public void swim() {
        System.out.println("Animals swim");
    }

    // public static void communicate() { //static can only be overridden as static
    public void communicate() {
        System.out.println("Animals communicate");
    }
}

public class PA3 extends Animals {
    public void swim() {
        System.out.println("Birds swim");
    }

    public void communicate() {
        System.out.println("Birds communicate");
    }

    public void fly() {
        System.out.println("Birds fly");
    }
}