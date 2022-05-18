package StudentManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class DatabaseManagement implements DatabaseManagementInterface{
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagementSystem","root","root");
    Statement stmt=con.createStatement();

    public DatabaseManagement() throws SQLException {
    }

    public String findStudentMailID(int userID) throws SQLException {
        try {
            String mailID;
            ResultSet rs = stmt.executeQuery("select mailID from Student where studentID=" + userID + ";");
            rs.next();
            mailID = rs.getString(1);
            return mailID;
        }
        catch(SQLException e) {
            System.out.println("Invalid Student ID");
            return "null";
        }
    }

    public void addStudentData(int userID, String name, int age, String password, int stuClass) throws SQLException {
        String query = "update Student set name=\"" + name + "\", age=" + age + ", password=\"" + password + "\", class=" + stuClass + " where studentID=" + userID + ";";
        stmt.executeUpdate(query);
    }

    public String findFacultyMailID (int userID) throws SQLException {
        try {
            String mailID;
            ResultSet rs = stmt.executeQuery("select mailID from Faculty where facultyID=" + userID + ";");
            rs.next();
            mailID = rs.getString(1);
            return mailID;
        }
        catch(SQLException e) {
            System.out.println("Invalid Faculty ID");
            return "null";
        }
    }

    public void addFacultyData(int userID, String name, int age, String password, String subject) throws SQLException {
        String query = "update Faculty set name=\"" + name + "\", age=" + age + ", password=\"" + password + "\", subject=\"" + subject + "\" where facultyID=" + userID + ";";
        stmt.executeUpdate(query);
    }

    public void addStudent(int userID, String mailID) throws SQLException {
        stmt.executeUpdate("insert into Student values(null, null, null, \'" + mailID + "\', " + userID + ", null);");
    }

    public void removeStudent(int userID) throws SQLException {
        try {
            stmt.executeUpdate("delete from Student where studentID=" + userID + ";");
        }
        catch(SQLException e) {
            System.out.println("Student not found");
        }
    }

    public String getStudentName(int userID) throws SQLException {
        try {
            ResultSet rs = stmt.executeQuery("select name from Student where studentID=" + userID + ";");
            rs.next();
            return rs.getString(1);
        }
        catch (SQLException e) {
            return "null";
        }
    }

    public void addFaculty(int userID, String mailID) throws SQLException {
        stmt.executeUpdate("insert into Faculty values(null, null, \'" + mailID + "\', " + userID + ", null, null);");
    }

    public String getFacultyName(int userID) throws SQLException {
        try {
            ResultSet rs = stmt.executeQuery("select name from faculty where facultyID=" + userID + ";");
            rs.next();
            return rs.getString(1);
        }
        catch (SQLException e) {
            return "null";
        }
    }

    public void removeFaculty(int userID) throws SQLException {
        try {
            stmt.executeUpdate("delete from Faculty where facultyID=" + userID + ";");
        }
        catch(SQLException e) {
            System.out.println("Student not found");
        }
    }

    @Override
    public void editStudent(int userID, String attribute, String name) throws SQLException {
        try {
            stmt.executeUpdate("update Student set " + attribute + "=\'" + name + "\' where studentID=" + userID + ";");
        }
        catch (SQLException e) {
            System.out.println("Student not found");
        }
    }

    @Override
    public void editStudent(int userID, String attribute, int var1) throws SQLException {
        try {
            stmt.executeUpdate("update Student set " + attribute + "=" + var1 + " where studentID=" + userID + ";");
        }
        catch (SQLException e) {
            System.out.println("Student not found");
        }
    }

    @Override
    public void editFaculty(int userID, String attribute, String var1) throws SQLException {
        try {
            stmt.executeUpdate("update Faculty set " + attribute + "=\'" + var1 + "\' where facultyID=" + userID + ";");
        }
        catch (SQLException e) {
            System.out.println("Faculty not found");
        }
    }

    @Override
    public void editFaculty(int userID, String attribute, int var1) throws SQLException {
        try {
            stmt.executeUpdate("update Faculty set " + attribute + "=" + var1 + " where facultyID=" + userID + ";");
        }
        catch (SQLException e) {
            System.out.println("Faculty not found");
        }
    }

    @Override
    public void leaveApply(int userID, String from, String to, String reason) throws SQLException {
        try {
            int leaveID = getLeaveApplyMaxID();
            String query = "insert into LeaveApply values(" + leaveID + ", " + userID + ", \'" + from + "\', \'" + to + "\', \"" + reason + "\", false, null);";
            stmt.executeUpdate(query);
        }
        catch (SQLException e) {
            System.out.println("Error! Couldn't apply leave!");
        }
    }

    @Override
    public void displayLeaveApplyTable() throws SQLException {
        ResultSet rs=stmt.executeQuery("select * from LeaveApply");
        while(rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getDate(3).toString() + " " + rs.getDate(4).toString() + " " + rs.getString(5) + " "  + rs.getBoolean(6) + " "  + rs.getString(7));
        }
    }

    @Override
    public void displayLeaveApply(int userID) throws SQLException {
        ResultSet rs=stmt.executeQuery("select * from LeaveApply where studentID=" + userID);
        while(rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getDate(3).toString() + " " + rs.getDate(4).toString() + " " + rs.getString(5) + " "  + rs.getBoolean(6) + " "  + rs.getString(7));
        }
    }

    @Override
    public void approveLeave(int leaveID, String approvedBy) throws SQLException {
        stmt.executeUpdate("update LeaveApply set status=true, approvedBy=\'" + approvedBy + "\'where leaveID=" + leaveID);
    }

    @Override
    public void removeSubject(int subjectID) throws SQLException {
        stmt.executeUpdate("delete from Subjects where subjectID=" + subjectID + ";");
    }

    @Override
    public void addSubject(int subjectID, String subjectName) throws SQLException {
        try {
            stmt.executeUpdate("insert into Subjects values(" + subjectID + ", \'" + subjectName + "\');");
        }
        catch (SQLException e) {
            System.out.println("Subject ID already available");
        }
    }

    @Override
    public void addExam(int examID, String examName) throws SQLException {
        try {
            stmt.executeUpdate("insert into Exams values(" + examID + ", \'" + examName + "\');");
        }
        catch (SQLException e) {
            System.out.println("Exam ID already available");
        }
    }

    @Override
    public void removeExam(int examID) throws SQLException {
        stmt.executeUpdate("delete from Exams where examID=" + examID + ";");
    }

    @Override
    public void viewGrades(int userID, int examID) throws SQLException {
        ResultSet rs = stmt.executeQuery("select * from Marks where studentID=" + userID + " and examID=" + examID + ";");
        System.out.println("Subject ID\tMark");
        int totalObtained = 0, totalAlloted = 0;
        while(rs.next()) {
            System.out.println(rs.getInt(2) + "\t\t\t" + rs.getInt(6));
            totalObtained += rs.getInt(6);
            totalAlloted += 100;
        }
        System.out.println("\nAverage: " + (float)totalObtained/totalAlloted*100);
    }


    public int getLeaveApplyMaxID() throws SQLException {
        try {
            ResultSet rs = stmt.executeQuery("select max(leaveID) from LeaveApply");
            rs.next();
            if(rs.getInt(1) == 0) return 101;
            return rs.getInt(1) + 1;
        }
        catch (SQLException e) {
            return 101;
        }
    }
}
