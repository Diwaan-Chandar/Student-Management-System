package StudentManagementSystem;

import com.mysql.cj.log.Log;
import java.sql.SQLException;
import java.util.Scanner;

public class Home {
    public static void main(String[] args) throws SQLException {
        while(true) {
            System.out.println("Welcome to ABC School");
            System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.println("█ 1. LogIn as Student                       █");
            System.out.println("█ 2. LogIn as Faculty                       █");
            System.out.println("█ 3. LogIn as Admin                         █");
            System.out.println("█ 4. Sign Up your Account / Forgot Password █");
            System.out.println("█ 5. Exit                                   █");
            System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
            System.out.print("Enter your choice: ");
            int choice;
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            String userType;
            int userID;
            String password;
            LogIn user = new LogIn();
            switch (choice) {
                case 1:
                    System.out.print("Enter your Student ID: ");
                    userID = sc.nextInt();
                    System.out.print("Enter your Password: ");
                    password = sc.next();
                    userType = "Student";
                    if(user.logIn(userID,password,userType)) {
                        System.out.println("Welcome");
                        new Student(userID).studentHome();
                    }
                    else {
                        System.out.println("Invalid Credentials");
                    }
                    break;
                case 2:
                    System.out.print("Enter your Faculty ID: ");
                    userID = sc.nextInt();
                    System.out.print("Enter your Password: ");
                    password = sc.next();
                    userType = "Teacher";
                    if(user.logIn(password,userID,userType)) {
                        System.out.println("Wecome to ABC school");
                        new Faculty(userID).facultyHome();
                    }
                    else {
                        System.out.println("Invalid Credentials");
                    }
                    break;
                case 3:
                    System.out.print("Enter your Admin ID: ");
                    userID = sc.nextInt();
                    System.out.print("Enter your Password: ");
                    password = sc.next();
                    userType = "Admin";
                    if(user.logIn(password,userType,userID)) {
                        System.out.println("Welcome Admin");
                        new Admin().adminHome();
                    }
                    else {
                        System.out.println("Invalid Credentials");
                    }
                    break;
                case 4:
                    System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
                    System.out.println("█ Enter your account type                   █");
                    System.out.println("█ 1. Student                                █");
                    System.out.println("█ 2. Faculty                                █");
                    System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
                    int accType = sc.nextInt();
                    if(accType == 1) new SignUpAsStudent().signUp();
                    if(accType == 2) new SignUpAsFaculty().signUp();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}
