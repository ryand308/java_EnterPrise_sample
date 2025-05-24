package mail.serivce;

import java.util.Properties;
import java.util.stream.Stream;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@ApplicationScoped
public class MailService {
	
	private String from = "QQC@demomailtrap.com"; // MailTrap mailServer( 自定義信箱 )
	
	public void confirmEmail( String to, String account , String token) {
		if(Stream.of(to, account, token).anyMatch(empty -> empty.trim().matches("")))
			return;
		
		// to: 將信件送給建立者確認
		try {
			Message message = new MimeMessage(this.createSession());
			// set From email field; 設定寄件者
            message.setFrom(new InternetAddress(from));
            // 設定收件者
            message.setRecipients( Message.RecipientType.TO, InternetAddress.parse(to));
            // 信件型別 
            message.addHeader("Content-type", "text/html; charset=utf-8");
            // 設定郵件標題
            message.setSubject("會員註冊確認信");
            // 設定郵件內容讓使用者點選連結（confirmUrl）進行確認
            StringBuilder confirmUrl = new StringBuilder();
            confirmUrl.append("<a href=\"")
            		  .append("http://localhost:8080/ServletBasic2/EmailServlet")
            		  .append("?account=" + account)
	            	  .append("&token=" + token)
	            	  .append("\" >信箱確認</a>");
                      
            message.setContent("請點選以下連結進行確認：\n" + confirmUrl, "text/html; charset=utf-8");
			
            // 傳送郵件
            Transport.send(message);
            
		}catch(MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void contactEmail(String name, String subject, String body) {
		if(Stream.of(name, subject, body).anyMatch(empty -> empty.trim().matches("")))
			return;
		
		// 因為是聯絡信箱，統一管理者收信
		String to = "ryand308@gmail.com";
		try {
			Message message = new MimeMessage(this.createSession());
			// set From email field; 設定寄件者
            message.setFrom(new InternetAddress(from));
            // 設定收件者
            message.setRecipients( Message.RecipientType.TO, InternetAddress.parse(to));
            // 信件型別 
            message.addHeader("Content-type", "text/html; charset=utf-8");
            // 設定郵件標題
            message.setSubject(subject);
            // 設定郵件內容
            message.setContent(name + "<br/>" + body, "text/html; charset=utf-8");
            
            // 傳送郵件
            Transport.send(message);
			
		}catch(MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Session createSession() {
		// provider account credential
		final String username = "smtp@mailtrap.io";
		final String password = "db5486e9835f3fc2b79193090110faa2";
		
		String host = "live.smtp.mailtrap.io";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		// 使用者的身分驗證
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(username, password);
			}			
		};
		
		// create the mail Session object；建立會話物件
		Session session = Session.getInstance(props, auth);		
		return session;
	}
}
