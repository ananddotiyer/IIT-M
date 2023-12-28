import java.util.*;
class Quiz2_167_Player{
    String name;
    int runs;
    public Quiz2_167_Player(String n, int r){
        name = n;
        runs = r;
    }
    public String toString(){
        return "name = " + name + ", runs = " + runs;
    }
}

public class Quiz2_167{
    public static void printTopBatsman(List<Quiz2_167_Player> pList){
        //Method1
        // for (Quiz2_167_Player p: pList) {
        //     System.out.println(p);
        // }
        //Method2
        // Collections.sort(pList, (r2, r1) -> r1.runs - r2.runs);
        // pList.stream().limit(1).forEach(System.out::println);
        //Method3
        System.out.println(pList.stream().max((r1, r2) -> r1.runs - r2.runs));
        
    }

    public static void main(String[] args) {
        var pList = new ArrayList<Quiz2_167_Player>();
        pList.add(new Quiz2_167_Player("Shami", 579));    
        pList.add(new Quiz2_167_Player("Bumrah", 450));    
        pList.add(new Quiz2_167_Player("Rohit", 1700));    
        pList.add(new Quiz2_167_Player("Kohli", 1850));    
        printTopBatsman(pList);
    }
}