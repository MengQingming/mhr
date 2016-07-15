package com.boe.personnel.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	public static String digest(String s)
	{
		char hexDigits[] =
		{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
				'e', 'f' };
		byte[] strTemp = s.getBytes();
		MessageDigest mdTemp;
		byte[] md = null;
		try
		{
			mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			md = mdTemp.digest();
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		int j = md.length;
		char str[] = new char[j * 2];
		int k = 0;
		for (int i = 0; i < j; i++)
		{
			byte byte0 = md[i];
			str[k++] = hexDigits[byte0 >>> 4 & 0xf];
			str[k++] = hexDigits[byte0 & 0xf];
		}
		return new String(str);
	}

	 
}
