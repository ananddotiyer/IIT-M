class AQ3_4_Show {
    <S> AQ3_4_Show(S[] elements) {
        for (S element : elements) {
            System.out.println(element);
        }
    }

    <S, T> AQ3_4_Show(S[] elements1, T[] elements2) {
        for (S element : elements1) {
            System.out.println(element);
        }
        for (T element : elements2) {
            System.out.println(element);
        }
        System.out.println();
    }
}

public class AQ3_4 {
    public static void main(String args[]) {
        Integer[] arr1 = { 10, 20, 30, 40, 50 };
        String[] arr2 = { "IIT", "Madras", "Java", "Programming" };
        int[] arr3 = { 10, 20, 30, 40, 50 };
        char[] arr4 = { 'J', 'A', 'V', 'A' };
        AQ3_4_Show obj1 = new AQ3_4_Show(arr1);
        AQ3_4_Show obj2 = new AQ3_4_Show(arr2);
        AQ3_4_Show obj3 = new AQ3_4_Show(arr1, arr2);
        // AQ3_4_Show obj5=new AQ3_4_Show(arr3); //int is not a class
        // AQ3_4_Show obj6=new AQ3_4_Show(arr3, arr4); //char is not a class.
    }
}