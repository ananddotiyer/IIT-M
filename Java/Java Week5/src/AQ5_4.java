class AQ5_4_Example<T1,T2 extends Number>{
    T1 ob1;
    T2 ob2;
    void push(T1 obj){
        this.ob1=obj;
        System.out.println(ob1);
    }
    void push(T2 obj){
        this.ob2=obj;
        System.out.println(ob2);
    }
 }
class AQ5_4{
    public static void main(String[] args){
        AQ5_4_Example<Number,Number> n = new AQ5_4_Example<Number,Number>();
        n.push(5.5); //Ambigous
    }
}