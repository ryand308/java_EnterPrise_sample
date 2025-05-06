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

public class MailtrapTest2 {

	public static void main(String[] args) {
		// 參考網站https://mailtrap.io/blog/java-send-email/
		String to = "ryand308@gmail.com";
		String from = "QQC@demomailtrap.com";
		
		String username = "smtp@mailtrap.io";
		String password = "";
		
		String host = "live.smtp.mailtrap.io"; // mailTtrap host
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // TLS
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587"); // or 587
		
        // 建立會話物件
        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients( Message.RecipientType.TO, InternetAddress.parse(to));
            
            // sendEmail(String to, String subject, String body)  service method            
            // 信件主旨 subject
            message.setSubject("Hello from Java!");
            // 信件型別 
            message.addHeader("Content-type", "text/html; charset=utf-8");
            
//            message.setText(text); 純文字內容
            // 信件內容 html 格式 body
            message.setContent("This is a test email sent via Mailtrap using Java and TomEE. 中文測試", "text/html; charset=utf-8");

            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
	}

}
