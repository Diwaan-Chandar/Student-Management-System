package StudentManagementSystem;

import java.sql.SQLException;

public interface StudentAttendanceInterface {
    void getStudentAttendanceReport(int studentID) throws SQLException;
}
