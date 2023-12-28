
import java.util.*;

class Quiz2_173_OrderedPair<T extends Number> {
    private T a;
    private T b;

    public Quiz2_173_OrderedPair(T a_val, T b_val) {
        a = a_val;
        b = b_val;
    }

    public T get_a() {
        return a;
    }

    public T get_b() {
        return b;
    }

    //Argument can also be Quiz2_173_OrderedPair<?> pair2 or Quiz2_173_OrderedPair<Integer> pair2
    public boolean isMinPair(Quiz2_173_OrderedPair<T> pair2) {
        if (this.a.doubleValue() < pair2.get_a().doubleValue() &&
                this.b.doubleValue() < pair2.get_b().doubleValue()) {
            return true;
        } else
            return false;
    }
}

public class Quiz2_173 {
    public static void main(String[] args) {
        Quiz2_173_OrderedPair<Integer> op1 = new Quiz2_173_OrderedPair<Integer>(5, 6);
        Quiz2_173_OrderedPair<Integer> op2 = new Quiz2_173_OrderedPair<Integer>(3, 2);
        
        System.out.println(op2.isMinPair(op1));
    }
}
