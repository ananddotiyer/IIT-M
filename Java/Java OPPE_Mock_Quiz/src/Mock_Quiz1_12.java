interface Traversable{
     void printForward();
}
interface BiTraversable extends Traversable{
      void printBackward();
}
abstract class List1{
       public abstract void add(Object elem);
}
class IntList extends List1{
    private final int N = 5;
    private int iArr[];
    public IntList(int arr[]) {
        iArr = arr;
    }
    public void add(Object elem) {
        //add element elem to iArr
    }
    Traversal getTraversalObj() {
        return new Traversal();
    }
    private class Traversal implements BiTraversable{
        public void printForward() {
            for(int i = 0; i < N; i++)
               System.out.print(iArr[i] + " ");
        }
        public void printBackward() {
            for(int i = N - 1; i >= 0; i--)
                System.out.print(iArr[i] + " ");
        }
    }
}
public class Mock_Quiz1_12{
    public static void main(String[] args) {
         int[] arr = {10, 20, 30, 40, 50};
         IntList iList = new IntList(arr);
         Traversable tr1 = iList.getTraversalObj();
          tr1.printForward();
          System.out.println();
          BiTraversable tr2 = iList.getTraversalObj();
          tr2.printBackward();
        //   tr2.printForward(); //also works
     }
}