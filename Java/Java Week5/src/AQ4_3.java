class AQ4_3_Vehicle {
}

class AQ4_3_Car extends AQ4_3_Vehicle {
}

public class AQ4_3 {
    public static void main(String[] args) {
        AQ4_3_Vehicle vehicle1 = new AQ4_3_Vehicle();
        AQ4_3_Vehicle vehicle2 = (AQ4_3_Vehicle) new AQ4_3_Car();
        // Casting a Car into Vehicle class doesn't change the run-time behavior of vehicle2. 
        // It still remains Car. This is basically how the dynamic lookup works.
        Class c1 = vehicle1.getClass();
        Class c2 = vehicle2.getClass();
        System.out.println(c1);
        System.out.println(c2);
        if (c1 == c2) {
            System.out.println("Both objects are equal...");
        } else {
            System.out.println("Both objects are not equal...");
        }
    }
}