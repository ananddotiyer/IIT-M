import java.util.*;

class Devotee implements Comparable {
    String name;
    int ticket_type;

    Devotee(String p_name, int p_type) {
        name = p_name;
        ticket_type = p_type;
    }

    public int compareTo(Object a) {
        Devotee d = (Devotee) a;
        if (ticket_type < d.ticket_type)
            return 1;
        else if (ticket_type > d.ticket_type)
            return -1;
        else
            return 0;
    }
}

public class GA7 {
    public static void main(String[] args) {
        Devotee[] dev_arr = new Devotee[] { new Devotee("Pavya", 0),
                new Devotee("Arya", 100), new Devotee("Sana", 0),
                new Devotee("Meenu", 0), new Devotee("Naina", 100) };

        PriorityQueue<Devotee> specialQ = new PriorityQueue<Devotee>();
        for (int i = 0; i < 5; i++) {
            specialQ.add(dev_arr[i]);
        }
        for (int i = 0; i < 5; i++) {
            Devotee d = specialQ.poll();
            System.out.println(d.name + " " + d.ticket_type);
        }
    }
}