import java.util.Scanner;

public class BankView {

    Scanner sc = new Scanner(System.in);
     public void showMenu() {

        System.out.println("\n===== BANK MENU =====");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check Balance");
        System.out.println("5. Display All Accounts");
        System.out.println("6. Exit");
    }

    public int getChoice() {
     System.out.print("Enter Choice : ");
        return sc.nextInt();
    }

    public int getAccountNumber() {
        System.out.print("Enter Account Number : ");
        return sc.nextInt();
    }

    public String getName() {
    sc.nextLine();
        System.out.print("Enter Name : ");
        return sc.nextLine();
    }

    public double getAmount(String message) {
        System.out.print(message);
        return sc.nextDouble();
    }

    public void displayMessage(String msg) {
        System.out.println(msg);
    }
}