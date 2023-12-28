import java.util.*;
public class AQ4_1{
    static long count=0;
    public static void main(String[] args){
            var list=new ArrayList<String>();
            list.add("Sun");
            list.add("Earth");
            list.add("Moon");
            count=list.stream().filter(s->s.length()>3).count();
            System.out.println(count);
    }
}