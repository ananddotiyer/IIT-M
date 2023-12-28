interface PA1_Shape {
    public double area();

    public default double volume() {
        return -1.0;
    }
}

interface PA1_Printable {
    public default void print() {
        System.out.println("not implemented");
    }
}

class PA1_Rectangle implements PA1_Shape, PA1_Printable {
    private double w, h;

    public PA1_Rectangle(double w_, double h_) {
        w = w_;
        h = h_;
    }

    public double area() {
        return w * h;
    }

    public void print() {
        System.out.print(area() + " ");
        System.out.print(volume());
    }
}

public class PA1 {
    public static void main(String[] args) {
        PA1_Rectangle r = new PA1_Rectangle(20.0, 50.0);
        r.print();
    }
}