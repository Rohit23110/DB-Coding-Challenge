package com.db.grad.javaapi.security.util;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryption {
	private byte[] keyValue;
	
	public AESEncryption(String key) {
		this.keyValue = key.getBytes();
	}
	
	private Key generateKey () {
		return new SecretKeySpec(this.keyValue, "AES");
	}
	
	public String encrypt(String plainText) throws Exception{
		Key key = this.generateKey();
		Cipher c = Cipher.getInstance("AES");
		c.init(Cipher.ENCRYPT_MODE, key);
		return "$2aAES$" + Base64.getEncoder().encodeToString(c.doFinal(plainText.getBytes(StandardCharsets.UTF_8)));
	}
	
	public String decrypt(String encodedText) throws Exception {
		String initialHash = encodedText.substring(0, 7);
		if(!initialHash.equals("$2aAES$"))
				throw new InvalidKeyException();
		
    	encodedText = encodedText.substring(7);
		
		Key key=this.generateKey();
		Cipher c = Cipher.getInstance("AES");
		c.init(Cipher.DECRYPT_MODE, key);
		return new String(c.doFinal(Base64.getDecoder().decode(encodedText)));
	}
}

