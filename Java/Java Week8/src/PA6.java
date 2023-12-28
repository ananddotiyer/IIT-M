import java.util.*;

interface Operatable<T extends Number> {
    public T operate(T a);
}

public class PA6 {
    public static <T extends Number> void map(T[] x, Operatable<T> ob) {
        for (int i = 0; i < x.length; i++)
            x[i] = ob.operate(x[i]);
    }

    public static void main(String[] args) {
        Integer[] iArr = new Integer[] { 1, 2, 3, 4, 5 };
        map(iArr, i -> i * i);
        for (int i : iArr)
            System.out.print(i + " ");
    }
}