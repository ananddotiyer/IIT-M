import java.util.*;
public class PPA2 {
  
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String s1 = sc.next();
    evenDisplay(s1);
  }
public static void evenDisplay(String str1){
    String str3 = "";
    for (int i = 0; i < str1.length(); i++) {
        if(i % 2 == 0) {
          str3 = str3 + str1.charAt(i);
        }
      
    }
    System.out.println(str3);
    
  }   
}