public class AQ1_5_Example implements Cloneable{
    int x;
    AQ1_5_Example(int a){
        this.x=a;
    }
    public String toString(){
        return ""+x;
    }
    public Object clone() throws Exception{
        return super.clone();
    }
}
public class AQ1_5{
    public static void main(String[] args) throws Exception{
        AQ1_5_Example obj=new AQ1_5_Example(0);
        AQ1_5_Example obj2=(AQ1_5_Example)obj.clone();
        obj2.x=1;
        System.out.println(obj);
        System.out.println(obj2);
    }
}