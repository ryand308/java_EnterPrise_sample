package com.test.crypto4j;

import java.security.SecureRandom;

import com.password4j.Password;

public class HashMain {

	public static void main(String[] args) {
	
//		SecureRandom random = new SecureRandom();
//		byte[] salt = new byte[16];
//		random.nextBytes(salt);
		String salt = "SHIH0uKIeW6iNCpjB3rGzg==";
		
		String password = "12345678";
		// 自己加鹽
		String hash0 = Password.hash(password).addSalt(salt).withArgon2().getResult();
		// 內部生成鹽
		String hash = Password.hash(password).addRandomSalt(16).withArgon2().getResult();
		
		System.out.println("Hash: " + hash0);
        System.out.println("Hash: " + hash);
        System.out.println(hash0.length());
        System.out.println(hash.length());

        boolean matched2 = Password.check("12345678", hash0).withArgon2();
        boolean matched = Password.check("12345678", hash).withArgon2();
        System.out.println("密碼正確？ " + matched);
        System.out.println("密碼正確？ " + matched2);
     

	}

}
