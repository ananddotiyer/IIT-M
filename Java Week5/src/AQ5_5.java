class AQ5_5_Example<T>{
      T ob;
      AQ5_5_Example(T x){
        this.ob=x;
   }
   public String show(){
        return ""+ob.getClass().getName();
   }
   public T get(){
        return ob;
   }
}
public class AQ5_5 {
    public static void main(String[] args){
       AQ5_5_Example<String> n=new AQ5_5_Example<String>("Hello");
       AQ5_5_Example<Double> e=new AQ5_5_Example<Double>(10.5);
       System.out.printf("%s, %s\n", n.getClass(), e.getClass());
       if(n.getClass()==e.getClass()){
           System.out.print(n.show()+"\n"+n.get());
       }
       else{
           System.out.print(e.show()+"\n"+e.get());
       }
    }
}