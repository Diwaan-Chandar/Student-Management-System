package StudentManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class LogIn {
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagementSystem","root","root");
    Statement stmt=con.createStatement();
    public LogIn() throws SQLException {

    }
    boolean logIn(int userID, String password, String userType) throws SQLException {
        try {
            ResultSet rs = stmt.executeQuery("select password from Student where studentID=" + userID + ";");
            rs.next();
            String pass = rs.getString(1);
            return pass.equals(password);
        }
        catch(SQLException e) {
            return false;
        }
    }
    boolean logIn(String password, int userID, String userType) throws SQLException {
        try {
            ResultSet rs = stmt.executeQuery("select password from Faculty where facultyID=" + userID + ";");
            rs.next();
            String pass = rs.getString(1);
            return pass.equals(password);
        }
        catch(SQLException e) {
            return false;
        }
    }
    boolean logIn(String password, String userType, int userID) throws SQLException {
        try {
            ResultSet rs = stmt.executeQuery("select password from Admin where adminID=" + userID + ";");
            rs.next();
            String pass = rs.getString(1);
            return pass.equals(password);
        }
        catch(SQLException e) {
            return false;
        }
    }
}
