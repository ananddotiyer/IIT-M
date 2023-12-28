import java.util.*;
import java.util.stream.*;

class Live_3_Word{
    private String w;
    public Live_3_Word(String w){
        this.w = w;
    }
    public List<Character> getChars(){
        List<Character> chs = new ArrayList<Character>();
        for(int i = 0; i < w.length(); i++){
            chs.add(w.charAt(i));
        }
        return chs;
    }
    public String toString(){
        return w;
    }
}
public class Live_3
{
	public static void main(String[] args) {
		List<Live_3_Word> words = new ArrayList<Live_3_Word>();
		words.add(new Live_3_Word("apple"));
		words.add(new Live_3_Word("orange"));
		//Stream<Word> wrds = words.stream();//.forEach(System.out::println);
		//wrds.forEach(System.out::println);
		//words.stream().map(s -> s.getChars());//.forEach(System.out::println);
		//Stream<List<Character>> sr = words.stream().map(s -> s.getChars());
		//Steram<Word> -> Stream<List<Character>> -> List<List<Character>>
		List<List<Character>> s1 = words.stream().map(s -> s.getChars()).collect(Collectors.toList());
		System.out.println(s1);
		//words.stream().map(s -> s.getChars()).flatMap(Collection::stream).forEach(System.out::println);
		//sr.forEach(System.out::println);
		//Stream<Character> sr1 = words.stream().map(s -> s.getChars()).flatMap(Collection::stream);
		//Set<Character> w = words.stream().map(s -> s.getChars()).flatMap(Collection::stream).collect(Collectors.toCollection(TreeSet::new));
		//List<Word> -> Stream<Word> -> Stream<List<Character>> -> Stream<Character> -> List<Character>
		List<Character> w = words.stream().map(s -> s.getChars()).flatMap(Collection::stream).collect(Collectors.toList());
		Collections.sort(w, (a, b) -> b - a);
		System.out.println(w);
	}
}
