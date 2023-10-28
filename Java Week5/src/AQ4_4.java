import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class PrimitiveMan{
        public PrimitiveMan() {
        }
        public void eat(){
        System.out.println("Eating");
        }
        public int sleep(int a,int b){
            System.out.println("Sleeping");
            return 0;
        }
}
class Human extends PrimitiveMan{
    public Human() {
    }
    public void appearance(){
            System.out.println("Good-looking");
    }
} 
public class AQ4_4 {
    public static void main(String[] args) {
            Class c=new GA10_Human().getClass();
            Constructor[] constructors=c.getConstructors();
            Method[] methods=c.getMethods();
            Field[] fields=c.getFields();
            
            System.out.println("Number of methods: "+methods.length);
            for (Method m: methods)
                System.out.println(m.getName());
            
            System.out.println("Number of constructors: "+constructors.length);
            System.out.println("Number of fields: "+fields.length);
    }
}