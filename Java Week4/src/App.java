abstract class App_A {
    public static void A_method() {
        System.out.println("Inside A_method");
    }

    public static int vowelCount(String s) {
        char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
        int vowel_count = 0;
        char c;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < s.length() - 1; j++) {
                c = vowels[j];
                if (s.charAt(i) == c) {
                    vowel_count += 1;
                }
            }
        }
        return vowel_count;
    }
    public static String reverse(String s) {
        //Reversing
        String reverse_string = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse_string += s.charAt(i);
        }
        return reverse_string;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Week4");
        App_A.A_method();
        System.out.println(App_A.vowelCount("xyz"));
        System.out.println(App_A.reverse("lsjkdflksjd"));
    }
}
