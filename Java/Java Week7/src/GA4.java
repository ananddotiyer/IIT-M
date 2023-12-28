class DOBRegistration{
     private int day, month, year;
     public DOBRegistration(int day, int month, int year){
          assert 0 < day && day <= 31: "day :" + day; //assert-1
          this.day = day;
          assert 0 < month && month <= 12: "day :" + day; //assert-2
          this.month = month;
          this.year = year;
      }
}
class JobApplication{
      private int age;
      public JobApplication(int age){
           assert age >= 18: "invalid age for job"; //assert-3
           this.age = age;
      }
}
class TaxReturn {
      private double income;
      public TaxReturn(double income){
           assert income >= 100000.00: income; //assert-4
           this.income = income;
      }
}
public class GA4{
      public static void main(String[] args){
            DOBRegistration dr = new DOBRegistration(2, 23, 1879);
            JobApplication ja = new JobApplication(20);
            TaxReturn tr = new TaxReturn(75000.00);
      }
}