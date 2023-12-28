//Reversing array consisting of data of any type using generic reverse method.
//Replacing <T> by <T extends Number> will cause the String array to not work

public class Demo4 {
    public <T> T[] reverse(T[] arr) {
        int idx = 0;
        while (idx <= arr.length / 2) {
            T tmp = arr[idx];
            arr[idx] = arr[arr.length - idx - 1];
            arr[arr.length - idx - 1] = tmp;
            idx += 1;
        }
        return arr;
    }
    public static void main(String[] args) {
        Demo4 t = new Demo4();
        //Reversing integer array
        Integer[] arr = {1,2,3};
        Integer[] arr_rev = t.reverse(arr);

        for (int i = 0; i < arr_rev.length; i++) {
            System.out.println(arr_rev[i]);
        }

        //Reversing string array
        String[] str_arr = {"Anand", "Aravind", "Sudha"};
        String[] str_arr_rev = t.reverse(str_arr);

        for (int i = 0; i < str_arr_rev.length; i++) {
            System.out.println(str_arr_rev[i]);
        }

    }
}
