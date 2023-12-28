import java.util.ArrayList;

// class PrintList{
//     public void 
// }
public class Demo1 {
    public static <T extends Number> void PrintListV1(ArrayList<T> list){
        for(T each: list){
            System.out.println(each);
        }
    }
    public static void PrintListV2(ArrayList<Double> list){
        for(Double each: list){
            System.out.println(each);
        }
    }

    public static <T extends Number> ArrayList<Double> add_two_lists_not_working(ArrayList<T>l1, ArrayList<T> l2) {
        ArrayList<Double> l3 = new ArrayList<>();
        for(int i = 0; i < l1.size(); i++){
            // System.out.println(l1.get(i));
            l3.add(l1.get(i).doubleValue() + l2.get(i).doubleValue());
            // System.out.println(l1.get(i) + l2.get(i))
        }
        return l3;
    }

    public static ArrayList<Double> add_two_lists(ArrayList<? extends Number>l1, ArrayList<? extends Number> l2) {
        ArrayList<Double> l3 = new ArrayList<>();
        for(int i = 0; i < l1.size(); i++){
            // System.out.println(l1.get(i));
            l3.add(l1.get(i).doubleValue() + l2.get(i).doubleValue());
            // System.out.println(l1.get(i) + l2.get(i))
        }
        return l3;
    }

    public static <T extends Number, S extends Number> ArrayList<Double> add_two_lists_also_works(ArrayList<T>l1, ArrayList<S> l2) {
        ArrayList<Double> l3 = new ArrayList<>();
        for(int i = 0; i < l1.size(); i++){
            // System.out.println(l1.get(i));
            l3.add(l1.get(i).doubleValue() + l2.get(i).doubleValue());
            // System.out.println(l1.get(i) + l2.get(i))
        }
        return l3;
    }


    public static void main(String[] args) {
        ArrayList<Integer> aln = new ArrayList<>();
        aln.add(1);
        aln.add(2);
        aln.add(3);
        PrintListV1(aln);

        ArrayList<Double> ald = new ArrayList<>();
        ald.add(1.1);
        ald.add(2.4);
        ald.add(3.5);
        PrintListV2(ald);

        System.out.println(add_two_lists(aln, ald));
        System.out.println(add_two_lists_also_works(ald, aln));
    }    
}
