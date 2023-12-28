 class AQ5_1{
     public static void main(String[] args){
	  Thread2 t2=new Thread2();
	  t2.start();
	  System.out.println(t2.c);
	  }
 }
 class Thread2 extends Thread{
     int a=1,b=1,c=0;
     public void run(){
           for(int n=0;n<5;n++){
		c=a+b;
		a=b;
		b=c;
		}
	   }
 }