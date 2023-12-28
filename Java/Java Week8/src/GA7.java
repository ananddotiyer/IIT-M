     import java.util.stream.*;
     import java.util.*;
     class GA7_Product{
            private String name;
            private double price;
            public GA7_Product(String n, double p){
                   name = n;
                   price = p;
            }
            public double getPrice(){
                   return price;
            }
            public String toString(){
                   return name + " : " + price;
            }
     }
     public class GA7{
            public static void main(String[] args){
                   var pList = new ArrayList<GA7_Product>();
                   pList.add(new GA7_Product("Pen", 10.0));
                   pList.add(new GA7_Product("Pencil", 5.0));
                   pList.add(new GA7_Product("Notebook", 40.0));
                   pList.add(new GA7_Product("Eraser", 8.0));
 
                //    var outputList = pList.stream().filter(x -> x.getPrice() >= 10);
                   var outputList = pList.stream().filter((GA7_Product x) -> x.getPrice() >= 10);
                   outputList.forEach(n -> System.out.println(n));
             }
      }