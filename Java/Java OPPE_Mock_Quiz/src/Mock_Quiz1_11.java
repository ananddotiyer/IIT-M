class Mock_Quiz1_11_Student{
      private int rollnumber, chemMarks, phyMarks, mathsMarks;
      public int accessStudent(int c, int p, int m){
           return chemMarks + phyMarks + mathsMarks;  //Line 1
      } 
      public void mutateStudent(int c, int p, int m) {
           chemMarks = c; phyMarks = p; mathsMarks = m; //Line 2
      }
}
class Mock_Quiz1_11 {
     public static void main(String[] args){
         Mock_Quiz1_11_Student s = new Mock_Quiz1_11_Student();
          int c = 50, p = 50, m = 50, t = 0;
          s.mutateStudent(c,p,m);
          t = s.accessStudent(c,p,m);
          System.out.println(t);
     }

}