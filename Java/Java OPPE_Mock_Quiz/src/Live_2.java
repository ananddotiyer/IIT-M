import java.util.*;
import java.util.stream.*;

public class Live_2
{
    static long getCount(Stream<String> sr){
        return sr.filter(w -> w.length() > 5).count();
    } 
    
    static Stream<String> filter(Stream<String> sr, int l){
        return sr.filter(w -> w.length() > l);    
    }
    
	public static void main(String[] args) {
	    
	    String[] f = {"apple", "orangle", "jackfruit", "kiwi"};
        List<String> words = Arrays.asList(f);
		
		/*
		int count = 0;
		for(String w : words)
		    if(w.length() > 5)
		        count++;
        System.out.println(count);
		*/
		// words.stream().filter(w -> w.length() > 5).forEach(System.out::println);
		// long count = words.stream().filter(w -> w.length() > 5).count();
        // System.out.println(count);
	    /*
	    Stream<String> sr = words.stream();
	    //getCount(sr);
	    //System.out.println(getCount(sr));
	    //Stream<String> fsr = filter(sr, 6);
	    //fsr.forEach(s -> System.out.println(s));
	    
	    filter(sr, 5).forEach(System.out::println);
	    */
	    //Stream<String> words = Stream.generate(() -> "hi");
	    //Stream.generate(() -> "hi").limit(1).forEach(System.out::println);
	    // Stream.iterate(0, n -> n < 10, n -> n+1).forEach(System.out::println);
	    
	    //words.stream().map(s -> s.substring(0,1)).forEach(System.out::println);
	    
	    Integer[] iArr = {1, 2, 3, 4, 5};
	    //Stream<Integer> sr = Stream.of(iArr);
        Arrays.stream(iArr).map(n -> n * n).forEach(e -> System.out.println(e));
	    Stream.of(iArr).map(n -> n * n).forEach(System.out::println);
	}
}
