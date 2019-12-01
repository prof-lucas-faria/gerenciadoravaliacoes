package siaproweb.core;

import java.math.BigInteger;
import java.security.MessageDigest;

public final class EncryptMD5 {
	
	private static MessageDigest m;
	private static BigInteger textConverted;
	
	public final static String encryptText(String text) {
		try
		{
		    m = MessageDigest.getInstance("MD5");
		    m.update(text.getBytes(), 0, text.length());
		    textConverted = new BigInteger(1, m.digest());
		    text = String.format("%1$032X", textConverted);
		    return text;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
