package com.xueba.testcase;


import org.testng.annotations.Test;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.zhijin.HomePage;
import com.zhijin.LoginPage;

/**
 * 
 * @author hxl
 *
 */

public class LoginTest {
	
	private LoginPage loginPage;
	private HomePage homePage;
	
	private String phone = "18910213610";
	private String authcode = "789456";
	
	public void init() {
		loginPage = new LoginPage();
		homePage = new HomePage();
	}
	
	@Test
	@MobileTest
	public void testLogin() {
		init();
		WebDriverWaitUtils.waitUntilElementIsVisible(loginPage.getPhoneTextField());
		loginPage.getPhoneTextField().setText(phone);
		loginPage.getAuthcodeTextField().setText(authcode);
		loginPage.getLoginButton().tap(homePage.getDynamicList());
		SeLionReporter.log("login successfully, goto homepage now", true); 
	}
	
	
}
