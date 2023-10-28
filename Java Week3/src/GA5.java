class GA5_Shape {
    public void area() {
        System.out.println("area is unknown");
    }

    public void volume() {
        System.out.println("volume is unknown");
    }
}

class GA5_Rectangle extends GA5_Shape {
    public void area() {
        System.out.println("area of Rectangle");
    }
}

class GA5_Cube extends GA5_Shape {
    public void area() {
        System.out.println("area of Cube");
    }

    public void volume() {
        System.out.println("volume of Cube");
    }
}

public class GA5 {
    public static void compute(GA5_Shape s) {
        s.area();
        s.volume();
    }

    public static void main(String[] args) {
        GA5_Rectangle r = new GA5_Rectangle();
        GA5_Cube c = new GA5_Cube();
        compute(r);
        compute(c);
    }
}