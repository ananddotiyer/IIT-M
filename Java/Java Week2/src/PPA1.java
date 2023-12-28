import java.util.*;
class Rectangle{
    int w;    //width
    int h;    //height
public void setw(int _w) { 
    w = _w;
}

public void seth(int _h) {
    h = _h;
}

public int area() {
    return w * h;
}  
}
public class PPA1{
	public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int w = Integer.parseInt(sc.nextLine());
        int h = Integer.parseInt(sc.nextLine());
        Rectangle r = new Rectangle();
        r.setw(w);
        r.seth(h);
        int area = r.area();
        System.out.print(area);
    }
}