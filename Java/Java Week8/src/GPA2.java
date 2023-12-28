import java.util.*;
class GPA2_Items implements Cloneable{
  public String[] item;
  public GPA2_Items(String[] a){
    item = a.clone();
  }
  public GPA2_Items clone() throws CloneNotSupportedException{
    GPA2_Items it = (GPA2_Items) super.clone();
    it.item = (String[]) item.clone();
    return it;
  }
  public String toString(){
    String s = "";
    for(int i = 0; i < item.length; i++){
      s = s + item[i]+ " ";
    }
    return s;
  }
}
class GPA2_Customer implements Cloneable{
  String name;
  GPA2_Items i;
  public GPA2_Customer(String n, GPA2_Items i){
    this.name = n;
    this.i = i;
  }
  public GPA2_Items getItems(){
    return this.i;
  }
  public void setName(String s){
    name = s;
  }
  public GPA2_Customer clone() throws CloneNotSupportedException{
    GPA2_Customer c = (GPA2_Customer)super.clone();
    GPA2_Items nitem = c.getItems().clone();
    c.i = nitem;
    return c;
  }
  public String toString(){
    return name + " " + i;
  }
}
public class GPA2 {
  public static void main(String[] args) throws CloneNotSupportedException{
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); // number of items
    String[] itm = new String[n];
    for(int i = 0; i < n; i++){
      itm[i] = sc.next(); // list of items
    } 
    var c1 = new GPA2_Customer("naresh", new GPA2_Items(itm));
    GPA2_Customer c2 = c1.clone();   
    c2.getItems().item[0] = sc.next();   //Update first item of c2
    c2.setName("suresh"); //Update name of c2
    System.out.println(c1);
    System.out.println(c2);
  }
}   