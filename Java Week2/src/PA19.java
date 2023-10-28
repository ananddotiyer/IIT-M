class Employee_PA19
{
       int eid;
       String ename;

       public Employee_PA19(Employee_PA19 e)
       {
               this.eid = e.eid;
               this.ename = e.ename;
       }
       public void display()
       {
               System.out.println("eid: "+eid);
               System.out.println("ename: "+ename);
       }
}
class Fclass
{
        public static void main(String[] args)
        {
                Employee_PA19 e1 = new Employee_PA19();
                e1.display();
        }
}