package com.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

public class PhoneGenerator {
	
	public static String regexPhone = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$"; 
	private static String[] telFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153"
			.split(",");
	
	
	public static int getNum(int start, int end) {
		return (int) (Math.random() * (end - start + 1) + start);
	}
	
	public static String getPhone() {
		int index = getNum(0, telFirst.length - 1);
		String phone = new String();
		
		do {
			String first = telFirst[index];
			String second = String.valueOf(getNum(1, 888) + 10000).substring(1);
			String thrid = String.valueOf(getNum(1, 9100) + 10000).substring(1);
			phone = first + second + thrid;
		} while (!isValid(regexPhone, phone));

		return phone;
	}
	
	public static boolean isValid(String regex, String target) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(target);
		return matcher.matches();
	}
	
	@Test
	public void test() {
		String str = getPhone();
		System.out.println(str);
		System.out.println(isValid(regexPhone, str));		
	}
}
