package app;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

//this is for login which is not finished yet
public class SecurityUtils {
				
	public static String getPasswordHashed(String password, String salt) {
		String result="";
		
		try {
			// used hash function given (SHA-256)
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			byte[] saltBytes = Base64.getDecoder().decode(salt);
			md.update(saltBytes);
			byte[] bytes = md.digest(password.getBytes());
			
			// encode bytearray to string
			result = Base64.getEncoder().encodeToString(bytes);
			
			
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static String getSalt() {
		String result = "";
		SecureRandom rd = new SecureRandom();
		byte[] salt = new byte[16];
		rd.nextBytes(salt);
		// encode bytearray to string
		result = Base64.getEncoder().encodeToString(salt);
		return result;
		
		
	}
}
