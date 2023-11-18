import java.util.*;

interface StudentIterator {
    public boolean has_next();

    public Student get_next();
}

class Student {
    private int rollno;
    private int totalmarks;

    public Student(int rollno, int totalmarks) {
        this.rollno = rollno;
        this.totalmarks = totalmarks;
    }

    public int get_totalmarks() {
        return totalmarks;
    }

    public void print() {
        System.out.print(rollno + " : " + totalmarks);
    }
}

class UGStudent extends Student {
    private String department;

    public UGStudent(int rollno, int totalmarks, String department) {
        super(rollno, totalmarks);
        this.department = department;
    }

    public void print() {
        super.print();
        System.out.print(" : " + department);
    }
}

class StudentList<T extends Student> {
    private T s_arr[];

    public StudentList(T[] s_arr) {
        this.s_arr = s_arr;
    }

    public StudentIterator getIterator() {
        return new Iter();
    }

    private class Iter implements StudentIterator {
        private int i = -1;

        public boolean has_next() {
            return i < s_arr.length - 1;
        }

        public Student get_next() {
            i++;
            return s_arr[i];
        }
    }
}

class FClass {
    public static <T extends Student> void printTopper(StudentList<T> list) {
        T Topper = null;
        StudentIterator it = list.getIterator();
        while (it.has_next()) {
            T s = (T)it.get_next();
            if (Topper == null || s.get_totalmarks() > Topper.get_totalmarks()) {
                Topper = s;
            }
        }
        Topper.print();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] s1 = new Student[3];
        UGStudent[] s2 = new UGStudent[3];
        for (int i = 0; i < 3; i++) {
            int r = sc.nextInt();
            int t = sc.nextInt();
            s1[i] = new Student(r, t);
        }
        for (int i = 0; i < 3; i++) {
            int r = sc.nextInt();
            int t = sc.nextInt();
            String d = sc.nextLine();
            s2[i] = new UGStudent(r, t, d);
        }
        StudentList<Student> sList = new StudentList<Student>(s1);
        printTopper(sList);
        System.out.println();
        StudentList<UGStudent> uList = new StudentList<UGStudent>(s2);
        printTopper(uList);
    }
}