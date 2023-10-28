class PA11_Numbers {
    public int x = 1;
    public double y = 2.1;

    public PA11_Numbers(int a, double b) {
        add(a, a);
        add(b, a);
    }

    public void add(int a, int b) {
        this.x = a + b;
    }

    public void add(double c, int d) {
        this.y = c + d;
    }
}

public class PA11 {
    public static void main(String args[]) {
        PA11_Numbers obj = new PA11_Numbers(2, 3.2);
        System.out.println(obj.x + " " + obj.y);
    }
}