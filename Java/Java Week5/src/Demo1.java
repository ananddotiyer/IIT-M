// This demonstrates the use of generic class.
class Parent {
    Object x;
    public Parent() {
        this.x = 2;
    }
}
class Parent_Generic<T, S> {
    T x;
    S y;
    public Parent_Generic(T x, S y) {
        this.x = x;
        this.y = y;
    }
}
class Child extends Parent {
    public Child() {

    }
}
public class Demo1 {
    public static void main(String[] args) {
        Object c = new Child();    
        Parent p = new Child();
        System.out.println(p.x);
        
        int x = (int)p.x;
        System.out.printf("Normal class : x = %d\n", x);

        Parent_Generic<Integer, String> p1 = new Parent_Generic<Integer, String>(12, "Hello");
        System.out.printf("Generic class: x = %d, y = %s\n", p1.x, p1.y);

        Parent_Generic<String, Float> p2 = new Parent_Generic<String, Float>("Generic string", 12.2f);
        System.out.printf("Generic class: x = %s, y = %f\n", p2.x, p2.y);

        //Works even when the types used are same.
        Parent_Generic<Integer, Integer> p3 = new Parent_Generic<Integer, Integer>(12, 24);
        System.out.printf("Generic class: x = %d, y = %d\n", p3.x, p3.y);

    }
    
    
}
