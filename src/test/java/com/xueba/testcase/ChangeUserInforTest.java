package com.xueba.testcase;

import org.testng.annotations.Test;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.utils.EmailGenerator;
import com.utils.IDGenerator;
import com.utils.PhoneGenerator;
import com.zhijin.EmailPage;
import com.zhijin.HomePage;
import com.zhijin.LoginPage;
import com.zhijin.PhonePage;
import com.zhijin.RegisterPage;
import com.zhijin.UserInforPage;
import com.zhijin.UserPage;

/**
 * 
 * @author hxl
 *
 */

public class ChangeUserInforTest {
	
	private LoginPage loginPage;
	private RegisterPage registerPage;
	private HomePage homePage;
	private UserPage userPage;
	private UserInforPage userInforPage;
	private PhonePage phonePage;
	private EmailPage emailPage;
	
	private String phone1 = "18910213610";
	private String phone2 = "18910213611";
	private String email1 = "ting2jinjin@gmail.com";
	private String email2 = "ting3jinjin@gmail.com";
	private String authcode = "789456";

	@Test
	@MobileTest
	public void testChangeUserInforTest() {
		
	}
	
	public void init() {
		loginPage = new LoginPage();
		registerPage = new RegisterPage();
		homePage = new HomePage();
		userPage = new UserPage();
		userInforPage = new UserInforPage();
		phonePage = new PhonePage();
		emailPage = new EmailPage();
	}
	
	
	public void login() {
		WebDriverWaitUtils.waitUntilElementIsVisible(loginPage.getPhoneTextField());
		loginPage.getPhoneTextField().setText(null);
		loginPage.getAuthcodeTextField().setText(authcode);
		loginPage.getLoginButton().tap(homePage.getDynamicList());
		SeLionReporter.log("login successfully, goto homepage now", true); 
	}
	
	public void changeUserInfor() {
		
	}
	
	public void changePhone() {
		
	}
	
	public void changeEmail() {
		
	}
	
}
