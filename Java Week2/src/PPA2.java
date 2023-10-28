import java.util.*;
class PPA2 {
  
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String s1 = sc.next();
    evenDisplay(s1);
  }
//Define evenDisplay(String) method here
    public static void evenDisplay(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0)
                System.out.print(s.charAt(i));
        }
    }
}