class GA1_A {
    public void display() {
        System.out.print("Hii ");
    }
}

public class GA1 extends GA1_A {
    public void display(String s) {
        display();
        System.out.println(s);
    }

    public static void main(String[] args) {
        GA1_A a = new GA1();
        //a.display("Ram");
        ((GA1)a).display("Ram");
    }
}