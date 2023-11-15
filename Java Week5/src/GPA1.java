// // Given as input two integers n_1,n_2 and two double values d_1,d_2 complete the 
// Java code to form two complex numbers c_1 and c_2, as described below, 
// and print their sum.
// // The real parts of c_1 and c_2 are n_1 and d_1 respectively, whereas their 
// imaginary parts are n_2 and d_2, respectively.
// // Define a generic class ComplexNum with the following members.
// // Instance variables r and i
// // A constructor to initialize r and i	
// // A method add()to return the sum of the two instances of generic type ComplexNum
// // A method that overrides the toString() method in the Object class so that the format 
// of the output is in accordance with those in the test cases.

class ComplexNum <T extends Number>{
    T r, i;
    public void display() {
        System.out.printf("%s + %si", r, i);
    }

    public ComplexNum<Double> add(ComplexNum<?> other) {
        ComplexNum<Double> n = new ComplexNum<Double>();
        n.r = other.r.doubleValue() + this.r.doubleValue();
        n.i = other.i.doubleValue() + this.i.doubleValue();
        return n;
    }
}

public class GPA1{
    public static void main(String[] args) {
        ComplexNum<Integer> c_i = new ComplexNum<Integer>();
        c_i.r = 10;
        c_i.i = 9;  
        c_i.display();

        ComplexNum<Double> c_d = new ComplexNum<Double>();
        c_d.r = 10.2;
        c_d.i = 9.43;  
        c_d.display();

        c_i.add(c_d).display();
    }
}