package com.ddoc.login.util;

import java.security.MessageDigest;

public class EncryptionAlgorithm {
	
	public static String doCrypto(String passphrase) {
		try {
			MessageDigest algorithm =  MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(passphrase.getBytes("UTF-8"));
			
			StringBuilder hexString = new StringBuilder();
			for(byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
			
			String passphraseEncrypted = hexString.toString();
			
			return passphraseEncrypted;
		}catch(Exception E) {
			return null;
		}
	}
}
