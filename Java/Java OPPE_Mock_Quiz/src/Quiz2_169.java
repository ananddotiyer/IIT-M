
abstract class Shape {
    public abstract double area();
}

class Quiz2_169_Rectangle extends Shape {
    // instance variables and constructors here
    int l, b;

    public Quiz2_169_Rectangle(int l, int b) {
        this.l = l;
        this.b = b;
    }

    public double area() {
        return Double.valueOf((l * b));
    }
}

class Quiz2_169_Triangle extends Shape {
    int h, b;

    public Quiz2_169_Triangle(int h, int b) {
        this.h = h;
        this.b = b;
    }

    public double area() {
        return Double.valueOf((0.5 * h * b));
    }
}

public class Quiz2_169 {
    public static <T extends Shape> double maxArea(T[] arr) {
        double max = arr[0].area();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].area() > max) {
                max = arr[i].area();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Quiz2_169_Rectangle[] r = { new Quiz2_169_Rectangle(5, 4),
                new Quiz2_169_Rectangle(3, 4),
                new Quiz2_169_Rectangle(15, 14),
                new Quiz2_169_Rectangle(15, 13),
                new Quiz2_169_Rectangle(14, 16),
                new Quiz2_169_Rectangle(15, 16) };
        Quiz2_169_Triangle[] t = { new Quiz2_169_Triangle(5, 4),
                new Quiz2_169_Triangle(3, 4),
                new Quiz2_169_Triangle(15, 14),
                new Quiz2_169_Triangle(15, 13),
                new Quiz2_169_Triangle(14, 16),
                new Quiz2_169_Triangle(15, 16) };

        double max_rect = maxArea(r);
        double max_trian = maxArea(t);
        System.out.println("Largest area in rectangles: " + max_rect);
        System.out.println("Largest area in triangles: " + max_trian);
    }
}
