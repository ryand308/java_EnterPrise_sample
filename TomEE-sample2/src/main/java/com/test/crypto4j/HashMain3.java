package com.test.crypto4j;

import java.security.SecureRandom;

import com.password4j.Password;

public class HashMain3 {

	public static void main(String[] args) {
	
//		SecureRandom random = new SecureRandom();
//		byte[] salt = new byte[16];
//		random.nextBytes(salt);
		String salt = "SHIH0uKIeW6iNCpjB3rGzg==";
		
		String password = "12345678";
		String user = "admin";
		String account = "小白";
		// 自己加鹽
//		String hash = Password.hash(password).addSalt(salt).withArgon2().getResult();
		String hash = Password.hash(password).addRandomSalt(16).addPepper(user+account).withArgon2().getResult();
		System.out.println("Hash: " + hash);
        
        System.out.println(hash.length());      
       
//        boolean matched = Password.check("12345678", hash).withArgon2();
        boolean matched = Password.check("12345678", hash).addPepper(user+account).withArgon2();
        System.out.println("密碼正確？ " + matched);
        
     

	}

}
