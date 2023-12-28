import java.util.*;
abstract class GPA1_StringOperations{
  public abstract String reverse(String s);
  public abstract int vowelCount(String s);
}
//Fill the code here
// StringReverse extends StringOperations, UpdatedStrings extends StringReverse.

// Reverse of Java is avaJ
// Vowel count of Java is 2
abstract class GPA1_StringReverse extends GPA1_StringOperations {
    public String reverse(String s) {
        //Reversing
        String reverse_string = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse_string += s.charAt(i);
        }
        return reverse_string;
    }
}

class GPA1_UpdatedStrings extends GPA1_StringReverse {
    public int vowelCount(String s) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int vowel_count = 0;
        char c;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < vowels.length; j++) {
                c = vowels[j];
                if (s.charAt(i) == c) {
                    vowel_count += 1;
                }
            }
        }
        return vowel_count;
    }
}

class GPA1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    GPA1_UpdatedStrings str = new GPA1_UpdatedStrings();
    System.out.println("Reverse of "+ s + " is "+ str.reverse(s));
    System.out.println("Vowel count of "+ s + " is "+ str.vowelCount(s));
  }
}