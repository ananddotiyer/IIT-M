import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class AQ4_4_PrimitiveMan{
        public AQ4_4_PrimitiveMan() {
        }
        public void eat(){
        System.out.println("Eating");
        }
        public int sleep(int a,int b){
            System.out.println("Sleeping");
            return 0;
        }
}
class AQ4_4_Human extends AQ4_4_PrimitiveMan{
    public AQ4_4_Human() {
    }
    public void appearance(){
            System.out.println("Good-looking");
    }
} 
public class AQ4_4 {
    public static void main(String[] args) {
            Class c=new AQ4_4_Human().getClass();
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