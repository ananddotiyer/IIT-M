import java.util.stream.*;
import java.util.*;

class Live_1_Word {
  String wrd;

  public Live_1_Word(String w) {
      wrd = w;
  }

  public List<Character> getItems() {
    List<Character> lC = new ArrayList<Character>();
    for(int i = 0; i < wrd.length(); i++)
        lC.add(wrd.charAt(i));
    return lC;        
  }
  
  public String toString(){
      return wrd;
  }
}

class Live_1{
  public static void main(String[] args) {
    List<Live_1_Word> words = new ArrayList();
    words.add(new Live_1_Word("Laptop"));
    words.add(new Live_1_Word("Phone"));
    words.add(new Live_1_Word("Mouse"));
    words.stream().forEach(System.out::println);
    words.stream().map(Live_1_Word::getItems).forEach(System.out::println);
    words.stream().map(Live_1_Word::getItems).flatMap(List::stream).forEach(System.out::println);
  }
}