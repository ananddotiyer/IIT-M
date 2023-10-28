abstract class GA2_Vehicle{
    abstract void capacity();
}
class G2_Bike extends GA2_Vehicle{
    private String count="Bike capacity at most 2 persons"; 
    public void capacity() {
        System.out.println(count);
    }
}
class G2_Auto extends GA2_Vehicle{
    private String count="Auto capacity at most 4 persons";
    public void capacity() {
        System.out.println(count);
    }
}
public class GA2 {
    public <T extends GA2_Vehicle> void seating(T obj) {
        obj.capacity();
    }
    public static void main(String[] args) {
        GA2 bike=new GA2();
        bike.seating(new G2_Bike());
        GA2 auto=new GA2();
        auto.seating(new G2_Auto());
    }
}