 import java.util.*;
   interface Account{
          default void showBalance() {
                System.out.println("Abstract Account");
          }
   }
   class SavingsAccount implements Account{
         double balance;
         public SavingsAccount(double amt){
               balance = amt;
         }
         public void showBalance() {
              System.out.println("SavingsAccount balance: " + balance);
        }
   }
   class CurrentAccount implements Account{
         double balance;
         public CurrentAccount(double amt){
              balance = amt;
         }
         public void showBalance() {
               System.out.println("CurrentAccount balance: " + balance);
         }
   }
   public class GA8{
         public static void main(String args[]) {
                  ArrayList<SavingsAccount> acc1 = new ArrayList<SavingsAccount>();
                  acc1.add(new SavingsAccount(10000.0));
                  acc1.add(new SavingsAccount(20000.5));
                  ArrayList<Account> acc2 = new ArrayList<Account>(acc1);
                  acc2.add(0,new CurrentAccount(50000.0));
                  acc2.remove(1);
                  for(Account t : acc2) {
                        t.showBalance();
                 }
          }
   }