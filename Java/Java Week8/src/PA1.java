    class PA1_ComplexNum implements Cloneable{
         private double r, i;
         public PA1_ComplexNum(double r, double i) {
              this.r = r;
              this.i = i;
         }
         public void setRe(double r) {
              this.r = r;
         }
        public void setIm(double i) {
              this.i = i;
         }
        public String toString() {
              return "(" + r + " + " + i + "i)";
        }
        public Object clone() throws CloneNotSupportedException{
              return super.clone();
        }
    }
   public class PA1{
       public static void main(String[] args) {
             try {
                  PA1_ComplexNum c1 = new PA1_ComplexNum(10.0, 20.0);
                  PA1_ComplexNum c2 = c1;
                  PA1_ComplexNum c3 = (PA1_ComplexNum)c1.clone();
                  c1.setRe(100.0);
                  c1.setIm(200.0);
                  System.out.println(c1 + " , " + c2 + ", " + c3);
             }
            catch(CloneNotSupportedException e) {
                 System.out.println("clone() not supported");
            }
       }
   }