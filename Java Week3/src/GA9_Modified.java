//THis is a modified version of GA9
//Here, GA9_Mammal doesn't have a default constructor, but an overloaded one that accepts two parameters.
//In this case, the child class constructor must explictly call super() with two parameters, else you'll get a compilation error.
class GA9_Modified_Mammal {
    public String name;
    public int lifespan;

    // public GA9_Mammal() {
    //     name = "Tiger";
    //     lifespan = 45;
    // }

    public GA9_Modified_Mammal(String name, int lifespan) {
        this.name = name;
        this.lifespan = 45;
    }

    public void show() {
        System.out.format("name = %s : lifespan = %d", name, lifespan);
    }

    public void display() {
        System.out.println("Mammal details");
    }
}

class GA9_Modified_Endangered extends GA9_Modified_Mammal {
    public boolean endanger_status;

    public GA9_Modified_Endangered() {
        super("Tiger", 32);
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

public class GA9_Modified {
    public static void main(String args[]) {
        GA9_Modified_Endangered m1 = new GA9_Modified_Endangered();
        m1.show();
        m1.display();
    }
}