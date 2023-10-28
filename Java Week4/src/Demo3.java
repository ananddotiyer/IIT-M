abstract class Demo3_FoodOrder {
    public abstract void order();
}

class Demo3_Zomato extends Demo3_FoodOrder{
    public void order() {
        System.out.println("Zomato Order");
    }
}

class Demo3_Swiggy extends Demo3_FoodOrder{
    public void order() {
        System.out.println("Swiggy Order");
    }
}

class Person {
    public void foodOrder(Demo3_FoodOrder obj) {
        obj.order();
    }
}
public class Demo3 {
    public static void main(String[] args) {
        Person p = new Person();
        Demo3_FoodOrder z = new Demo3_Zomato();
        p.foodOrder(z);   
        p.foodOrder(new Demo3_Swiggy());  
    }
}
