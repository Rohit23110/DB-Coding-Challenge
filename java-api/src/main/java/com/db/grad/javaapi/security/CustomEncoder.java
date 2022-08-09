package com.db.grad.javaapi.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.db.grad.javaapi.security.util.AESEncryption;

public class CustomEncoder implements PasswordEncoder {
private final String SECRET_KEY = "28A6C965FAE7FFB4FB7ED769";
	
	@Override
	public String encode(CharSequence plainText){
		
		AESEncryption aesEncryption = new AESEncryption(SECRET_KEY);
		
		try {
			String encryptedText = aesEncryption.encrypt(plainText.toString());
			return encryptedText;
		}catch(Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public boolean matches(CharSequence plainText, String encodedText) {
		try {
			String incomingTextEncrypted = this.encode(plainText);
			return incomingTextEncrypted.equals(encodedText);
		}catch(NullPointerException e) {
			return false;
		}
	}

	public String decode(String encodedText) {
		AESEncryption aesEncryption = new AESEncryption(SECRET_KEY);
		try {
			String plainText = aesEncryption.decrypt(encodedText.toString());
			return plainText;
			
		}catch(Exception e) {
			System.out.println(e);
			return "";
		}
	}
}
