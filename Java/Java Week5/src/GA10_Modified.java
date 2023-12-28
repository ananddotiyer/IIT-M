 interface GA10_Walkable{
	default void showPaceLength() {
		System.out.println("Average pace length : 0.4 meters");
	}
 }
 class GA10_Human implements GA10_Walkable{
	double pace_length = 0.85;
	public void showPaceLength() {
		System.out.format("Average pace length : %f meters",pace_length);
 	}
 }
 class GA10_Mammal<T extends GA10_Walkable>{ //Modified
	public String name;
	public T group;
	public GA10_Mammal(T obj){
		name = obj.getClass().getSimpleName();
		group = obj;
	 }
	public void print() {
		System.out.println(name);
		group.showPaceLength();
	}
 }
 public class GA10_Modified {
	public static void main(String[] args) {
		GA10_Mammal<GA10_Human> m = new GA10_Mammal<GA10_Human>(new GA10_Human());
		m.print();
	}
}