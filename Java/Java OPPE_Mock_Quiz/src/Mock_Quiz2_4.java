interface ArrOperations<T extends Number> {
    public abstract void display(T[] array);
}

public class Mock_Quiz2_4 {
    public static void main(String[] args) {
        Integer[] a = new Integer[3];
        a[0] = 12;
        a[1] = 13;
        a[2] = 14;
        ArrOperations<Integer> arr = (s) -> {
            for (int i = 0; i < s.length; i++) {
                System.out.print(s[i] + 2 + " ");
            }
        };
        arr.display(a); //In the method definition, a is called s; display is the lambda function defined above. 
    }
}