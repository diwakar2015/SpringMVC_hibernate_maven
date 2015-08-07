/**
 * 
 */
package com.diwakar.springexample.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *  @author Diwakar
 *
 * Date:  Aug 7, 2015 2015
 * File: MessageDigest.java
 */
public class MessageDigestHash {

	public static String md5(String toHash)
	{
		MessageDigest m = null;
		try
		{
			m = MessageDigest.getInstance("MD5");
		}
		catch (NoSuchAlgorithmException e)
		{		
			e.printStackTrace();
		}
		byte[] data = toHash.getBytes(); 
		m.update(data,0,data.length);
		BigInteger i = new BigInteger(1,m.digest());
		return String.format("%1$032X", i);
	}
	
	public static String sha1(String toHash)
	{
		MessageDigest m = null;
		try
		{
			m = MessageDigest.getInstance("SHA1");
		}
		catch (NoSuchAlgorithmException e)
		{		
			e.printStackTrace();
		}
		byte[] data = toHash.getBytes(); 
		m.update(data,0,data.length);
		BigInteger i = new BigInteger(1,m.digest());
		return String.format("%1$040X", i);
	}
}

