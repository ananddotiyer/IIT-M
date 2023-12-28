import java.util.concurrent.locks.*;
class GA6_DemoLock{
          ReentrantLock lck = new ReentrantLock();
          public void display(String name){
                lck.lock();
                try{
                     for(int i = 1; i < 4; i++){
                     System.out.print(i + ":" + name + " ");
                     }
                     System.out.print("\n");
                }
                finally{
                      lck.unlock();
                }
           }
}
class GA6_Example extends Thread{
       GA6_DemoLock l_obj;
       String str;
       GA6_Example(GA6_DemoLock o, String str){
             this.l_obj = o;
             this.str = str;
       }
       public void run(){
             l_obj.display(str);
       }
}
public class GA6{
      public static void main(String[] args){
            GA6_DemoLock obj = new GA6_DemoLock();
            GA6_Example e = new GA6_Example(obj, "Sun");
            GA6_Example e2 = new GA6_Example(obj, "Moon");
            GA6_Example e3 = new GA6_Example(obj, "Earth");
            e.start();
            e2.start();
            e3.start();
      }
}