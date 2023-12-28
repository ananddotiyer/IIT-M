import java.util.*;
    class GPA3_BankAccount{
        int accountNumber;
        String name;
        int balance;
        final int minBalance = 100;
        private boolean checkMinBalance(int amount){
            if(balance - amount <= minBalance){
                return false;
            }
            else{
              return true;
            }
        }
//Fill the code here
        public GPA3_BankAccount(int accountNumber, String name, int balance) {
            this.accountNumber = accountNumber;
            this.name = name;
            this.balance = balance;
        }
        public void balance() {
            System.out.println(this.balance);
        }
        public void deposit(int amount) {
            this.balance += amount;
        }
        public void withdraw(int amount) {
            if (checkMinBalance(amount))
                this.balance -= amount;
            else
                System.out.println("Transaction failed");
        }
}
    class GPA3{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int amnt = sc.nextInt( );
            int amnt1 = sc.nextInt( );
            GPA3_BankAccount b = new GPA3_BankAccount(1890, "rahul", 1000);
            b.deposit(amnt);
            b.balance();
            b.withdraw(amnt1);
            b.balance();
        }
    
    }