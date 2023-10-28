class AQ2_2_Show{
      public <S,T> void display(S[] elements1,T[] elements2){
             for(S element:elements1){
                    System.out.println(element);
             }
             for(T element:elements2){
                     System.out.println(element );
             }
             System.out.println();
      }
}
public class AQ2_2{
       public static void main(String args[]){
               Integer[] arr1 = { 10, 20, 30, 40, 50 };
               String[] arr2 = {"IIT","Madras","Java","Programming"};
               AQ2_2_Show obj1=new AQ2_2_Show();
               obj1.display(arr1,arr2);
               obj1.display(arr2,arr1);
      }
}