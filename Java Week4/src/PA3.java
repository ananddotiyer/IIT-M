   interface PA3_Comparable{
         public abstract int comp(PA3_Comparable x);
   }
   class PA3_Name implements PA3_Comparable{
         private String fname;
         private String lname;

         public PA3_Name(String fname, String lname){
              this.fname = fname;
              this.lname = lname;
         }
         public int comp(PA3_Comparable x) {
              if(lname.compareTo(((PA3_Name)x).lname) == 0)
                    return fname.compareTo(((PA3_Name)x).fname);
              return lname.compareTo(((PA3_Name)x).lname);
         }
         public void print() {
                  System.out.println(fname + " " + lname);
         }
   }
   public class PA3{
         public static void sort(PA3_Comparable[] names) {
                 for(int i = 0; i < names.length - 1; i++) {
                      for(int j = 0; j < names.length - i - 1; j++) {
                           if(names[j].comp(names[j + 1]) > 0) {
                                  PA3_Comparable tname = names[j];
                                  names[j] = names[j + 1];
                                  names[j + 1] = tname;
                           }
                      }
                }
          }
          public static void main(String[] args) {
                PA3_Name[] names = new PA3_Name[] {new PA3_Name("Charlotte", "Brown"),
                                                                 new PA3_Name("Ava", "Smith"),
                                                                 new PA3_Name("Emma", "Williams"),
                                                                 new PA3_Name("Olivia", "Smith"),
                                                                 new PA3_Name("Emma", "Johnson")};
                sort(names);
                for(int i = 0; i < names.length; i++)
                       names[i].print();
         }
   }