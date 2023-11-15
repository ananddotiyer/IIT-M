public class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T f, U s) {
        this.first = f;
        this.second = s;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    //Static method defintions needs to redefine T and U, even if the class defines them.
    public static <T, U> Pair<T, U> static_create(T f, U s) {
        return new Pair(f, s);
    }

    //However, for the following method, you don't need to, since it's not static.
    public Pair<T, U> instance_create(T f, U s) {
        return new Pair(f, s);
    }

    public static void main(String[] args) {
        Pair<String, Integer> p1 = new Pair<>("Hello", 42);
        System.out.println("First : " + p1.getFirst() + ", Second : " + p1.getSecond());

        Pair<Boolean, Character> p2 = Pair.static_create(true, 'I');
        System.out.println("First : " + p2.getFirst() + ", Second : " + p2.getSecond());

        Pair<String, Integer> p3 = p1.instance_create("Hello", 45);
        System.out.println("First : " + p3.getFirst() + ", Second : " + p3.getSecond());
        
    }
}