package com.xueba.testcase;

import org.testng.annotations.Test;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
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

public class ChangePhoneTest {

	private LoginPageExt loginPageExt;
	private StudyPageExt studyPageExt;
	private UserPageExt userPageExt;
	private UserInforPageExt userInforPageExt;
	private PhonePageExt phonePageExt;

	private String phone1 = "18910213610";
	private String phone2 = "18910219999";
	private String authcode = "789456";


	@Test
	@MobileTest
	public void testChangePhone() {
		init();
		loginPageExt.login(phone1, authcode);
		studyPageExt.gotoUserPage();
		userPageExt.gotoUserInforPage();
		changePhone(phone1, phone2, authcode);
		changePhone(phone2, phone1, authcode);
	}
	
	public void init() {
		loginPageExt = new LoginPageExt();
		studyPageExt = new StudyPageExt();
		userPageExt = new UserPageExt();
		userInforPageExt = new UserInforPageExt();
		phonePageExt = new PhonePageExt();
	}
	
	public void changePhone(String phone1, String phone2, String authcode) {
		userInforPageExt.gotoPhonePage();
	    phonePageExt.changePhone(phone1, phone2, authcode);
	    WebDriverWaitUtils.waitUntilElementIsVisible(userInforPageExt.getPhoneElement());
	    SeLionReporter.log("change successfully, goto user information page now", true);
	}

}
