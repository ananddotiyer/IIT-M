import java.util.*;

abstract class Voter implements Comparable<Voter> {
    String voter_id;
    int age;

    public Voter(String id, int a) {
        voter_id = id;
        age = a;
    }

    public int hashCode() {
        // overriding hashCode to generate the object's id/hash code only
        // on the basis of voter_id
        return Integer.parseInt(voter_id);
    }
    // override compareTo method here
    public int compareTo(Voter other){
        if (this.age > other.age)
            return -1;
        else
            return 1;

    }
    public boolean equals(Object other){
        if (((Voter)other).voter_id.equals(voter_id))
            return true;
        else
            return false;
    }
}

class FemaleVoter extends Voter {
    public FemaleVoter(String voter_id, int age) {
        super(voter_id, age);
    }

    public String toString() {
        return "Female Voter:" + voter_id + ", age:" + age;
    }
}

class MaleVoter extends Voter {
    public MaleVoter(String voter_id, int age) {
        super(voter_id, age);
    }

    public String toString() {
        return "Male Voter:" + voter_id + ", age:" + age;
    }
}

public class OPPE8 {
    public static void voterChart(ArrayList<Voter> registrations){
        LinkedHashSet<Voter> l = new LinkedHashSet<>();
        for (Voter each : registrations)
            l.add(each);
        System.out.println(l);
        TreeSet<Voter> t = new TreeSet<>();
        for (Voter each : l) {
            t.add(each);
        }
        System.out.println(t);
    }
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        ArrayList<Voter> registrations = new ArrayList<Voter>();
        // reading the number of Female voters
        int female_voters = s.nextInt();
        for (int i = 1; i <= female_voters; i++) {
            // reading voter_id
            String id = s.next();
            // reading age
            int age = s.nextInt();
            FemaleVoter f1 = new FemaleVoter(id, age);
            registrations.add(f1);
        }
        // reading the number of Female voters
        int male_voters = s.nextInt();
        for (int i = 1; i <= male_voters; i++) {
            // reading voter_id
            String id = s.next();
            // reading age
            int age = s.nextInt();
            MaleVoter m1 = new MaleVoter(id, age);
            registrations.add(m1);
        }
        voterChart(registrations);
    }
}