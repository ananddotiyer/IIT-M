import java.util.*;

class Live_4_IllegalDataException extends Exception{
    public Live_4_IllegalDataException(){
        //super(m);
    }
}
public class Live_4{
    static int getDefVal(){
        return -1;
    }
    static void square(int n){
        n = n * n;
    }
	public static void main(String[] args) {
		Integer[] iArr = {10, 20, 30, 40, 50};
		List<Integer> li = new ArrayList(Arrays.asList(iArr));
		Optional<Integer> maxval = li.stream().filter(i -> i < 10).max(Integer::compareTo);
		System.out.println(maxval.orElse(0));
		//int maxi = maxval.orElseGet(() -> getDefVal());
		//System.out.println(maxval.orElse(0));
		//int maxi = maxval.orElseGet(() -> getDefVal());
		/*
		try{
		    int maxi = maxval.orElseThrow(IllegalDataException::new);
		    System.out.println(maxi);
		}
		catch(Exception e){
		    System.out.println(e);
		}
		*/
		//maxval.ifPresent(System.out::println);
		
		//int i = maxval; 
		
		String[] sA = {"aaa", "bbb", null, "ccc"};
		List<String> sl = new ArrayList<String>();
		for(String s1: sl)
		    System.out.println(s1);
		//maxval.ifPresentOrElse(
		//                        n -> System.out.println(n),
		//                        () -> System.out.println("No data"));
		
	}
}
