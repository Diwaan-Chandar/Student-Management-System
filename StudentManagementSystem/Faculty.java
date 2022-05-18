package StudentManagementSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class Faculty extends User{
    FacultyInterface fac = new Management();
    Scanner sc = new Scanner(System.in);
    public Faculty(int userID) throws SQLException {
        this.userID = userID;
    }
    void facultyHome() throws SQLException {
        while(true) {
            System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.println("█ 1. Add Student                            █");
            System.out.println("█ 2. Remove Student                         █");
            System.out.println("█ 3. Edit Student                           █");
            System.out.println("█ 4. Exams                                  █");
            System.out.println("█ 5. Attendance                             █");
            System.out.println("█ 6. Approve Student Leave                  █");
            System.out.println("█ 7. LogOut                                 █");
            System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    fac.addStudent();
                    break;
                case 2:
                    fac.removeStudent();
                    break;
                case 3:
                    fac.editStudent();
                    break;
                case 4:
                    Exams exam = new Exams();
                    exam.examsFacultyHome(userID);
                    break;
                case 5:
                    Attendance att = new Attendance();
                    att.attendanceHome(userID);
                    break;
                case 6:
                    fac.approveLeave(userID);
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
