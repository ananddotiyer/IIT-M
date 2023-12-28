import java.util.*;
public class PA1{
    public static void main(String[] args){
              String[] arr=new String[10];
              arr[0]="Sun";
              arr[1]="Moon";
              Optional<String> op=Optional.ofNullable(arr[2]);
              op.ifPresent(n->System.out.println(n.toUpperCase()));
    }
}