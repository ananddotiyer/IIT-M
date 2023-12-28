import java.util.Optional;

class Demo1_Address{
    String Street;
    String city;
    public Demo1_Address(String Street, String city){
        this.Street = Street;
        this.city = city;
    }
}
class Demo1_Employee{
    String name;
    Demo1_Address address;
    public Demo1_Employee(String name) {
        this.name = name;
    }
    public Demo1_Employee(String name, Demo1_Address address){
        this.name = name;
        this.address = address;
    }
    public Optional<Demo1_Address> getAddress(){
        return Optional.ofNullable(address);
    }
}
public class Demo1{
    public static void main(String[] args) {
        Demo1_Employee e = new Demo1_Employee("Anand", new Demo1_Address("California Jn", "California"));
        Optional<Demo1_Address> a = e.getAddress();
        // if (a.isPresent())
        //     System.out.println(a.get().city); //No NullPointerException
        a.ifPresentOrElse(b -> System.out.println(b.Street), 
            () -> {Demo1_Address b = new Demo1_Address("Jakkur", "Bangalore"); System.out.println(b.Street);});
    }
}