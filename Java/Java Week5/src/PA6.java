class PA6_NumberFunction {
    public static <T extends Number> T max(T[] tArr) {
        T max = tArr[0];
        for (int i = 0; i < tArr.length; i++) {
            if (tArr[i].doubleValue() > max.doubleValue()) {
                max = tArr[i];
            }
        }
        return max;
    }
}

public class PA6 {
    public static void main(String[] args) {
        Integer[] arr1 = {2, 4, 1, 6, 3};
        Double[] arr2 = {2.3, 4.2, 1.4, 2.6, 1.3};
        System.out.println(PA6_NumberFunction.max(arr1));
        System.out.println(PA6_NumberFunction.max(arr2));
    }
}