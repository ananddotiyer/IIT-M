import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Object> all_types = new ArrayList<Object>();
        all_types.add(12);
        all_types.add('a');
        all_types.add("hello");

        System.out.println(all_types);

        ArrayList<String> only_strings = new ArrayList<String>();
        // Both lines below causes Compilation error
        // only_strings.add(12);
        // only_strings.add('a');
        only_strings.add("hello");
        System.out.println(only_strings);
    }
}
