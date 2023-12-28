

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
