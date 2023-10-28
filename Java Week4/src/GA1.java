interface GA1_Printable{
    public default void print() {
         System.out.println("not implemented");
     }
  }

  abstract class GA1_Collection{
     public void print() {
         System.out.println("no element");
     }
   }

  class GA1_Queue extends GA1_Collection implements GA1_Printable{
     public void print() {
         super.print();
         System.out.println("print the queue");
     }
  }

  public class GA1{
      public static void main(String[] args) {
         GA1_Queue q = new GA1_Queue();
         q.print();
     }
  }