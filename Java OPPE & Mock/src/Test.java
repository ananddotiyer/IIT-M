import java.util.LinkedHashSet;

public class Test {
    public static void main(String[] args) {
        String str = "123";
        int i = Integer.parseInt(str);
        Integer j = i;
        int k = Integer.valueOf(str);

        System.out.println(i);
        System.out.println(j);
    }
}
