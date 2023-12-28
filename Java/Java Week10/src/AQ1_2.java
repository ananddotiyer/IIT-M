class AQ1_2_Example extends Thread{
    public void run(){
       for(int i=1;i<3;i++){
            System.out.print(i+" ");
        }
    }
 }
 class AQ1_2{
     public static void main(String[] args){
        AQ1_2_Example e=new AQ1_2_Example();
        e.start();
        for(int i=3;i<=5;i++){
            System.out.print(i+" ");
        }
    }
 }
 