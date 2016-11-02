package com.xueba.testcase;

import org.testng.annotations.Test;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.xueba.datagenerator.EmailGenerator;
import com.xueba.datagenerator.IDGenerator;
import com.xueba.datagenerator.PhoneGenerator;
import com.xueba.pageext.LoginPageExt;
import com.xueba.pageext.RegisterPageExt;
import com.xueba.pageext.StudyPageExt;

/**
 * 
 * @author hxl
 *
 */

public class RegisterTest {
	
	private LoginPageExt loginPageExt;
	private RegisterPageExt registerPageExt;
	private StudyPageExt studyPageExt;
	
	private String phone = PhoneGenerator.getPhone();
	private String authcode = "789456";
	private String id = IDGenerator.getID();
	private String email = EmailGenerator.getEmail(6, 9);
		
	@Test
	@MobileTest
	public void testRegister() {
		init();
		loginPageExt.gotoRegisterPage();
		registerPageExt.register(phone, authcode, id, email);
		WebDriverWaitUtils.waitUntilElementIsVisible(studyPageExt.getDynamicList());
		SeLionReporter.log("register successfully, goto study page now", true);
	}
	
	public void init() {
		loginPageExt = new LoginPageExt();
		registerPageExt = new RegisterPageExt();
		studyPageExt = new StudyPageExt();
	}

}
