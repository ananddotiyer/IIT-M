import java.util.*;
class CricketPlayer{
  private String name;
  private int wickets;
  private int runs;
  private int matches;
  public CricketPlayer(String s, int w, int r, int m){
    this.name = s;
    this.wickets = w;
    this.runs = r;
    this.matches = m;
  }
  public String getName(){
    return name;
  }
  public int getWickets(){
    return wickets;
  }
  public int getRuns(){
    return runs;
  }
  public double avgRuns(){
    return runs/matches;
  }
  public double avgWickets(){
    return wickets/matches;
  }
} 
public class GPA1 {
// Define displayPlayers() method here
public static void displayPlayers(ArrayList<CricketPlayer>bw, ArrayList<CricketPlayer>bt){
    for(int i = 0; i < bt.size(); i++) {
        System.out.print(bt.get(i).getName());
    }
    System.out.println();
    for(int i = 0; i < bw.size(); i++) {
        System.out.print(bw.get(i).getName());
    }
    System.out.println();
    
}
 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    CricketPlayer p1 = new CricketPlayer(sc.next(), sc.nextInt(), 
                                sc.nextInt(), sc.nextInt());
    CricketPlayer p2 = new CricketPlayer(sc.next(), sc.nextInt(), 
                                sc.nextInt(), sc.nextInt());
    CricketPlayer p3 = new CricketPlayer(sc.next(), sc.nextInt(), 
                                sc.nextInt(), sc.nextInt());
    CricketPlayer p4 = new CricketPlayer(sc.next(), sc.nextInt(), 
                                sc.nextInt(), sc.nextInt());

    // Define ArrayList objects here
    ArrayList<CricketPlayer> bt = new ArrayList<CricketPlayer>();
    ArrayList<CricketPlayer> bw = new ArrayList<CricketPlayer>();
    if (p1.avgRuns() > 25) {
        bt.add(p1);
    }
    if (p2.avgRuns() > 25) {
        bt.add(p2);
    }
    if (p3.avgRuns() > 25) {
        bt.add(p3);
    }
    if (p4.avgRuns() > 25) {
        bt.add(p4);
    }
    if (p1.avgWickets() > 1) {
        bw.add(p1);
    }
    if (p2.avgWickets() > 1) {
        bw.add(p2);
    }
    if (p3.avgWickets() > 1) {
        bw.add(p3);
    }
    if (p4.avgWickets() > 1) {
        bw.add(p4);
    }
    
    displayPlayers(bw, bt);
  }
}  