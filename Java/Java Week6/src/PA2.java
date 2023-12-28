import java.util.*;

class PA2_Process {
    private int pid;

    public PA2_Process(int pid) {
        this.pid = pid;
    }

    public int getPID() {
        return pid;
    }
}

public class PA2 {
    public static void main(String[] args) {
        Queue<PA2_Process> pq = new LinkedList<PA2_Process>();
        for (int i = 0; i < 5; i++)
            pq.add(new PA2_Process(i + 1000));
        while (!pq.isEmpty()) {
            // PA2_Process curPorc1 = pq.remove();
            // System.out.print(curPorc1.getPID() + " -> ");
            PA2_Process curPorc2 = pq.poll(); // Same as above
            System.out.print(curPorc2.getPID() + " -> ");
        }
    }
}
