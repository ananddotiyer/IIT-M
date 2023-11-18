// Write a program that, given a string s as input, prints the string obtained from removing
// all duplicate characters from s (that is, retain only the first occurrence of each charac-
// ter). The characters should appear in the output in the same order as they appear in s.

import java.util.Arrays;
import java.util.Scanner;

public class OPPE1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String unique = "";
        System.out.println(str);
        for (int i = 0; i < str.length(); i++) {
            if (!unique.contains(Character.toString(str.charAt(i))))
                unique += str.charAt(i);
        }

        System.out.println(unique);
    }
}
