interface PA6_Rectangle{
     abstract int areaRectangle(int length,int breadth);
}
interface PA6_Circle{
     abstract int areaCircle(int radius);
}
interface PA6_Shape extends PA6_Rectangle,PA6_Circle{

}
class PA6_TwoDimension implements PA6_Shape{
      public int areaRectangle(int length,int breadth){
          return length*breadth;
      }
      public int areaCircle(int radius){
          return (int)(Math.PI*Math.pow(radius,2));
      }
}
public class PA6{
      public static void main(String[] args){
          PA6_TwoDimension ref=new PA6_TwoDimension();
          System.out.println("The area of the rectangle is: " + ref.areaRectangle(5,2)
          +"\n"+"The area of the Circle is: "+ref.areaCircle(5));
      }
}