class GA9_Mammal {
    public String name;
    public int lifespan;

    public GA9_Mammal() {
        name = "Tiger";
        lifespan = 45;
    }

    public void show() {
        System.out.format("name = %s : lifespan = %d", name, lifespan);
    }

    public void display() {
        System.out.println("Mammal details");
    }
}

class GA9_Endangered extends GA9_Mammal {
    public boolean endanger_status;

    public GA9_Endangered() {
        endanger_status = false;
    }

    public void show() {
        System.out.println("endanger status of " +
                this.name + " is " + endanger_status);
    }

    public void display(String species) {
        System.out.println("Endanger status");
    }
}

public class GA9 {
    public static void main(String args[]) {
        GA9_Mammal m1 = new GA9_Endangered();
        m1.show();
        m1.display();
    }
}