class Hello{
    public void printHello() {
        System.out.println("Hello");
    }
}
public class Demo1{
    public static void main(String[] args) {
        try {
            String[] s = new String[3];
            System.out.println(s[4]);
        }
        catch(ArrayIndexOutOfBoundsException Ex){
            System.out.println(Ex.getMessage());
        }
        
        Class<?> h;
        try {
            h = Class.forName("Hello");
            h.getMethod("printHello").invoke(h.getDeclaredConstructor().newInstance());
        } catch (Exception Ex) {
            Ex.printStackTrace();
        }
        
        
        
    }
}