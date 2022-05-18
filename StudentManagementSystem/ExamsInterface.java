package StudentManagementSystem;

import java.sql.SQLException;

public interface ExamsInterface {
    void addMarks(int examID, int subjectID, int stuClass, int facultyID) throws SQLException;
    void classAverage(int stuClass) throws SQLException ;
    void generateReport(int studentID, int examID) throws SQLException ;
    void displayExams() throws SQLException;
    void displaySubjects() throws SQLException;
}
