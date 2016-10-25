package com.xueba.testcase;

import org.testng.annotations.Test;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.utils.EmailGenerator;
import com.utils.IDGenerator;
import com.utils.PhoneGenerator;
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
	
	public void init() {
		loginPage = new LoginPage();
		registerPage = new RegisterPage();
		homePage = new HomePage();		
	}
	
	@Test
	@MobileTest
	public void testRegister() {
		init();
		WebDriverWaitUtils.waitUntilElementIsVisible(loginPage.getRegisterButton());
		loginPage.getRegisterButton().tap(registerPage.getPhoneTextField());
		registerPage.getPhoneTextField().setText(PhoneGenerator.getPhone());
		registerPage.getAuthcodeTextField().setText(authcode);
		registerPage.getIdTextField().setText(IDGenerator.getID());
		registerPage.getMailTextField().setText(EmailGenerator.getEmail(6, 18));
		registerPage.getRegisterButton().tap(homePage.getDynamicList());
		SeLionReporter.log("register successfully, goto homepage now", true);
	}

}
