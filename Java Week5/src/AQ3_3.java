class AQ3_3_Show {
    <S, T> AQ3_3_Show(S[] elements1, T[] elements2) {
        for (S element : elements1) {
            System.out.println(element);
        }
        for (T element : elements2) {
            System.out.println(element);
        }
    }
}

public class AQ3_3 {
    public static void main(String args[]) {
        Integer[] arr1 = { 10, 20, 30, 40, 50 };
        String[] arr2 = { "IIT", "Madras", "Java", "Programming" };
        AQ3_3_Show s1 = new AQ3_3_Show(arr1, arr2);
        AQ3_3_Show s2 = new AQ3_3_Show(arr2, arr1);
    }
}