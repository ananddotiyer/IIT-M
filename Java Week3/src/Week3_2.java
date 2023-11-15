class A_3_2 {
    public int bonus(int percent) {
        System.out.print("Inside A's bonus");
        System.out.println();
        return 1;
    }
}

//Note that it's not possible to override bonus method with same 
// method name and parameters and only a different return type.
class B_3_2 extends A_3_2 {
    public float bonus(float percent) {
        System.out.print("Inside B's m");
        return 1.0f;
    }
}
public class Week3_2 {
    public static void main(String[] args) {
        A_3_2 a = new B_3_2();    
        System.out.println(a.bonus(10)); //bonus() defined in B_3_2 accepts only float, so this will call bonus() defined in A_3_2.
    }
}
