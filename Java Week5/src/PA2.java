class PA2_Example<T>{
       T ob;
       PA2_Example(T x){
             this.ob=x;
       }
       public String show(){
             return ""+ob.getClass().getName();
       }
       public T get(){
             return ob;
       }
}
public class PA2 {
       public static void main(String[] args){
            PA2_Example<Number> n=new PA2_Example<Number>(100);
            PA2_Example<Double> e=new PA2_Example<Double>(10.5);
            n=e; // Using wildcard when declaring n (PA2_Example<? extends Number> n) will fix the issue.
            System.out.print(n.show()+"\n"+n.get());
       }
}

// This is what Bing says about this program:
// The line n=e gives a compilation error because n is of type PA2_Example<Number> 
// and e is of type PA2_Example<Double>. Even though Double extends Number, PA2_Example<Double> 
// does not extend PA2_Example<Number>. This is a common misunderstanding when it comes to 
// generics, but it’s important for type safety.

// If you want to allow n to refer to a PA2_Example of any class that extends Number, 
// you can declare it with a wildcard