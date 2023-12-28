//This file demonstrates multiple ways of access stack elements.

import java.util.Stack;
import java.util.Iterator;
import java.util.ListIterator;

public class StackOps{
    public static void main(String[] args) {
        Stack<Character> st = new Stack<>();
        st.push('a');
        st.push('b');
        st.push('c');
        System.out.println(st);
        System.out.println(st.peek());

        //Convert stack to Array and accessing elements.
        System.out.println("Iterate using Array operations");
        for (Object each : st.toArray()) {
            System.out.println((char)each);
        }

        //Create an iterator, and access the elements.  Iterator can fetch only next element.  No previous.
        System.out.println("Iterate using Iterator operations");
        Iterator<Character> iter = st.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        
        //Create a listIterator, and access the elements.  listIterator can fetch next/previous element.
        System.out.println("Iterate using ListIterator operations");
        ListIterator<Character> list_iter = st.listIterator();
        while (list_iter.hasNext()) {
            System.out.println(list_iter.next());
        }        
 
        //Normal access of elements from stack.
        System.out.println("Iterate using stack operations");
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }

    }
}