package StudentManagementSystem;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

class SignUpAsFaculty extends User implements SignUp {
    int otp;
    String subject;
    Scanner sc = new Scanner(System.in);
    DatabaseManagement dbm = new DatabaseManagement();
    Random random = new Random();
    SMTP smtp = new SMTP();
    public SignUpAsFaculty() throws SQLException {
    }

    public boolean signUp() throws SQLException {
        System.out.print("Enter your Faculty ID: ");
        userID = sc.nextInt();
        mailID = dbm.findFacultyMailID(userID);
        if (mailID.equals("null")) return false;
        otp = random.nextInt(1000,9999);
        smtp.sendOTP(mailID, otp);
        System.out.print("Enter OTP sent to your Mail: ");
        int otpInput = sc.nextInt();
        if(otp == otpInput) {
            sc.nextLine();
            System.out.print("Enter your Name: ");
            name = sc.nextLine();
            System.out.print("Enter your Age: ");
            age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter your Password: ");
            password = sc.nextLine();
            System.out.print("Enter your Subject: ");
            subject = sc.nextLine();
            dbm.addFacultyData(userID, name, age, password, subject);
            System.out.println("Account Created Successfully");
            return true;
        }
        else {
            System.out.println("Incorrect OTP");
            return false;
        }
    }
}
