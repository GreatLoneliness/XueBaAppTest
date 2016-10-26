package com.xueba.testcase;

import org.testng.annotations.Test;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.mobile.elements.MobileTextField;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.zhijin.EmailPage;
import com.zhijin.HomePage;
import com.zhijin.LoginPage;
import com.zhijin.UserInforPage;
import com.zhijin.UserPage;

/**
 * 
 * @author hxl
 *
 */

public class ChangeEmailTest {

	private LoginPage loginPage;
	private HomePage homePage;
	private UserPage userPage;
	private UserInforPage userInforPage;
	private EmailPage emailPage;

	private String phone = "18910213610";
	private String authcode = "789456";
	private String email1 = "ting2jinjin@gmail.com";
	private String email2 = "ting3jinjin@gmail.com";

	public void init() {
		loginPage = new LoginPage();
		homePage = new HomePage();
		userPage = new UserPage();
		userInforPage = new UserInforPage();
		emailPage = new EmailPage();
	}

	@Test
	@MobileTest
	public void testChangePhone() {
		init();
		login(phone, authcode);
		changeEmail(email1, email2);
	}

	public void login(String phone, String authcode) {
		WebDriverWaitUtils.waitUntilElementIsVisible(loginPage.getPhoneTextField());
		loginPage.getPhoneTextField().setText(phone);
		loginPage.getAuthcodeTextField().setText(authcode);
		loginPage.getLoginButton().tap(homePage.getUserElement());
	}

	public void changeEmail(String email1, String email2) {
		homePage.getUserElement().tap(userPage.getUserInforElement());
		userPage.getUserInforElement().tap(userInforPage.getEmailElement());
		setEmail(email1,email2);
		setEmail(email2, email1);
	}

	public void setEmail(String email1, String email2) {
		WebDriverWaitUtils.waitUntilElementIsVisible(userInforPage.getEmailElement());
		userInforPage.getEmailElement().tap(emailPage.getEmailTextField());
		WebDriverWaitUtils.waitUntilElementIsVisible(emailPage.getEmailTextField());
		clearText(emailPage.getEmailTextField(), email1);
		emailPage.getEmailTextField().setText(email2);
		emailPage.getBindButton().tap(userInforPage.getPhoneElement());
		SeLionReporter.log("change successfully, goto user information page now", true);
	}
	
	public void clearText(MobileTextField tx, String str) {
		for (int i = 0; i < str.length(); ++i) {
			tx.clearText();
		}
	}

}
