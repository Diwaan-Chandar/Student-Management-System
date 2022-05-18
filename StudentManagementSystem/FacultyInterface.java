package StudentManagementSystem;

import java.sql.SQLException;

public interface FacultyInterface {
    void addStudent() throws SQLException;
    void removeStudent() throws SQLException;
    void editStudent() throws SQLException;
    void approveLeave(int userID) throws SQLException;
}
