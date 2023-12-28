import java.util.*;
import java.util.stream.*;

class Live_5_Student{
    int roll;
    String name;
    public Live_5_Student(int r, String n){
        roll = r;
        name = n;
    }
    public int getRoll(){
        return roll;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return roll + " : " + name;
    }
}

public class Live_5
{
	public static void main(String[] args) {
		List<Live_5_Student> sl = new LinkedList<Live_5_Student>();
		sl.add(new Live_5_Student(10, "xyz"));
		sl.add(new Live_5_Student(20, "yyz"));
		sl.add(new Live_5_Student(30, "zyz"));
		sl.add(new Live_5_Student(30, "zyz"));
		sl.add(new Live_5_Student(20, "zyz"));
		//sl.stream().filter(s -> s.roll >= 20).forEach(s -> System.out.println(s.roll + " : " + s.name));
	    //Map<Integer, String> m = sl.stream().filter(s -> s.roll >= 20).collect(Collectors.toMap(Student::getRoll, Student::getName));
	    //System.out.print(m);
	    //Map<Integer, List<Student>> stByRoll = sl.stream().collect(Collectors.groupingBy(Student::getRoll));
	    Map<Boolean, List<Live_5_Student>> stByRoll = sl.stream().collect(Collectors.partitioningBy(s -> s.getRoll() > 20));
	    System.out.print(stByRoll);

	}
}