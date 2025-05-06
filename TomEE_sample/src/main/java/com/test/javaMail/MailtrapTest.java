package com.test.javaMail;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class MailtrapTest {

	public static void main(String[] args) {
		// 參考網站https://mailtrap.io/blog/java-send-email/
		String to = "from@example.com";
		String from = "xxx@gmail.com";
		
		String username = "998xx"; // copy mailTrap
		String password = "044xx";
		
		String host = "sandbox.smtp.mailtrap.io"; // mailTrap host; testing email
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // TLS
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "2525"); // or 2525
		
        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            
            message.setSubject("Hello from Java!");
            message.addHeader("Content-type", "text/html; charset=utf-8");
//            message.setText(text);
            message.setContent("This is a test email sent via Mailtrap using Java and TomEE. 中文測試", "text/html");

            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
	}

}
