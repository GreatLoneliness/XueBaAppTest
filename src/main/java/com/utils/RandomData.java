package com.utils;

/**
 * 
 * @author hxl
 *
 */

public class RandomData {
	
	public static String FIXED_PHONE = "13"; 
		
	public static String getPhone() {
		return (FIXED_PHONE + (int)(100000000+Math.random()*899999999));
	}
	
	public static String getID() {
		return null;
	}
	
	public static String getMail() {
		return null;
	}

}
