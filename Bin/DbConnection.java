package Bin;
import java.lang.*;
import java.sql.*;

public class DbConnection {
    
        static String url = "jdbc:mysql://localhost:3306/bankdb";

    static String username = "root";
    static String password = "220298158ns#NS";  

        public static Connection  getConnection(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                      url,
                      username,
                      password
                    );

            PreparedStatement ps =
                    con.prepareStatement("select * from accounts");

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                System.out.println(
                        rs.getInt("accountnum")
                );

                System.out.println(
                        rs.getString("accountname")
                );

                System.out.println(
                        rs.getDouble("balance")
                );

                System.out.println(
                        rs.getTimestamp("createdAt")
                );

                System.out.println(
                        "----------------------"
                );
            }
            return con;
            
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
            
        }
}
