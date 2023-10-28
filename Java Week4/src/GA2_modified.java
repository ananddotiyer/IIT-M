interface Shape{
         public double area();
         public default double volume() {
              return -1.0;
         }
     }

     interface Printable{
          public default void print() {
                System.out.println("not implemented");
         }
    }

    class Rectangle implements Shape, Printable{
          private double w, h;
          public Rectangle(double w_, double h_) {
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

     public class GA2_modified{
           public static void main(String[] args) {
            //   Shape s = new Rectangle(20.0, 50.0);
              Rectangle s = new Rectangle(20.0, 50.0);
              s.print();
        }
     }