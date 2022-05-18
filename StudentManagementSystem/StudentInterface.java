package StudentManagementSystem;

import java.sql.SQLException;

public interface StudentInterface {
    void leaveApply(int userID) throws SQLException;
    void leaveStatus(int userID) throws SQLException;
    void viewGrades(int userID, int examID) throws SQLException;
}
