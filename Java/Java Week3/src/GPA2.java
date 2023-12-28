import java.util.*;

class Shape {
    public int area() {
        return 0;
    }

    public int volume() {
        return 0;
    }
}

class GPA2_Rectangle extends Shape {
    private int w, h;

    // implement Rectangle class
    public GPA2_Rectangle(int w, int h) {
        this.w = w;
        this.h = h;
    }

    public int area() {
        return this.w * this.h;
    }
    // 15 8 20 == this is input
    // 120
    // 8000
}

class GPA2_Cube extends Shape {
    private int a;

    // implement Cube class
    public GPA2_Cube(int a) {
        this.a = a;
    }

    public int volume() {
        return this.a * this.a * this.a;
    }

}

public class GPA2 {
    private static void caller(Shape s) {
        // check if s is of type Rectangle
        if (s instanceof GPA2_Rectangle)
            System.out.println(s.area());
        // check if s is of type Cube
        if (s instanceof GPA2_Cube)
            System.out.println(s.volume());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int a = sc.nextInt();
        caller(new GPA2_Rectangle(w, h));
        caller(new GPA2_Cube(a));
    }
}