import java.util.*;
public class AQ1_7{
     public static void main(String[] args){
          ArrayList<Integer> al=new ArrayList();
          al.add(3);
          al.add(2);
          ArrayList<Integer> al2=(ArrayList<Integer>)al.clone();
          al2.add(1);
          for(Integer i: al){
              System.out.print(i+" ");
          }
          System.out.println();
              for(Integer i: al2){
                 System.out.print(i+" ");
          }
     }
}