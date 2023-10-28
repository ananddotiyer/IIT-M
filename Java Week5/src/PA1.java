abstract class OutputDevice{
       public abstract void output();
}
class Printer extends OutputDevice{
       public void output() {
              System.out.println("printer prints");
       }
}
class Monitor extends OutputDevice{
      public void output() {
              System.out.println("monitor displays");
      }
}
interface Iterable{
      public boolean has_next();
      public Object get_next();
}
class OutputList implements Iterable{
     private final int max_limit = 2;
     private int indx;
     private Object[] oArr = {new Printer(), new Monitor()};
     public OutputList(){
               indx = -1;
     }
     public boolean has_next() {
              if (indx < max_limit - 1)
                   return true;
              return false;
     }
     public Object get_next() {
              indx++;
              return oArr[indx];
     }
}
public class PA1{
     public static void main(String[] args) {
             OutputList list = new OutputList();
             while(list.has_next()) {
                   ((OutputDevice)list.get_next()).output();
             }
      }
}