package com.test.crypto4j;

import java.security.SecureRandom;
import java.util.Base64;

import login.service.utility.CryptoUtility;

public class HashMain2 {

	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		
		String saltEncode = Base64.getEncoder().encodeToString(salt);

		String password = "12345678";
		
		CryptoUtility crypto = new CryptoUtility();
//		String hashPassword = crypto.hashPassword(password, saltEncode);
		
//		System.out.println(hashPassword);
		

	}

}
