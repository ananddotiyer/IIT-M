import java.util.*;

interface Playable {
    public abstract int getScore();
}

class Player implements Playable {
    private String name;
    private int runs;

    public Player(String name, int runs) {
        this.name = name;
        this.runs = runs;
    }

    public int getScore() {
        return runs;
    }
}

class Captain extends Quiz2_167_Player {
    public Captain(String name, int runs) {
        super(name, runs);
    }
}

public class Quiz2_156 {
    //First argument can also be <T extends Player>
    public static <T extends Playable, S extends T> boolean findPlayer(T[] players, S captain) {
        for (T player : players) {
            if (player.getScore() > captain.getScore())
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Quiz2_167_Player[] p = { new Quiz2_167_Player(" ABC", 23), new Quiz2_167_Player("XYZ", 40) };
        Captain c = new Captain("CAP", 34);
        System.out.println(findPlayer(p, c));
    }
}
