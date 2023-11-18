import java.util.Scanner;

class Rectangle{
    private Point cp1;
    private Point cp2;
    public Rectangle(int x1, int y1, int x2, int y2){
        cp1 = new Point(x1, y1);
        cp2 = new Point(x2, y2);
        
    }
    int getWidth(){
        return (cp2.x - cp1.x);
    }
    int getHeight(){
        return (cp1.y - cp2.y);
    }
    private class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;

        }
    }
}
public class OPPE_2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        Rectangle r = new Rectangle(x1, y1, x2, y2);
        System.out.println("Area = " + r.getHeight() * r.getWidth());
        sc.close();
    }
}
