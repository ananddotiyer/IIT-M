import java.util.*;
class AQ3_6{
      public static void main(String[] args){
              ArrayList<String> list=new ArrayList<String>();
              list.add("Hello");
              list.add("Hola");
              list.add("Hey");
              adding(list);
              System.out.println(list);
      }
      // If parameter l is declared as ArrayList<String>, 
      // only String can be added to l, else all objects are allowed.
      static void adding(ArrayList l){
              l.add(false);
              l.add(10);
      }
}