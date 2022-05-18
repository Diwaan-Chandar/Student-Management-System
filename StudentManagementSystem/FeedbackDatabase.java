package StudentManagementSystem;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class FeedbackDatabase implements FeedbackInterface, FeedBackAdminInterface{
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagementSystem","root","root");
    Statement stmt=con.createStatement();
    Scanner sc = new Scanner(System.in);

    public FeedbackDatabase() throws SQLException {
    }

    @Override
    public void reportFaculty(String userName, int facultyID, String report) throws SQLException {
        int reportID = getReportMaxID();
        stmt.executeUpdate("insert into reportfaculty values(\'" + userName + "\', " + facultyID + ", \'" + report + "\', null, " + reportID + ");");
    }

    @Override
    public void giveFeedback(String userName, String feedBack) throws SQLException {
        int feedbackID = getFeedBackMaxID();
        stmt.executeUpdate("insert into feedback values(" + feedbackID + ", \'" + userName + "\', \'" + feedBack + "\', null);");
    }


    public int getReportMaxID() throws SQLException {
        try {
            ResultSet rs = stmt.executeQuery("select max(ID) from reportfaculty");
            rs.next();
            if(rs.getInt(1) == 0) return 101;
            return rs.getInt(1) + 1;
        }
        catch (SQLException e) {
            return 101;
        }
    }

    public int getFeedBackMaxID() throws SQLException {
        try {
            ResultSet rs = stmt.executeQuery("select max(feedbackID) from FeedBack");
            rs.next();
            if(rs.getInt(1) == 0) return 101;
            return rs.getInt(1) + 1;
        }
        catch (SQLException e) {
            return 101;
        }
    }

    @Override
    public void commentFeedBack() throws SQLException {
        ResultSet rs = stmt.executeQuery("select * from FeedBack;");
        while(rs.next()) {
            System.out.println(rs.getInt(1) + "\t" + rs. getString(2) + "\t" + rs.getString(3));
        }
        System.out.print("Enter FeedBack ID to comment: ");
        int feedbackID = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter comment: ");
        String comment = sc.nextLine();
        stmt.executeUpdate("update FeedBack set comments=" + "\'" + comment + "\' where feedbackID=" + feedbackID + ";");
    }

    @Override
    public void commentReport() throws SQLException {
        ResultSet rs = stmt.executeQuery("select * from reportfaculty;");
        while(rs.next()) {
            System.out.println(rs.getInt(5) +  "\t" + rs.getInt(2) + "\t" + rs. getString(1) + "\t" + rs.getString(3));
        }
        System.out.print("Enter Report ID to comment: ");
        int ID = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter comment: ");
        String comment = sc.nextLine();
        stmt.executeUpdate("update reportfaculty set comments=" + "\'" + comment + "\' where ID=" + ID + ";");
    }
}
