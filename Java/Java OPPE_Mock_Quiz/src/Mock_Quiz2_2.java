import java.util.*;
        class Mock_Quiz2_2_Vehicle implements Comparable<Mock_Quiz2_2_Vehicle>{
            int wheels;
            public Mock_Quiz2_2_Vehicle(int n){
                wheels = n;
            }
            public int compareTo(Mock_Quiz2_2_Vehicle v) {
                      if(wheels < v.wheels)
                            return 1;
                      else if (wheels > v.wheels)
                            return -1;
                      else return 0;
             }
             public String toString(){
                 return "" + wheels;
             }
         }
         public class Mock_Quiz2_2{
               public static void main(String args[]) {
                     Set<Mock_Quiz2_2_Vehicle> veh = new TreeSet<>();
                     veh.add(new Mock_Quiz2_2_Vehicle(4));
                     veh.add(new Mock_Quiz2_2_Vehicle(2));
                     veh.add(new Mock_Quiz2_2_Vehicle(6));
                     veh.add(new Mock_Quiz2_2_Vehicle(1));
                     for(Mock_Quiz2_2_Vehicle v : veh) {
                           System.out.print(v + " ");
                     }
               }
         }