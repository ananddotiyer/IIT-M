  class GA8_Student{
        public String sname;
        public String sid;
        public int sclass;

        public GA8_Student() {
            System.out.println("In the no-argument constructor");
        }
        public GA8_Student(String s_name,String s_id, int s_class){
             this.sname = s_name;
             this.sid =s_id;
             this.sclass = s_class;
        }
        public void display() {
             System.out.println("name:"+sname);
             System.out.println("id:"+sid);
             System.out.println("class:"+sclass);
        }
  }
  class GA8_Toppers extends GA8_Student{
        public int marks;

        public GA8_Toppers(int marks){
            this.marks = marks;
        }

        public void display() {
            super.display();
            System.out.println("marks:"+marks);
        }
 }  
 public class GA8{
        public static void main(String[] args){
             GA8_Toppers t = new GA8_Toppers(30);
             t.display();
        }
 }