class AQ2_7_Repository<T>{
    T var;
    void push(T var){
         this.var = var;
    }
    T pop(){
         return var;
    }
}
public class AQ2_7 {
    public static void main(String args[]){
           AQ2_7_Repository<Character> a = new AQ2_7_Repository<Character>();
           a.push("A"); //WOrks only with characters.
           System.out.println(a.pop());
    }
}