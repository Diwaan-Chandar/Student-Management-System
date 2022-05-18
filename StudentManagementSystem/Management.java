package StudentManagementSystem;

import java.sql.SQLException;

public class Management extends User implements AdminInterface, FacultyInterface, StudentInterface{
    DatabaseManagementInterface dbmi = new DatabaseManagement();

    public Management() throws SQLException {
    }

    public void addStudent() throws SQLException {
        System.out.print("Enter Student ID: ");
        userID = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Student MailID: ");
        mailID = sc.nextLine();
        dbmi.addStudent(userID, mailID);
    }

    public void removeStudent() throws SQLException {
        System.out.print("Enter Student ID to remove: ");
        userID = sc.nextInt();
        try {
            System.out.println("Are your sure want to remove " + dbmi.getStudentName(userID) + "(" + userID + ") from the database");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            if (choice == 1) dbmi.removeStudent(userID);
        }
        catch(Exception e) {
            System.out.println("Cannot Delete Student " + userID);
            System.out.println("Either Invalid UserID or Student not yet registered");
        }
    }

    public void addFaculty() throws SQLException {
        System.out.print("Enter Faculty ID: ");
        userID = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Faculty MailID: ");
        mailID = sc.nextLine();
        dbmi.addFaculty(userID, mailID);
    }

    public void removeFaculty() throws SQLException {
        System.out.print("Enter Faculty ID to remove: ");
        userID = sc.nextInt();
        try {
            System.out.println("Are your sure want to remove " + dbmi.getFacultyName(userID) + "(" + userID + ") from the database");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            if (choice == 1) dbmi.removeFaculty(userID);
        }
        catch(Exception e) {
            System.out.println("Cannot Delete Faculty " + userID);
            System.out.println("Either Invalid UserID or Faculty not yet registered");
        }
    }

    public void editStudent() throws SQLException {
        System.out.print("Enter Student ID to edit: ");
        userID = sc.nextInt();
        try {
            System.out.println("Choose which data to edit");
            System.out.println("1. Name");
            System.out.println("2. Class");
            System.out.println("3. Age");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    sc.nextLine();
                    System.out.print("Replace with: ");
                    name = sc.nextLine();
                    dbmi.editStudent(userID, "name", name);
                }
                case 2 -> {
                    System.out.print("Replace with: ");
                    int stuClass = sc.nextInt();
                    dbmi.editStudent(userID, "class", stuClass);
                }
                case 3 -> {
                    System.out.print("Replace with: ");
                    age = sc.nextInt();
                    dbmi.editStudent(userID, "age", age);
                }
                default -> System.out.println("Invalid Choice!!! Returning!!");
            }
        }
        catch (Exception e) {
            System.out.println("Cannot Delete Student " + userID);
            System.out.println("Either Invalid UserID or Student not yet registered");
        }
    }

    @Override
    public void approveLeave(int userID) throws SQLException {
        try {
            System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.println("█ 1. Display Applied Leave                  █");
            System.out.println("█ 2. Approve Leave                          █");
            System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> dbmi.displayLeaveApplyTable();
                case 2 -> {
                    System.out.print("Enter Leave ID to approve: ");
                    int leaveID = sc.nextInt();
                    String facName = dbmi.getFacultyName(userID);
                    dbmi.approveLeave(leaveID, facName);
                }
                default -> System.out.println("Invalid Choice");
            }
        }
        catch (Exception e) {
            System.out.println("Invalid Input");
        }
    }

    public void editFaculty() throws SQLException {
        System.out.print("Enter Faculty ID to edit: ");
        userID = sc.nextInt();
        try {
            System.out.println("Choose which data to edit");
            System.out.println("1. Name");
            System.out.println("2. Subject");
            System.out.println("3. Age");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    sc.nextLine();
                    System.out.print("Replace with: ");
                    name = sc.nextLine();
                    dbmi.editFaculty(userID, "name", name);
                }
                case 2 -> {
                    sc.nextLine();
                    System.out.print("Replace with: ");
                    String subject = sc.nextLine();
                    dbmi.editFaculty(userID, "subject", subject);
                }
                case 3 -> {
                    System.out.print("Replace with: ");
                    age = sc.nextInt();
                    dbmi.editFaculty(userID, "age", age);
                }
                default -> System.out.println("Invalid Choice!!! Returning!!");
            }
        }
        catch (Exception e) {
            System.out.println("Cannot Delete Faculty " + userID);
            System.out.println("Either Invalid UserID or Faculty not yet registered");
        }
    }

    @Override
    public void removeSubject() throws SQLException {
        System.out.print("Enter Subject ID: ");
        int subjectID = sc.nextInt();
        dbmi.removeSubject(subjectID);
    }

    @Override
    public void addSubject() throws SQLException {
        System.out.print("Enter Subject ID: ");
        int subjectID = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Subject Name: ");
        String subjectName = sc.nextLine();
        dbmi.addSubject(subjectID, subjectName);
    }

    @Override
    public void addExam() throws SQLException {
        System.out.print("Enter Exam ID: ");
        int examID = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Exam Name: ");
        String examName = sc.nextLine();
        dbmi.addExam(examID, examName);
    }

    @Override
    public void removeExam() throws SQLException {
        System.out.print("Enter Exam ID: ");
        int examID = sc.nextInt();
        dbmi.removeExam(examID);
    }

    @Override
    public void leaveApply(int userID) throws SQLException {
        try {
            System.out.print("Enter from Date in the format (YYYY-MM-DD): ");
            String from = sc.nextLine();
            System.out.print("Enter to Date in the format (YYYY-MM-DD): ");
            String to = sc.nextLine();
            System.out.print("Enter Reason: ");
            String reason = sc.nextLine();
            dbmi.leaveApply(userID, from, to, reason);
        }
        catch (Exception e) {
            System.out.println("Invalid Date provided!!! Please Try Again!!");
        }
    }

    @Override
    public void leaveStatus(int userID) throws SQLException {
        dbmi.displayLeaveApply(userID);
    }

    @Override
    public void viewGrades(int userID, int examID) throws SQLException {
        dbmi.viewGrades(userID, examID);
    }


}
