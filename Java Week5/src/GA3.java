class Player {
    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Player(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String toString() {
        return "Player [name=" + name + ", type=" + type + "]";
    }
}

class Captain extends Player {
    public Captain(String name, String type) {
        super(name, type);
    }

    public String toString() {
        return "Captain [name=" + getName() + ", type=" + getType() + "]";
    }
}

class CopyArrayObjects {
    public static <S extends T, T> void copy(S[] src, T[] tgt) { // LINE1
        int i, limit;
        limit = Math.min(src.length, tgt.length);
        for (i = 0; i < limit; i++) {
            tgt[i] = src[i];
        }
    }
}

public class GA3 {
    public static void main(String[] args) {
        Captain captain1 = new Captain("Virat", "Batting");
        Captain captain2 = new Captain("Hardik", "All Rounder");
        Captain captain3 = new Captain("Jasprit", "Bowling");
        Captain captain[] = { captain1, captain2, captain3 };
        Player[] player = new Captain[2];
        CopyArrayObjects.copy(captain, player);
        for (int i = 0; i < player.length; i++) {
            System.out.println(player[i]);
        }
    }
}