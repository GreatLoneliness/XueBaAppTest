package com.xueba.testcase;

import org.testng.annotations.Test;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.mobile.elements.MobileTextField;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.zhijin.HomePage;
import com.zhijin.LoginPage;
import com.zhijin.PhonePage;
import com.zhijin.UserInforPage;
import com.zhijin.UserPage;

/**
 * 
 * @author hxl
 *
 */

public class ChangePhoneTest {

	private LoginPage loginPage;
	private HomePage homePage;
	private UserPage userPage;
	private UserInforPage userInforPage;
	private PhonePage phonePage;

	private String phone1 = "18910213610";
	private String phone2 = "18910213611";
	private String authcode = "789456";

	public void init() {
		loginPage = new LoginPage();
		homePage = new HomePage();
		userPage = new UserPage();
		userInforPage = new UserInforPage();
		phonePage = new PhonePage();
	}

	@Test
	@MobileTest
	public void testChangePhone() {
		init();
		login(phone1, authcode);
	    changePhone(phone1, phone2);
	}

	public void login(String phone, String authcode) {
		WebDriverWaitUtils.waitUntilElementIsVisible(loginPage.getPhoneTextField());
		loginPage.getPhoneTextField().setText(phone1);
		loginPage.getAuthcodeTextField().setText(authcode);
		loginPage.getLoginButton().tap(homePage.getUserElement());
	}

	public void changePhone(String phone1, String phone2) {
		homePage.getUserElement().tap(userPage.getUserInforElement());
		userPage.getUserInforElement().tap(userInforPage.getPhoneElement());
		setPhone(phone1, phone2);
		setPhone(phone2, phone1);
	}

	public void setPhone(String phone1, String phone2) {
		userInforPage.getPhoneElement().tap(phonePage.getPhoneTextField());
		WebDriverWaitUtils.waitUntilElementIsVisible(phonePage.getPhoneTextField());
		clearText(phonePage.getPhoneTextField(), phone1);
		phonePage.getPhoneTextField().setText(phone2);
		phonePage.getAuthcodeTextField().setText(authcode);
		phonePage.getBindButton().tap(userInforPage.getPhoneElement());
		SeLionReporter.log("change successfully, goto user information page now", true);
	}
	
	public void clearText(MobileTextField tx, String str) {
		for (int i = 0; i < str.length(); ++i) {
			tx.clearText();
		}
	}

}
