import java.lang.reflect.*;
import java.util.Arrays;

class PA9_SampleClass {
    private final int pr_data = 9;
    private String pr_str;
    public static int pu_data;

    private PA9_SampleClass() {
        // some code
    }

    public PA9_SampleClass(int pr_data_, String pr_str_) {
        pr_str = pr_str_;
    }

    public PA9_SampleClass(PA9_SampleClass tObj) {
        this.pr_str = tObj.pr_str;
    }

    private boolean isValid() {
        // some code
        return true;
    }

    public int get_pr_data() {
        return pr_data;
    }

    public String get_pr_str() {
        return pr_str;
    }
}

public class PA9_10 {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("PA9_SampleClass");
            Constructor[] my_const = c.getDeclaredConstructors();
            for (Constructor cont : my_const) {
                Class params[] = cont.getParameterTypes();
                for (Class param : params) {
                    System.out.print(param.getName() + ", ");
                }
            }

            System.out.println("\n");
            // Find the private variables of PA9_SampleClass
            int i = 0, j;
            Field[] fields1 = c.getFields();
            Field[] fields2 = c.getDeclaredFields();
            String[] pvt_fields = new String[fields2.length];
            for (Field f2 : fields2) {
                boolean bool = Arrays.asList(fields1).contains(f2); // fields1 contains f2?
                if (bool == false) {
                    pvt_fields[i] = f2.getName(); // add to private variables
                    i = i + 1;
                }
            }
            for (j = 0; j < i; j++) {
                System.out.println(pvt_fields[j]);
            }
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}