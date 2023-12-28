import java.util.*;
class PPA2{
   
 static char[] replace(char[] chars, int i, char c) {
        try {
            chars[i] = c;
            return chars;
        }
        catch(ArrayIndexOutOfBoundsException e) {
            if(i < 0)
                throw e;
            else
                chars[chars.length - 1] = c;
            return chars;
        }
    }
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        int i = sc.nextInt();
        char c = sc.next().charAt(0);
        try {
            String s2 = new String(replace(s1.toCharArray(), i, c));
            System.out.println(s2);
        } 
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}