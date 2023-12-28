package OPPE2;
import java.util.*;

abstract class Q3_Shape{
    abstract double area();
}


class Q3_Rectangle extends Q3_Shape{
    int length, breadth;
    public Q3_Rectangle(int l, int b){
        length = l;
        breadth = b;
    }
    public double area(){
        return length * breadth;
    }
}

class Q3_Square extends Q3_Shape{
    int side;
    public Q3_Square(int side){
        this.side = side;
    }

    public double area(){
        return side * side;
    }
}

public class Q3 {
    public static double findMaxArea(List<Q3_Shape> list){
        double max_area = 0;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            double area = ((Q3_Shape)it.next()).area();
            if (area > max_area)
                max_area = area;
        }
        return max_area;
    }
    public static void main(String[] args) {
        Q3_Rectangle r1 = new Q3_Rectangle(7, 4);
        Q3_Rectangle r2 = new Q3_Rectangle(5, 6);
        Q3_Rectangle r3 = new Q3_Rectangle(12, 4);

        List<Q3_Shape> rList = new ArrayList<>();
        rList.add(r1);
        rList.add(r2);
        rList.add(r3);

        Q3_Square s1 = new Q3_Square(4);
        Q3_Square s2 = new Q3_Square(6);
        Q3_Square s3 = new Q3_Square(5);
        
        List<Q3_Shape> sList = new ArrayList<>();
        sList.add(s1);
        sList.add(s2);
        sList.add(s3);
        
        System.out.println(findMaxArea(rList));
        System.out.println(findMaxArea(sList));
    }
}
