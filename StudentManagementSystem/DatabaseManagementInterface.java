package StudentManagementSystem;

import java.sql.SQLException;

public interface DatabaseManagementInterface {
    void addStudent(int userID, String mailID) throws SQLException;
    void removeStudent(int userID) throws SQLException;
    String getStudentName(int userID) throws SQLException;
    void addFaculty(int userID, String mailID) throws SQLException;
    String getFacultyName(int userID) throws SQLException;
    void removeFaculty(int userID) throws SQLException;
    void editStudent(int userID, String attribute, String name) throws SQLException;
    void editStudent(int userID, String attribute, int var1) throws SQLException;
    void editFaculty(int userID, String attribute, String var1) throws SQLException;
    void editFaculty(int userID, String attribute, int var1) throws SQLException;
    void leaveApply(int userID, String from, String to, String reason) throws SQLException;
    void displayLeaveApplyTable() throws SQLException;
    void displayLeaveApply(int userID) throws SQLException;
    void approveLeave(int leaveID, String approvedBy) throws SQLException;
    void removeSubject(int subjectID) throws SQLException;
    void addSubject(int subjectID, String subjectName) throws SQLException;
    void addExam(int examID, String examName) throws SQLException;
    void removeExam(int examID) throws SQLException;
    void viewGrades(int userID, int examID) throws SQLException;
}
