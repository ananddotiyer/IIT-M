import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListOps {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Anand");
        arr.add("Aravind");
        arr.add("Sudha");
        arr.add("Anju");
        arr.add("Beena");

        System.out.println(arr.size());
        
        //Change element at index0 to "Anil"
        arr.set(0, "Anil");

        //Remove element at index3.
        arr.remove(3);

        //Remove element "Beena"
        arr.remove("Beena");

        //Remove a non-existing element doesn't throw error.
        arr.remove("Nirmala");

        //Iterate using a for loop
        System.out.println("Iterate using a for loop");
        for(int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }
        //Create an iterator, and access the elements.  Iterator can fetch only next element.  No previous.
        System.out.println("Iterate using Iterator operations");
        Iterator<String> iter = arr.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        //Create a listIterator, and access the elements.  listIterator can fetch next/previous element.
        System.out.println("Iterate using ListIterator operations");
        ListIterator<String> list_iter = arr.listIterator();
        while (list_iter.hasNext()) {
            System.out.println(list_iter.next());
        }
        while (list_iter.hasPrevious()) {
            System.out.println(list_iter.previous());
        }
    }
}
