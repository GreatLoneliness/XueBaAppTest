package com.xueba.testcase;


public class AAA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "abc";
		char[] chars = str1.toCharArray();
		str1 = String.valueOf(chars);
		char c1 = str1.charAt(0);
		
		
		if (c1=='a' || c1=='A') {
//			str1.
		}
		char c2 = (char) (c1+1);
		chars[0] += 1;
		System.out.println(chars);
		System.out.println(str1);
	}

}
