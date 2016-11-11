package com.xueba.testcase;

import org.testng.annotations.Test;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.xueba.pageext.LoginPageExt;
import com.xueba.pageext.StudyPageExt;

/**
 * 
 * @author hxl
 *
 */

public class LoginTest {

	private LoginPageExt loginPageExt;
	private StudyPageExt studyPageExt;

	private String phone = "18910213610";
	private String authcode = "789456";

	@Test
	@MobileTest
	public void testLogin() {
		init();
		loginPageExt.login(phone, authcode);
		WebDriverWaitUtils.waitUntilElementIsVisible(studyPageExt.getDynamicList());
		SeLionReporter.log("login successfully, at study page now", true);
	}

	public void init() {
		loginPageExt = new LoginPageExt();
		studyPageExt = new StudyPageExt();
	}

}
