abstract class Mock_Quiz1_1_FClass { // Line 1
    abstract void fPrint();
}

interface Mock_Quiz1_1_SClass { // Line 2
    abstract void sPrint();
}

class ChildClass extends Mock_Quiz1_1_FClass implements Mock_Quiz1_1_SClass {
    public void fPrint() {
        System.out.println("Inside fPrint");
    }

    public void sPrint() {
        System.out.println("Inside sPrint");
    }
}

public class Mock_Quiz1_1 {
    public static void main(String[] args) {
        ChildClass p = new ChildClass();
        p.fPrint();
        p.sPrint();
    }
}