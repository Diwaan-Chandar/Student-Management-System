package StudentManagementSystem;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class SMTP {
    final String user="diwaan4321@gmail.com";
    final String password="";

    void sendOTP(String to, int otp) {
        Properties props = new Properties();
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("OTP for login");
            message.setText("Here is your OTP " + otp);

            Transport.send(message);

            System.out.println("OTP sent successfully...");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
