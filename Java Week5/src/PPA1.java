import java.lang.reflect.*;
import java.util.*;

class ClassStats {
    public static int getPubMethodCount(String cname) {
        try {
            return Class.forName(cname).getMethods().length;
        } catch (Exception e) {
            return -1;
        }
    }

    public static int getAllMethodCount(String cname) {
        try {
            return Class.forName(cname).getDeclaredMethods().length;
        } catch (Exception e) {
            return -1;
        }
    }

    public static int getPubFieldCount(String cname) {
        try {
            return Class.forName(cname).getFields().length;
        } catch (Exception e) {
            return -1;
        }
    }

    public static int getAllFieldCount(String cname) {
        try {
            return Class.forName(cname).getDeclaredFields().length;
        } catch (Exception e) {
            return -1;
        }
    }

    public static int getPubContCount(String cname) {
        try {
            return Class.forName(cname).getConstructors().length;
        } catch (Exception e) {
            return -1;
        }
    }

    public static int getAllContCount(String cname) {
        try {
            return Class.forName(cname).getDeclaredConstructors().length;
        } catch (Exception e) {
            return -1;
        }
    }
}

class PPA1 {
    public static void main(String[] args) {
        String cname;
        Scanner sc = new Scanner(System.in);
        cname = sc.nextLine(); // Input "ClassStats" (without the quotes)
        System.out.println("Constructor: " +
                ClassStats.getPubContCount(cname) + ", " +
                ClassStats.getAllContCount(cname));
        System.out.println("Fields: " +
                ClassStats.getPubFieldCount(cname) + ", " +
                ClassStats.getAllFieldCount(cname));
        System.out.println("Methods: " +
                ClassStats.getPubMethodCount(cname) + ", " +
                ClassStats.getAllMethodCount(cname));
    }
}