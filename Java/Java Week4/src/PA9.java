interface PA9_Academics {
    default void getName() {
        System.out.println("Academics : getName");
    }

    default void printName() {
        System.out.println("Academics : printName");
    }
}

class PA9_University {
    private int univ_id;

    private class College implements PA9_Academics {
        private String college_name;

        public void getName() {
            System.out.println(college_name);
        }

        public void getID() {
            System.out.println(univ_id);
        }

        College(String name) {
            college_name = name;
        }
    }

    public College getReference() {
        return new College("IITMadras");
    }
}

public class PA9 {
    public static void main(String[] args) {
        PA9_University uni = new PA9_University();
        PA9_Academics acad = uni.getReference();
        acad.getName();
        // acad.getID(); //getID is not defined in the interface
    }
}