class AQ2_5_Example<T extends Number>{
      T x;
      AQ2_5_Example(T x){
                 this.x = x;
        }
        T get(){
                 return x;
        }
}
public class AQ2_5{
        public static void main(String args[]){
                AQ2_5_Example<Integer> obj=new AQ2_5_Example<Integer>((int)'A');
                System.out.println(obj.get());
        }
}