   class University{
       public int univ_id;

       private class College{
            private String college_name;

            public void getName(){
                 System.out.println(college_name);
            }

            public College(String name){
            college_name = name;
            }
        }

       //As the class is private so we are using a public method
       //to return an object of the the inner class

       public College getReference(){
            return new College("IITMadras");
       }
   }
   public class GA9{
       public static void main(String[] args) {
           University uni = new University();
           (uni.getReference()).getName() ;
       }
   }