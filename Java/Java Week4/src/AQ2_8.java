interface A {
    int a;
}
interface B{
    int b = 20;
}
class C implements B{
}
public class AQ2_8{
    public static void main(String[] args){
        C oc = new C();
        System.out.println(oc.b);
    }
}