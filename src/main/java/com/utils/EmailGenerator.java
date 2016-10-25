package com.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

public class EmailGenerator {
	
	private static String regexMail = "/^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$/";
	private static String base = "abcdefghijklmnopqrstuvwxyz0123456789";
	private static String[] email_suffix = "@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn"
			.split(",");
		
	public static int getNum(int start, int end) {
		return (int) (Math.random() * (end - start + 1) + start);
	}
		
	public static String getEmail(int lMin, int lMax) {
		int length = getNum(lMin, lMax);
		StringBuffer sb = new StringBuffer();
//		do {
			for (int i = 0; i < length; i++) {
				int number = (int) (Math.random() * base.length());
				sb.append(base.charAt(number));
			}
			sb.append(email_suffix[(int) (Math.random() * email_suffix.length)]);
//		} while(isValid(regexMail, sb.toString()));

		return sb.toString();
	}
	
	public static boolean isValid(String regex, String target) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(target);
		return matcher.matches();
	}
	
	@Test
	public void test() {
		String str = getEmail(6, 18);
		System.out.println(str);
		System.out.println(isValid(regexMail, "abc@qq.com"));
		
	}
}
