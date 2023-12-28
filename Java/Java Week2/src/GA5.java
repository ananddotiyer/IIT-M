class Point {
    private int x;
    private int y;

    public Point(int x, int z) {
        this.x = x; //Use this.x to distinguish from parameter x.
        y = z;
    }

    public void printPoint() {
        System.out.println("(" + x + ", " + y + ")");
    }
    
    //Override toString() with same method content as printPoint.
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class GA5 {
    public static void main(String[] args) {
        Point p = new Point(10, 20);
        p.printPoint(); //(10, 20)
        System.out.println(p); //(10, 20)
    }
}