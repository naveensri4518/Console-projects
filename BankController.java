public class BankController {

    Account[] accounts = new Account[10];

    int count = 0;
    public void createAccount(int accNo, String name, double balance) {
            accounts[count] = new Account(accNo, name, balance);
               count++;
              System.out.println("Account Created Successfully");
    }

    public Account searchAccount(int accNo) {
        for (int i = 0; i < count; i++) 
              if (accounts[i].getAccountNumber() == accNo) {

                return accounts[i];
            }
                 return null;
    }

    public void deposit(int accNo, double amount) {
         Account acc = searchAccount(accNo);
        if (acc != null) {

            acc.setBalance(acc.getBalance() + amount);
            System.out.println("Amount Deposited");
         } else {
            System.out.println("Account Not Found");
        }
    }
 
    public void withdraw(int accNo, double amount) {
        Account acc = searchAccount(accNo);
             if (acc != null) {
            if (acc.getBalance() >= amount) {

                acc.setBalance(acc.getBalance() - amount);
                System.out.println("Withdrawal Successful");

            } else {

                System.out.println("Insufficient Balance");
            }

        } else {

            System.out.println("Account Not Found");
        }
    }

    public void checkBalance(int accNo) {

        Account acc = searchAccount(accNo);

        if (acc != null) {

            System.out.println("\n----- ACCOUNT DETAILS -----");

            System.out.println("Account Number : "
                    + acc.getAccountNumber());

            System.out.println("Name : "
                    + acc.getName());

            System.out.println("Balance : "
                    + acc.getBalance());

        } else {

            System.out.println("Account Not Found");
        }
    }

    public void displayAccounts() {

        System.out.println("\n===== ALL ACCOUNTS =====");

        for (int i = 0; i < count; i++) {
            System.out.println("Account Number : "
                    + accounts[i].getAccountNumber());

            System.out.println("Name : "
                    + accounts[i].getName());

            System.out.println("Balance : "
                    + accounts[i].getBalance());

            System.out.println("-----------------------");
        }
    }
}