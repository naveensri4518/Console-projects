public class Main {
    public static void main(String[] args) {

        BankController bank = new BankController();
        BankView view = new BankView();
        while (true) {
            view.showMenu();
            int choice = view.getChoice();

            switch (choice) {
                case 1:
                    int accNo = view.getAccountNumber();
                    String name = view.getName();
                    double balance = view.getAmount("Enter Initial Balance : ");
                    bank.createAccount(accNo, name, balance);
                    break;

                case 2:
                    int depAcc = view.getAccountNumber();
                    double depAmt =view.getAmount("Enter Amount : ");
                    bank.deposit(depAcc, depAmt);
                    break;

                case 3:
                    int withAcc = view.getAccountNumber();
                    double withAmt = view.getAmount("Enter Amount : ");
                    bank.withdraw(withAcc, withAmt);
                    break;

                case 4:
                    int checkAcc = view.getAccountNumber();
                    bank.checkBalance(checkAcc);
                    break;

                case 5:
                    bank.displayAccounts();
                    break;

                case 6:
                    view.displayMessage("Thank You");
                    System.exit(0);

                default:

                    view.displayMessage("Invalid Choice");
            }
        }
    }
}