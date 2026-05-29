import Bin.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BankController {

    Account[] accounts = new Account[10];

    BankView view = new BankView();

    int count = 0;

    public void createAccount( int accNo,  String name, double balance) {
            try {

            accounts[count] = new Account( accNo, name, balance);

            count++;

            view.displayMessage(  "Account Created Successfully" );

            Connection con = DbConnection.getConnection();

            PreparedStatement ps = con.prepareStatement( "insert into accounts(accountname,balance) values(?,?)"  );

            ps.setString(1, name);

            ps.setDouble(2,balance);

            ps.executeUpdate();

        } catch (Exception e) {

            System.out.println(e);
        }
    }


 public void searchAccount(int accNo) {

    try {

        Connection con = DbConnection.getConnection();

        PreparedStatement ps = con.prepareStatement( "select * from accounts where accountnum=?"
 );

        ps.setInt(1, accNo);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {

            view.displayMessage( "Account Number : "+ rs.getInt("accountnum") );

            view.displayMessage("Name : "+ rs.getString("accountname")
            );

            view.displayMessage("Balance : " + rs.getDouble("balance")
            );

        } else {

            view.displayMessage("Account Not Found");
        }

    } catch (Exception e) {

        System.out.println(e);
    }
}

    public void deposit(int accNo, double amount) {
         
        try{
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("update accounts set balance = balance + ? where accountnum = ?");
            ps.setDouble(1, amount);
            ps.setInt(2,accNo);
            int rows = ps.executeUpdate();

            if (rows>0) {
                view.displayMessage("Amount Deposited");
            } else {
                view.displayMessage("Account Not Found");
            }
    }
        catch(Exception e){
            System.out.println(e);
        }
    }

 
    public void withdraw(int accNo, double amount) {
        try {

        Connection con =
                DbConnection.getConnection();

        PreparedStatement ps1 =
                con.prepareStatement( "select balance from accounts where accountnum=?");
          ps1.setInt(1, accNo);

        ResultSet rs =
                ps1.executeQuery();

        if(rs.next()) {

            double currentBalance = rs.getDouble("balance");

            if(currentBalance >= amount) {

                PreparedStatement ps2 = con.prepareStatement( "update accounts set balance = balance - ? where accountnum=?");

                ps2.setDouble(1, amount);

                ps2.setInt(2, accNo);

                ps2.executeUpdate();

                view.displayMessage(
                        "Withdrawal Successful"
                );

            } else {

                view.displayMessage(
                        "Insufficient Balance"
                );
            }

        } else {

            view.displayMessage(
                    "Account Not Found"
            );
        }

    } catch (Exception e) {

        System.out.println(e);
    }
    }

    public void displayAccounts() {
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from accounts");
            ResultSet rs = ps.executeQuery();
            
            if (!rs.isBeforeFirst()) {
                view.displayMessage("No accounts found");
                return;
            }
            
            while (rs.next()) {
                view.displayMessage("Account Number: " + rs.getInt("accountnum"));
                view.displayMessage("Name: " + rs.getString("accountname"));
                view.displayMessage("Balance: " + rs.getDouble("balance"));
                view.displayMessage("Created At: " + rs.getTimestamp("createdAt"));
                view.displayMessage("----------------------");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void checkBalance(int checkAcc) {
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select balance from accounts where accountnum=?");
            ps.setInt(1, checkAcc);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                double balance = rs.getDouble("balance");
                view.displayMessage("Account Number: " + checkAcc);
                view.displayMessage("Current Balance: " + balance);
            } else {
                view.displayMessage("Account Not Found");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}






