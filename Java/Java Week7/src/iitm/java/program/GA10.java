package iitm.java.program;
public class GA10 extends util.iitm.java.GA10{
       public static void main(String[] args) {
             GA10 ga10 = new GA10();
             ga10.show(); //show() in util.iitm.java.GA10 isn't public, so this will fail.
       }
}