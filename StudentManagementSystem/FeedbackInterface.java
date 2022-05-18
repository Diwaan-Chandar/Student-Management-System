package StudentManagementSystem;

import java.sql.SQLException;

public interface FeedbackInterface {
    void reportFaculty(String userName, int facultyID, String report) throws SQLException;
    void giveFeedback(String userName, String feedBack) throws SQLException;
}
