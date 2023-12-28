import java.util.logging.*;

class Emp{
    String name;
    public Emp(String name){
        this.name = name;
    }
    private void print_name() {
        System.out.println(name);
    }
}
public class Test {
    public static void main(String[] args) {
        Emp e = new Emp("Anand");
        e.print_name();
    }
}