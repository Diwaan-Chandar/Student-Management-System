package StudentManagementSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class Attendance {
    AttendanceManagementInterface att = new AttendanceDatabaseManagement();
    Scanner sc = new Scanner(System.in);

    public Attendance() throws SQLException {
    }

    void attendanceHome(int userID) throws SQLException {
        while(true) {
            System.out.println("1. Add Attendance");
            System.out.println("2. Attendance Report");
            System.out.println("3. Exit");
            int choice = new Scanner(System.in).nextInt();
            int stuClass;
            switch (choice) {
                case 1:
                    System.out.print("Enter date in the format (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    System.out.print("Enter class: ");
                    stuClass = sc.nextInt();
                    att.addAttendance(date, stuClass, userID);
                    break;
                case 2:
                    System.out.println("Attendance Report");
                    System.out.println("1. Class Report");
                    System.out.println("2. Individual Student Report");
                    int type = sc.nextInt();
                    if(type == 1) {
                        System.out.print("Enter Class: ");
                        stuClass = sc.nextInt();
                        att.getClassAttendanceReport(stuClass);
                    }
                    if(type == 2) {
                        System.out.print("Enter Student ID: ");
                        int studentID = sc.nextInt();
                        att.getStudentAttendanceReport(studentID);
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
