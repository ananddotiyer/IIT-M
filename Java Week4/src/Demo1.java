abstract class Demo1_FoodOrder {
    public abstract void order();
}

class Demo1_Zomato extends Demo1_FoodOrder{
    public void order() {
        System.out.println("Zomato Order");
    }
}

class Demo1_Swiggy extends Demo1_FoodOrder{
    public void order() {
        System.out.println("Swiggy Order");
    }
}

class Demo1_Person {
    public void foodOrder(Demo1_FoodOrder obj) {
        obj.order();
    }
}
public class Demo1 {
    public static void main(String[] args) {
        Demo1_Person p = new Demo1_Person();
        Demo1_FoodOrder z = new Demo1_Zomato();
        p.foodOrder(z);   
        p.foodOrder(new Demo1_Swiggy());  
    }
}
