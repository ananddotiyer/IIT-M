import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Test{
    public static void main(String[] args) {
        ArrayList<Character> a = new ArrayList<Character>();    
        a.add('A');
        a.add('B');
        a.add('C');

        ListIterator<Character> iter = a.listIterator();
        System.out.println(iter.next()); //A.  Now, pointer is between A and B.
        System.out.println(iter.next()); //B.  Now, pointer is between B and C.
        System.out.println(iter.previous());  //B.  Now, pointer is between A and B.
        System.out.println(iter.next()); //B.  Now, pointer is between B and C.
        System.out.println(iter.next()); //C.  Now, pointer is after C.
        System.out.println(iter.previous()); //C.  Now, pointer is between B and C.
        System.out.println(iter.previous()); //B.  Now, pointer is between A and B.
    }
    
}