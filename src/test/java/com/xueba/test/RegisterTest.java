package com.xueba.test;

import org.testng.annotations.Test;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.utils.RandomData;
import com.zhijin.HomePage;
import com.zhijin.LoginPage;
import com.zhijin.RegisterPage;

/**
 * 
 * @author hxl
 *
 */

public class RegisterTest {
	
	private LoginPage loginPage;
	private RegisterPage registerPage;
	private HomePage homePage;
	
	private String authcode = "789456";
	
	@Test
	@MobileTest
	public void testRegister() {
		init();
		WebDriverWaitUtils.waitUntilElementIsVisible(loginPage.getRegisterButton());
		loginPage.getRegisterButton().tap(registerPage.getPhoneTextField());
		registerPage.getPhoneTextField().setText(RandomData.getPhone());
		registerPage.getAuthcodeTextField().setText(authcode);
		registerPage.getRegisterButton().tap(homePage.getDynamicList());
		SeLionReporter.log("register successfully, goto homepage now", true);
	}
	
	public void init() {
		loginPage = new LoginPage();
		registerPage = new RegisterPage();
		homePage = new HomePage();
	}
	
	public boolean isRegistered() {
		return false;
	}
}
