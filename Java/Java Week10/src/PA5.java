class PA5_Point implements Runnable{
    static int x, y;
    private String name;
    public PA5_Point(String n){
         this.name = n;
    }
    public void updatePoint(int a, int b){
         x = a;
         y = b;
    }
    public void display(){
         System.out.println("("+ x +","+ y + ")");
    }
    public void run(){
         if(name.equals("update")){
              updatePoint(this.x + 5, this.y + 6);
         }
         if(name.equals("display")){
               display();
         }
    }
}
public class PA5 {
     public static void main(String[] args){
           PA5_Point p1 = new PA5_Point("update");
           PA5_Point p2 = new PA5_Point("display");
           Thread t1 = new Thread(p1);
           Thread t2 = new Thread(p2);
           t2.start();
           t1.start();
     }
}