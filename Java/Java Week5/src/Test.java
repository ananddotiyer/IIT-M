import java.util.*;
class Test_RemoveStudent{
	    public boolean property(Double value) {
		        if(value<65)
			            return true;
	        return false;				
	    }
	    public void detained(Map<String, Double> obj) {
            Iterator<Map.Entry<String, Double>> it = obj.entrySet().iterator();
            while (it.hasNext()) {
                if (property(it.next().getValue()))
                    it.remove();
            }
            display(obj);
}
	    public void display(Map<String, Double> obj) {
		        System.out.println(obj);
	    }
}
public class Test {
	    public static void main(String[] args) {
		        Map<String,Double> map=new TreeMap<String,Double>();
		        Scanner scanner=new Scanner(System.in); 
		        for (int i=0; i<6; i++) {
			            map.put(scanner.next(),scanner.nextDouble());
		        }
		        Test_RemoveStudent obj=new Test_RemoveStudent();
		        obj.detained(map);
	    }
}