package com.xueba.testcase;

import org.testng.annotations.Test;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.xueba.pageext.BottomToolbarExt;
import com.xueba.pageext.EmailPageExt;
import com.xueba.pageext.LoginPageExt;
import com.xueba.pageext.UserInforPageExt;
import com.xueba.pageext.UserPageExt;

/**
 * 
 * @author hxl
 *
 */

public class ChangeEmailTest {

	private LoginPageExt loginPageExt;
	private UserPageExt userPageExt;
	private UserInforPageExt userInforPageExt;
	private EmailPageExt emailPageExt;
	private BottomToolbarExt bottomToolbarExt;

	private String phone = "18910213610";
	private String authcode = "789456";
	private String email1 = "ting2jinjin@gmail.com";
	private String email2 = "ting3@gmail.com";



	@Test
	@MobileTest
	public void testChangeEmail() {
		init();
		loginPageExt.login(phone, authcode);
		bottomToolbarExt.gotoUserPage();
		userPageExt.gotoUserInforPage();
		changeEmail(email1, email2);
		changeEmail(email2, email1);
	}
	
	public void init() {
		loginPageExt = new LoginPageExt();
		userPageExt = new UserPageExt();
		userInforPageExt = new UserInforPageExt();
		emailPageExt = new EmailPageExt();
		bottomToolbarExt = new BottomToolbarExt();
	}

	public void changeEmail(String email1, String email2) {	
		userInforPageExt.gotoEmailPage();
		emailPageExt.changeEmail(email1, email2);
		WebDriverWaitUtils.waitUntilElementIsVisible(userInforPageExt.getEmailElement());
		SeLionReporter.log("change successfully, at user information page now", true);
	}

	


}
