class PA2_Polygon {
    public void perimeter() {
        System.out.print("In Polygon perimeter");
    }

    public void angleSum() {
        System.out.println("In Polygon angleSum");
    }
}

public class PA2 extends PA2_Polygon {
    public void perimeter() {
        System.out.println("In Pentagon perimeter");
    }

    public void angleSum(int x) {
        System.out.println("In Pentagon angleSum");
    }
}