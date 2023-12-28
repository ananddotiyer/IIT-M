public class AQ1_6 extends Thread{
    public void run(){
       for (int i=1;i<=5 ;i++ ){
           System.out.print(i);
           try{
            Thread.sleep(1000);
           } catch (InterruptedException Ex){

           }
       }
   }
   public static void main(String[] args) {
      AQ1_6 example=new AQ1_6();
       example.start();
   }
}