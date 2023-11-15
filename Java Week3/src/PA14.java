class PA14_A {
      public static void print() {
            System.out.println("Class A print");
      }

      public void show() {
            System.out.println("Class A show");
      }
}

class PA14_B extends PA14_A {
      public static void print() {
            System.out.println("Class B print");
      }

      public void show() {
            System.out.println("Class B show");
      }
}

public class PA14 {
      public static void main(String args[]) {
            //reference type decides which static method is called.
            PA14_A oa1 = new PA14_B();
            //since this is reference type PA14_A, static method defined in PA14_A gets used.
            oa1.print(); 

            PA14_B oa2 = new PA14_B();
            //since this is reference type PA14_B, static method defined in PA14_B gets used.
            oa2.print();
            
            oa1.show();
      }
}