package StudentManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.Scanner;

public class ExamDatabase implements ExamsInterface {
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagementSystem","root","root");
    Statement stmt = con.createStatement();
    Statement stmt2 = con.createStatement();
    Scanner sc = new Scanner(System.in);

    public ExamDatabase() throws SQLException {
    }

    @Override
    public void addMarks(int examID, int subjectID, int stuClass, int facultyID) throws SQLException {
        ResultSet rs = stmt.executeQuery("select name, studentID from Student where class=" + stuClass + ";");
        while(rs.next()) {
            System.out.print("Enter " + rs.getString(1) + "'s marks: ");
            int studentID = rs.getInt(2);
            int mark = sc.nextInt();
            stmt2.executeUpdate("insert into Marks values(" + examID + ", " + subjectID + ", " + studentID + ", " + stuClass + ", " + facultyID + ", " + mark + ");");
        }
    }

    @Override
    public void classAverage(int stuClass) throws SQLException  {
        ResultSet rs = stmt.executeQuery("select sum(mark) / count(*) from Marks where class=" + stuClass + ";");
        rs.next();
        System.out.println("Class Average: " + rs.getDouble(1));
        rs = stmt.executeQuery("select min(mark) from Marks where class=" + stuClass + ";");
        rs.next();
        System.out.println("Maximum Marks: " + rs.getDouble(1));
        rs = stmt.executeQuery("select max(mark) from Marks where class=" + stuClass + ";");
        rs.next();
        System.out.println("Minimum Marks: " + rs.getDouble(1));
    }

    @Override
    public void generateReport(int studentID, int examID) throws SQLException {
        ResultSet rs = stmt.executeQuery("select * from Marks where studentID=" + studentID + " and examID=" + examID + ";");
        while(rs.next()) {
            System.out.println(rs.getInt(1) + " " +rs.getInt(2) + " " +rs.getInt(3) + " " +rs.getInt(4) + " " +rs.getInt(5) + " " +rs.getInt(6));
        }
    }

    @Override
    public void displayExams() throws SQLException {
        ResultSet rs = stmt.executeQuery("select * from Exams;");
        System.out.println("------------------------");
        System.out.println("ExamID\tExam");
        while(rs.next()) {
            System.out.println(rs.getInt(1) + "\t\t" +rs.getString(2));
        }
        System.out.println("------------------------");
    }

    @Override
    public void displaySubjects() throws SQLException {
        ResultSet rs = stmt.executeQuery("select * from Subjects;");
        System.out.println("------------------------");
        System.out.println("Sub ID\tSubject");
        while(rs.next()) {
            System.out.println(rs.getInt(1) + "\t\t" +rs.getString(2));
        }
        System.out.println("------------------------");
    }
}
