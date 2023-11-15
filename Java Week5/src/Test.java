//I want a generic sum function that will accept a list containing int/double/float, and return the sum as a double.

class Test_NumList<T extends Number>{
    T[] nlist;
    int idx = 0;
    public Test_NumList(T[] list){
        this.nlist = list;
        idx = 0;
    }
    public boolean has_next() {
        if (idx < nlist.length) {
            return true;
        }
        return false;
    }
    public T get_next() {
        return nlist[idx++];
    }
}
public class Test{
    // public <T extends Number> double sum(T[] list) {
    //     double acc = 0;
    //     for (T number : list) {
    //         acc += number.doubleValue();
    //     }
    //     return acc;
    // }

    public <T extends Number> double sum(Test_NumList<T> list) {
        double acc  = 0;
        while (list.has_next()) {
            acc += list.get_next().doubleValue();
        }
        return acc;
    }
    public static void main(String[] args) {
        Integer[] num_arr = {1,2,3,4,5};
        Double[] dbl_arr = {4.45, 5.67, 8.69, 3.21, 6.78};
        Float[] float_arr = {5.67f, 4.53f, 3.35f, 2.13f, 7.89f};
        Test t = new Test();
        System.out.println(t.sum(new Test_NumList<Integer>(num_arr)));
        System.out.println(t.sum(new Test_NumList<Double>(dbl_arr)));
        System.out.println(t.sum(new Test_NumList<Float>(float_arr)));
    }
}