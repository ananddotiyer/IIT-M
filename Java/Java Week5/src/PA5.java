interface PA5_X{
     public abstract void display();
}
class PA5_A{
     void show(){
           System.out.println("Show");
     }
}
class PA5_B extends PA5_A implements PA5_X{
     public void display(){
           System.out.println("Display");
     }
}
class PA5_Example<T extends PA5_A & PA5_X>{
    T obj;
    PA5_Example(T obj){
          this.obj=obj;
    }
    void show(){
          obj.display();
    }
}
public class PA5{
    public static void main(String[] args){
          PA5_Example<PA5_B> c=new PA5_Example<PA5_B>(new PA5_B());
          c.show();
    }
}