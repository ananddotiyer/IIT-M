import java.util.*;
class GA3_Centigrade extends Thread{
         double[] f_temp = null;
         public GA3_Centigrade(double[] arr) {
               f_temp = arr;
         }
         public void run() {
             // converts the temperatures in f_temp to centigrade
             for(int i=0;i<f_temp.length;i++) {
                 f_temp[i] = ((f_temp[i] - 32)/9.0)*5;
             }
         }
}
class GA3_Fahrenheit extends Thread{
    double[] c_temp = null;
    public GA3_Fahrenheit(double[] arr) {
         c_temp = arr;
     }
     public void run() {
          // converts the temperatures in c_temp to fahrenheit
          for(int i=0;i<c_temp.length;i++) {
                c_temp[i] = ((9.0/5.0)*c_temp[i])+32.0;
          }
     }
}
public class GA3{
      public static void main(String args[]) {
            double temp_in_fahrenheit[] = {29.67, -40.0, 50.0, 32.0};
            double temp_in_centigrade[] = {100.0, -92.54, 32.0, -40.0};
            GA3_Centigrade cobj = new GA3_Centigrade(temp_in_fahrenheit);
             GA3_Fahrenheit fobj = new GA3_Fahrenheit(temp_in_centigrade);
             cobj.start();
             fobj.start();

             try{
                //There are two ways for this program to work.
                //Either, wait for both cobj and fobj threads to finish
                // cobj.join();
                // fobj.join();
                //or sleep for 2 seconds.
                Thread.sleep(2000);
             } catch (InterruptedException Ex) {

             }

            // Checking if a temperature is same in both centigrade and fahrenheit
            for(int i=0;i<4;i++) {
                for(int j=0;j<4;j++) {
                     if(temp_in_fahrenheit[i] == temp_in_centigrade[j])
                         System.out.println(temp_in_centigrade[j]);
                  }
            }
     }
}