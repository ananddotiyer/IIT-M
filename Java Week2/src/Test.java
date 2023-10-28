abstract class Abstract {
    public Abstract() {
        System.out.println("Inside abstract class");
    }
}

class Test_One extends Abstract {
    public Test_One() {
        System.out.println("Inside default one");
    }
    public Test_One(int i) {
        this();
        System.out.println("Inside one arg constructor");
    }
}

class Test_Two extends Test_One {
    public Test_Two(int i) {
        super(); //This is not necessary; called by default
        System.out.println("Inside one arg constructor");
    }
}

public class Test {
    public static void main(String[] args) {
        Test_Two t = new Test_Two(2);    
    }
}