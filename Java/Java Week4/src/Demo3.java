//Nested classes
class Demo3_OuterClass {
  int x = 10;

  static class InnerClass {
    int y = 5;
  }
}

public class Demo3 {
  public static void main(String[] args) {
    Demo3_OuterClass myOuter = new Demo3_OuterClass();
    Demo3_OuterClass.InnerClass myInner = new Demo3_OuterClass.InnerClass();
    System.out.println(myInner.y + myOuter.x);
  }
}