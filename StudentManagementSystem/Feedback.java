package StudentManagementSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class Feedback {
    Scanner sc = new Scanner(System.in);
    FeedbackInterface fb = new FeedbackDatabase();

    public Feedback() throws SQLException {
    }

    void reportFaculty(String userName) throws SQLException {
        System.out.print("Enter FacultyID to report: ");
        int facultyID = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter your Report: ");
        String report = sc.nextLine();
        fb.reportFaculty(userName, facultyID, report);
    }

    void giveFeedback(String userName) throws SQLException {
        System.out.print("Enter your FeedBack: ");
        String feedBack = sc.nextLine();
        fb.giveFeedback(userName, feedBack);
    }

}
