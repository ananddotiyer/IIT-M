class PA8_Example<T extends Number>{
    private T[] arr;
    public PA8_Example(T[] a){
       arr = a;
    }
    public T[] getArr() {
        return arr;
    }
}

public class PA8_modified {
    public static void main(String[] args) {
         Integer[] x = {1,2,3,4};
         PA8_Example<Integer> a = new PA8_Example<Integer>(x);
         Integer[] arr = a.getArr();
         for (Integer i : arr) {
             System.out.println(i);
         }
    }
}
