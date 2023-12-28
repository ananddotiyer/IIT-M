class GA4_Employee {
    public GA4_Employee() {
    }

    public String toString() {
        return "from Employee";
    }
}

class GA4_Manager extends GA4_Employee {
    public GA4_Manager() {
    }

    public String toString() {
        return "from Manager";
    }
}

public class GA4 {
    public static void main(String[] args) {
        GA4_Employee e = new GA4_Manager();
        var o1 = e;
        var o2 = new GA4_Employee();
        var o3 = new GA4_Manager();
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);
    }
}