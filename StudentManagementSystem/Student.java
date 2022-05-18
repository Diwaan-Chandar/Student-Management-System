package StudentManagementSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class Student extends User{
    Scanner sc = new Scanner(System.in);
    StudentInterface stu = new Management();

    public Student(int userID) throws SQLException {
        this.userID = userID;
    }

    void studentHome() throws SQLException {
        Feedback fb = new Feedback();
        int anonymous;
        while(true) {
            System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.println("█ 1. View Grades                            █");
            System.out.println("█ 2. Report a Faculty                       █");
            System.out.println("█ 3. Give Feedback                          █");
            System.out.println("█ 4. Leave Apply                            █");
            System.out.println("█ 5. Leave Status                           █");
            System.out.println("█ 6. Attendance Report                      █");
            System.out.println("█ 7. LogOut                                 █");
            System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ExamsInterface ex = new ExamDatabase();
                    ex.displayExams();
                    System.out.print("Enter exam ID: ");
                    int examID = sc.nextInt();
                    stu.viewGrades(userID, examID);
                    break;
                case 2:
                    System.out.println("Do you want to report anonymously?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    System.out.print("Enter your choice: ");
                    anonymous = sc.nextInt();
                    if(anonymous == 1) fb.reportFaculty("Anonymous");
                    else if (anonymous == 2) fb.reportFaculty(String.valueOf(userID));
                    break;
                case 3:
                    System.out.println("Do you want to report anonymously?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    System.out.print("Enter your choice: ");
                    anonymous = sc.nextInt();
                    if(anonymous == 1) fb.giveFeedback("Anonymous");
                    else if (anonymous == 2) fb.giveFeedback(String.valueOf(userID));
                    break;
                case 4:
                    stu.leaveApply(userID);
                    break;
                case 5:
                    stu.leaveStatus(userID);
                    break;
                case 6:
                    StudentAttendanceInterface att = new AttendanceDatabaseManagement();
                    att.getStudentAttendanceReport(userID);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid Choice! Please Try Again!");
                    break;
            }
        }
    }
}
