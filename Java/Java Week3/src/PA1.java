class PA1_Example1 {
    public int a = 10;

    public void display() {
        System.out.print("In parent class");
    }
}

public class PA1 extends PA1_Example1 {
    public int b = 20;

    public void display() {
        System.out.println("In child class");
    }

    public static void main(String[] args) {
        PA1_Example1 obj = new PA1();
        obj.display();
    }
}