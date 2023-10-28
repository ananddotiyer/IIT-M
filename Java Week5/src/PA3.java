class PA3_Show{
      public <T> void display(T[] elements) {
              for (T element : elements){
                    System.out.println(element);
              }
              System.out.println();
      }
}
public class PA3{
       public static void main(String args[]) {
               Integer[] arr1 = {1,2,3,4,5}; //not int
               String[] arr2 = {"IIT","Madras","Java","Programming"};
               PA3_Show obj1=new PA3_Show();
               obj1.display(arr1);
               obj1.display(arr2);
       }
}