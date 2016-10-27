package com.xueba.testcase;

import org.testng.annotations.Test;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.mobile.elements.MobileTextField;
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
	
	private static String phone1 = "";
	private static String phone2 = "";
	private static String email1 = "";
	private static String email2 = "";
	private static String authcode = "789456";

	@Test
	@MobileTest
	public void testChangeUserInforTest() {
		init();
		register();
		changeUserInfor();
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
	
	public void register() {
		WebDriverWaitUtils.waitUntilElementIsVisible(loginPage.getRegisterButton());
		loginPage.getRegisterButton().tap(registerPage.getPhoneTextField());
		phone1 = PhoneGenerator.getPhone();
		phone2 = changeString(phone1);
		registerPage.getPhoneTextField().setText(phone1);
		registerPage.getAuthcodeTextField().setText(authcode);
		registerPage.getIdTextField().setText(IDGenerator.getID());
		email1 = EmailGenerator.getEmail(6, 9);
		email2 = changeString(email1);
		registerPage.getMailTextField().setText(email1);
		registerPage.getRegisterButton().tap(homePage.getUserElement());
		SeLionReporter.log("register successfully, goto homepage now", true);
	}
	
	public void changeUserInfor() {
		changePhone(phone1, phone2);
		changeEmail(email1, email2);
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
	
	
	public void changeEmail(String email1, String email2) {
		WebDriverWaitUtils.waitUntilElementIsVisible("");
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
	
	public String changeString(String str) {
		char[] chars = str.toCharArray();
		
		if (chars[0]=='a' || chars[0]=='A' || chars[0]=='0') {
			chars[0] += 1;
		} else if (chars[0]=='z' || chars[0]=='Z' || chars[0]=='9') {
			chars[0] -= 1;
		} else {
			chars[0] += 1;			
		}
		
		return String.valueOf(chars);
	}
	
	public void clearText(MobileTextField tx, String str) {
		for (int i = 0; i < str.length(); ++i) {
			tx.clearText();
		}
	}
	
}
