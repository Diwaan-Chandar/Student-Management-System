package StudentManagementSystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exams {
    Scanner sc = new Scanner(System.in);
    ExamsInterface ex = new ExamDatabase();
    int stuClass;

    public Exams() throws SQLException {
    }

    void examsFacultyHome(int facultyID) throws SQLException {
        while(true) {
            System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.println("█ 1. View Exams                             █");
            System.out.println("█ 2. Add Marks                              █");
            System.out.println("█ 3. Calculate Class Average                █");
            System.out.println("█ 4. Generate Report                        █");
            System.out.println("█ 5. Exit                                   █");
            System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ex.displayExams();
                    break;
                case 2:
                    ex.displayExams();
                    System.out.print("Enter the Exam ID: ");
                    int examID = sc.nextInt();
                    ex.displaySubjects();
                    System.out.print("Enter the Subject ID: ");
                    int subjectID = sc.nextInt();
                    System.out.print("Enter the Class: ");
                    stuClass = sc.nextInt();
                    ex.addMarks(examID, subjectID, stuClass, facultyID);
                    break;
                case 3:
                    System.out.print("Enter the Class: ");
                    stuClass = sc.nextInt();
                    ex.classAverage(stuClass);
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    int studentID = sc.nextInt();
                    ex.displayExams();
                    System.out.print("Enter Exam ID: ");
                    examID = sc.nextInt();
                    ex.generateReport(studentID, examID);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}
