package StudentManagementSystem;

import java.sql.SQLException;

public interface AttendanceManagementInterface {
    void addAttendance(String date, int stuClass, int facultyID);
    void getClassAttendanceReport(int stuClass) throws SQLException;
    void getStudentAttendanceReport(int studentID) throws SQLException;
}
