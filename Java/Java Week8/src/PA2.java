class PA2_Product{
     private String prodname;
     private double prodprice;
     public PA2_Product(String prodname, double prodprice) {
          this.prodname = prodname;
          this.prodprice = prodprice;
     }
     public void updateProduct(String prodname, double prodprice) {
          this.prodname = prodname;
          this.prodprice = prodprice;
     }
     public String toString() {
          return prodname + " : " + prodprice;
     }
}
class PA2_Order implements Cloneable{
     private int orderid;
     private PA2_Product prod;
     public PA2_Order(int orderid, PA2_Product prod) {
         this.orderid = orderid;
         this.prod = prod;
     }
     public PA2_Order clone() throws CloneNotSupportedException{
         return (PA2_Order)super.clone();
     }
     public void updateOrder(int orderid, String prodname, double prodprice) {
         this.orderid = orderid;
         prod.updateProduct(prodname, prodprice);
    }
   public String toString() {
        return orderid + " : " + prod;
    }
}
public class PA2{
    public static void main(String[] args) {
         try {
              PA2_Order od1 = new PA2_Order(1001, new PA2_Product("Pen", 15.0));
              PA2_Order od2 = od1.clone();
              od1.updateOrder(1010, "Pencil", 20.0);
              System.out.print(od1 + ", " + od2);
              }
              catch(CloneNotSupportedException e) {
              System.out.println("clone() not supported");
         }
     }
}