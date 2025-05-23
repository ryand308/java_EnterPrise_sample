package login.service.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.password4j.Password;

import jakarta.enterprise.context.Dependent;
@Dependent
public class CryptoUtility {
	
	//---------------服務功能-------------------------------	
	public String hashPassword(String password, String salt) {
		try {
			// 加密演算法: SHA-256
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(toDecode(salt)); // 先放鹽
			byte[] saltAsBytes = md.digest(password.getBytes()); // 再進行加密
			// 將 byte[] 透過 Base64 編碼並轉成 String
			// 方便儲存在資料表中
			return toEncode(saltAsBytes);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String hashPassword(String password) {
		StringBuilder sb = new StringBuilder();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			byte[] digest = md.digest(password.getBytes("UTF-8"));
			for (byte b : digest) {
				sb.append(String.format("%02x", b));
			}			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new String(sb);
	}	
	
	public String hashPasswordPBKDF2(String password, String salt) {
		// 雜湊密碼： PBKDF2+salt
		int iterations = 665536; //增加計算量，讓破解更難（可再提高）
		int keyLength = 256;	 //雜湊長度（位元）
		byte[] hash = null;
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), toDecode(salt), iterations, keyLength);
		try {
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			hash = factory.generateSecret(spec).getEncoded();
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hashPassword = toEncode(hash);
		
		return hashPassword;
	}
	
	public String hashPassword4j(String password, String pepper) {
		
		String hashPassword = Password.hash(password).addRandomSalt(16).addPepper(pepper).withArgon2().getResult();
		
		return hashPassword;
	}
	
	public boolean checkPassword4j(String password, String hashPassword, String pepper) {
		return Password.check(password, hashPassword).addPepper(pepper).withArgon2();
	}
	
	//---------------內部方法-------------------------------
		private String generateSalt() {
			
			SecureRandom random = new SecureRandom();
			byte[] saltAsBytes = new byte[16];
			random.nextBytes(saltAsBytes);		
			return Base64.getEncoder().encodeToString(saltAsBytes);
		}
		
		private String toEncode(byte[] salt) {		
			return Base64.getEncoder().encodeToString(salt);
		}
		
		private byte[] toDecode(String saltEncode) {
			return Base64.getDecoder().decode(saltEncode);
		}
}
