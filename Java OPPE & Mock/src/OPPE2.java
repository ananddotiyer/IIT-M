import java.util.TreeSet;

class OPPE2_Employee implements Comparable{
    int ID;
    String name;
    int experience;
    int nleaves;

    public OPPE2_Employee(int ID, int experience, int nleaves) {
        this.ID = ID;
        this.experience = experience;
        this.nleaves = nleaves;
    }
    public int compareTo(Object obj) {
        if (experience > ((OPPE2_Employee)obj).experience)
            return 1;
        else if (experience == ((OPPE2_Employee)obj).experience)
            if (nleaves < ((OPPE2_Employee)obj).nleaves)
                return 1;
            else
                return -1;
        else
            return -1;
    }
}
public class OPPE2 {
    private static TreeSet<OPPE2_Employee> treeset;

    public static int displayID(){
        return ((OPPE2_Employee)treeset.last()).ID;
    }

    public static void main(String[] args) {
        OPPE2_Employee e1 = new OPPE2_Employee(20, 2, 1);
        OPPE2_Employee e2 = new OPPE2_Employee(21, 3, 2);
        OPPE2_Employee e3 = new OPPE2_Employee(22, 4, 2);
        OPPE2_Employee e4 = new OPPE2_Employee(23, 2, 4);
        
        treeset = new TreeSet<>();
        treeset.add(e1);
        treeset.add(e2);
        treeset.add(e3);
        treeset.add(e4);        

        System.out.println(displayID());
    }
}
