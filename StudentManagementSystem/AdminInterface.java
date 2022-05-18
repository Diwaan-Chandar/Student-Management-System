package StudentManagementSystem;

import java.sql.SQLException;

public interface AdminInterface {
    void addStudent() throws SQLException;
    void removeStudent() throws SQLException;
    void addFaculty() throws SQLException;
    void removeFaculty() throws SQLException;
    void editStudent() throws SQLException;
    void editFaculty() throws SQLException;
    void removeSubject() throws SQLException;
    void addSubject() throws SQLException;
    void addExam() throws SQLException;
    void removeExam() throws SQLException;

}
