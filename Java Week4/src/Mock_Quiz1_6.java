public class Mock_Quiz1_6 {
     public static int x = 20;

     public static void fun(int arr[], int x) {
          while (x > arr.length) {
               x = x / 2;
          }
          for (int i = 0; i < arr.length; i++) {
               arr[i] = x;
          }
     }

     public static void main(String[] args) {
          int[] a = { 2, 3, 5, 7, 11 };
          int x = 100;

          fun(a, x);

          for (int i = 0; i < a.length; i++) {
               System.out.print(a[i] + " ");
          }
          System.out.println(x);
     }
}