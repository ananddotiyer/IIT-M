import java.util.Arrays;

public class GA2 {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        int[] b = { 1, 2, 3 };
        //False, since this compares objects.
        System.out.println(a == b); 
        //True, since this compares the invidual elements.
        System.out.println(Arrays.equals(a, b)); 
    }
}