package StudentManagementSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class Admin{
    AdminInterface adm = new Management();
    FeedBackAdminInterface fb = new FeedbackDatabase();
    Scanner sc = new Scanner(System.in);
    public Admin() throws SQLException {
    }
    void adminHome() throws SQLException {
        while(true) {
            System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.println("█ 1. Add Student                            █");
            System.out.println("█ 2. Remove Student                         █");
            System.out.println("█ 3. Edit Student                           █");
            System.out.println("█ 4. Add Faculty                            █");
            System.out.println("█ 5. Remove Faculty                         █");
            System.out.println("█ 6. Edit Faculty                           █");
            System.out.println("█ 7. Add Exam                               █");
            System.out.println("█ 8. Remove Exam                            █");
            System.out.println("█ 9. Add Subject                            █");
            System.out.println("█ 10. Remove Subject                        █");
            System.out.println("█ 11. Comment Feedback                      █");
            System.out.println("█ 12. Comment Report                        █");
            System.out.println("█ 13. LogOut                                █");
            System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    adm.addStudent();
                    break;
                case 2:
                    adm.removeStudent();
                    break;
                case 3:
                    adm.editStudent();
                    break;
                case 4:
                    adm.addFaculty();
                    break;
                case 5:
                    adm.removeFaculty();
                    break;
                case 6:
                    adm.editFaculty();
                    break;
                case 7:
                    adm.addExam();
                    break;
                case 8:
                    adm.removeExam();
                    break;
                case 9:
                    adm.addSubject();
                    break;
                case 10:
                    adm.removeSubject();
                    break;
                case 11:
                    fb.commentFeedBack();
                    break;
                case 12:
                    fb.commentReport();
                    break;
                case 13:
                    return;
                default:
                    System.out.println("Invalid Choice! Please Try Again!");
                    break;
            }
        }
    }
}
