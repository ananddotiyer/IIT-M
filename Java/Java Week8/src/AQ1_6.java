import java.util.*;
class AQ1_6_Person{
     String name;
     public AQ1_6_Person(String name){
          this.name=name;
     }
     public void setter(String name){
         this.name=name;
     }
     public String getter(){
        return name;
     }
}
public class AQ1_6{
    public static void main(String[] args){
        ArrayList<AQ1_6_Person> al=new ArrayList<>();
        al.add(new AQ1_6_Person("Jupiter"));
        ArrayList<AQ1_6_Person> al2=(ArrayList<AQ1_6_Person>)al.clone();
        al.get(0).setter("Sun");
        al2.get(0).setter("Moon");
        System.out.println(al.get(0).getter()+"\n"+al2.get(0).getter());
    }
}