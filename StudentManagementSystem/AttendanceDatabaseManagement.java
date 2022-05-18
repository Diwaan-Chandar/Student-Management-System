package StudentManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.Scanner;

public class AttendanceDatabaseManagement implements AttendanceManagementInterface, StudentAttendanceInterface{
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagementSystem","root","root");
    Statement stmt = con.createStatement();
    Statement stmt2 = con.createStatement();
    Scanner sc = new Scanner(System.in);

    public AttendanceDatabaseManagement() throws SQLException {
    }

    @Override
    public void addAttendance(String date, int stuClass, int facultyID) {
        try {
            ResultSet rs = stmt.executeQuery("select studentID from Student where class=" + stuClass + ";");
            while(rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println("1. Present");
                System.out.println("2. Absent");
                System.out.print("Enter attendance: ");
                int attendanceInput = sc.nextInt();
                String attendance;
                if(attendanceInput == 1) attendance = "Present";
                else attendance = "Absent";
                stmt2.executeUpdate("insert into Attendance values(" + rs.getInt(1) + ", \'" + date + "\', \'" + attendance + "\', " + facultyID + ", " + stuClass + ");");
            }
        }
        catch(SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void getClassAttendanceReport(int stuClass) throws SQLException {
        ResultSet rs = stmt.executeQuery("select count(*) from Attendance where class=" + stuClass + ";");
        rs.next();
        int totalAttendanceRecords = rs.getInt(1);
        rs = stmt.executeQuery("select count(*) from Attendance where class=" + stuClass + " and Attendance='Present';");
        rs.next();
        int totalPresent = rs.getInt(1);
        System.out.println("Total No of Records: " + totalAttendanceRecords);
        System.out.println("Total No of Present: " + totalPresent);
        System.out.println("Attendance Percent of Class " + stuClass + ": " + (double)totalPresent  / totalAttendanceRecords * 100);
    }

    @Override
    public void getStudentAttendanceReport(int studentID) throws SQLException {
        ResultSet rs = stmt.executeQuery("select count(*) from Attendance where studentID=" + studentID + ";");
        rs.next();
        int totalAttendanceRecords = rs.getInt(1);
        rs = stmt.executeQuery("select count(*) from Attendance where studentID=" + studentID + " and Attendance='Present';");
        rs.next();
        int totalPresent = rs.getInt(1);
        System.out.println("Total No of Records: " + totalAttendanceRecords);
        System.out.println("Total No of Present: " + totalPresent);
        System.out.println("Attendance Percent of " + studentID + ": " + (double)totalPresent  / totalAttendanceRecords * 100);
    }
}
