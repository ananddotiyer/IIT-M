class AQ4_2_modified_Computer {
    public void show() {
        System.out.println("Computer show()");
    }
}

class AQ4_2_modified_Laptop extends AQ4_2_modified_Computer {
    public void show() {
        System.out.println("Laptop show()");
    }
}

public class AQ4_2_modified {
    public static void main(String[] args) {
        AQ4_2_modified_Computer computer1 = new AQ4_2_modified_Computer(); //class computer
        System.out.println(computer1.getClass());
        
        AQ4_2_modified_Computer computer2 = new AQ4_2_modified_Laptop();
        System.out.println(computer2.getClass());
        
        AQ4_2_modified_Laptop laptop1 = (AQ4_2_modified_Laptop) computer2; //class laptop
        System.out.println(laptop1.getClass());

        AQ4_2_modified_Laptop laptop2 = (AQ4_2_modified_Laptop) new AQ4_2_modified_Laptop(); //class laptop
        System.out.println(laptop2.getClass());
        
        AQ4_2_modified_Computer laptop3 = (AQ4_2_modified_Computer) new AQ4_2_modified_Laptop(); //class laptop
        System.out.println(laptop3.getClass());
    }
}