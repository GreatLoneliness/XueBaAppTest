package com.xueba.testcase;

import org.testng.annotations.Test;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.xueba.pageext.EmailPageExt;
import com.xueba.pageext.LoginPageExt;
import com.xueba.pageext.PhonePageExt;
import com.xueba.pageext.StudyPageExt;
import com.xueba.pageext.UserInforPageExt;
import com.xueba.pageext.UserPageExt;

/**
 * 
 * @author hxl
 *
 */

public class ChangeUserInforTest {
	
	private LoginPageExt loginPageExt;
	private StudyPageExt studyPageExt;
	private UserPageExt userPageExt;
	private UserInforPageExt userInforPageExt;
	private PhonePageExt phonePageExt;
	private EmailPageExt emailPageExt;
	
	private String phone1 = "18910213610";
	private String phone2 = "18910219999";	
	private String email1 = "ting2jinjin@gmail.com";
	private String email2 = "ting3jinjin@gmail.com";
	private static String authcode = "789456";

	@Test
	@MobileTest
	public void testChangeUserInforTest() {
		init();
		
		loginPageExt.login(phone1, authcode);
		studyPageExt.gotoUserPage();
		userPageExt.gotoUserInforPage();
		
		changePhone(phone1, phone2, authcode);
		changePhone(phone2, phone1, authcode);
		changeEmail(email1, email2);
		changeEmail(email2, email1);
		
		userInforPageExt.back();
		userPageExt.logout();
		WebDriverWaitUtils.waitUntilElementIsVisible(loginPageExt.getPhoneTextField());
		SeLionReporter.log("logout successfully, at login page now", true);
	}
	
	public void init() {
		loginPageExt = new LoginPageExt();
		studyPageExt = new StudyPageExt();
		userPageExt = new UserPageExt();
		userInforPageExt = new UserInforPageExt();
		phonePageExt = new PhonePageExt();
		emailPageExt = new EmailPageExt();
	}
	
	public void changePhone(String phone1, String phone2, String authcode) {
		userInforPageExt.gotoPhonePage();
	    phonePageExt.changePhone(phone1, phone2, authcode);
	    WebDriverWaitUtils.waitUntilElementIsVisible(userInforPageExt.getPhoneElement());
	    SeLionReporter.log("change successfully, at user information page now", true);
	}	

	public void changeEmail(String email1, String email2) {	
		userInforPageExt.gotoEmailPage();
		emailPageExt.changeEmail(email1, email2);
		WebDriverWaitUtils.waitUntilElementIsVisible(userInforPageExt.getEmailElement());
		SeLionReporter.log("change successfully, at user information page now", true);
	}
	
}
