import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Character[] s_arr = str.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        Arrays.stream(s_arr).filter(c -> c == 'a').forEach(System.out::println);
        ArrayList<Character> charList = (ArrayList<Character>)str.chars()
        .mapToObj(c -> (char)c).collect(Collectors.toList());
    }
}