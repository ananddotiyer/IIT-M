 class GA2_Product implements Cloneable{
           private String prodname;
           private double prodprice;
           public GA2_Product(String prodname, double prodprice) {
                  this.prodname = prodname;
                  this.prodprice = prodprice;
           }
           public GA2_Product(GA2_Product p) {
                  this.prodname = p.prodname;
                  this.prodprice = p.prodprice;
           }
           public void setProdname(String prodname) {
                  this.prodname = prodname;
           }
           public void setProdprice(double prodprice) {
                  this.prodprice = prodprice;
           }
           public String toString() {
                  return prodname + " : " + prodprice;
           }
           protected GA2_Product clone() throws CloneNotSupportedException{
                  return (GA2_Product)super.clone();
           }
   }
   public class GA2{
          public static void main(String[] args) {
                 try {
                      GA2_Product p1 = new GA2_Product("Pen", 100.0);
                      GA2_Product p2 = new GA2_Product(p1);
                      GA2_Product p3 = p1;
                      GA2_Product p4 = p1.clone();
                      p1.setProdname("Pencil");
                      p1.setProdprice(30.0);
                      System.out.print(p1 + ", " + p2 + ", " + p3 + ", " + p4);
                  }
                  catch(CloneNotSupportedException e) {
                        System.out.println("clone() not supported");
                   }
            }
     }