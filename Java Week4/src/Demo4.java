//Nested classes
abstract class inner{
  int y;
  abstract public int getY();
}
class Demo4_OuterClass {
  int x = 10;

  public InnerClass accessInner(){
    return new InnerClass();
  }

  private class InnerClass extends inner{
    int y = 6;
    public int getY() {
      return this.y;
    }
  }
}

public class Demo4 {
  public static void main(String[] args) {
    Demo4_OuterClass myOuter = new Demo4_OuterClass();
    inner myInner = myOuter.accessInner();
    System.out.println(myInner.getY() + myOuter.x);
  }
}