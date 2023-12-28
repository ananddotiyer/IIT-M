//Nested classes
class Demo2_OuterClass {
  int x = 10;

  static class InnerClass {
    int y = 5;
  }
}

public class Demo2 {
  public static void main(String[] args) {
    Demo2_OuterClass myOuter = new Demo2_OuterClass();
    Demo2_OuterClass.InnerClass myInner = new Demo2_OuterClass.InnerClass();
    System.out.println(myInner.y + myOuter.x);
  }
}