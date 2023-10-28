public class Test{
      public static void main(String[] args) {
            String s = new String("Hello world");
            String s1 = "Hello world";
            // System.out.println(s);
            if (s.equals(s1)) {
                  System.out.println("Same string");
            }     
            if (s == s1) {
                  System.out.println("== Same string");
            }
      }
}