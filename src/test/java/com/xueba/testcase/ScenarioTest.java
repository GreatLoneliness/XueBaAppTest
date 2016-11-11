package com.xueba.testcase;

import org.testng.annotations.Test;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.xueba.datagenerator.EmailGenerator;
import com.xueba.datagenerator.IDGenerator;
import com.xueba.datagenerator.PhoneGenerator;
import com.xueba.pageext.BottomToolbarExt;
import com.xueba.pageext.EmailPageExt;
import com.xueba.pageext.LoginPageExt;
import com.xueba.pageext.NoticePageExt;
import com.xueba.pageext.PhonePageExt;
import com.xueba.pageext.RegisterPageExt;
import com.xueba.pageext.StudyPageExt;
import com.xueba.pageext.UserInforPageExt;
import com.xueba.pageext.UserPageExt;
import com.xueba.util.NoticeUtil;

/**
 * 
 * @author hxl
 *
 */

@Test(singleThreaded = true)
@MobileTest
public class ScenarioTest {

	private LoginPageExt loginPageExt;
	private RegisterPageExt registerPageExt;
	private StudyPageExt studyPageExt;
	private UserPageExt userPageExt;
	private UserInforPageExt userInforPageExt;
	private PhonePageExt phonePageExt;
	private EmailPageExt emailPageExt;
	private NoticePageExt noticePageExt;
	private BottomToolbarExt bottomToolbarExt;

	private String phone = PhoneGenerator.getPhone();
	private String authcode = "789456";
	private String id = IDGenerator.getID();
	private String email = EmailGenerator.getEmail(6, 8);
	private String phone1 = "18910213610";
	private String phone2 = "18910219999";
	private String email1 = "ting2jinjin@gmail.com";
	private String email2 = "ting3jinjin@gmail.com";

	@Test(priority = 1)
	public void testRegister() {
		init();
		loginPageExt.gotoRegisterPage();
		registerPageExt.register(phone, authcode, id, email);
		WebDriverWaitUtils.waitUntilElementIsVisible(studyPageExt.getDynamicList());
		SeLionReporter.log("register successfully, at study page now", true);
	}

	@Test(priority = 2)
	public void testLogin() {
		bottomToolbarExt.gotoUserPage();
		userPageExt.logout();
		loginPageExt.login(phone1, authcode);
		WebDriverWaitUtils.waitUntilElementIsVisible(studyPageExt.getDynamicList());
		SeLionReporter.log("login successfully, at study page now", true);
	}

	@Test(priority = 3)
	public void testChangePhone() {
		bottomToolbarExt.gotoUserPage();
		userPageExt.gotoUserInforPage();
		userInforPageExt.gotoPhonePage();
		phonePageExt.changePhone(phone1, phone2, authcode);
		WebDriverWaitUtils.waitUntilElementIsVisible(userInforPageExt.getPhoneElement());
		SeLionReporter.log("change successfully, at user information page now", true);
	}

	@Test(priority = 4)
	public void testChangePhoneBack() {
		userInforPageExt.gotoPhonePage();
		phonePageExt.changePhone(phone2, phone1, authcode);
		WebDriverWaitUtils.waitUntilElementIsVisible(userInforPageExt.getPhoneElement());
		SeLionReporter.log("change successfully, at user information page now", true);
	}

	@Test(priority = 5)
	public void testChangeEmail() {
		userInforPageExt.gotoEmailPage();
		emailPageExt.changeEmail(email1, email2);
		WebDriverWaitUtils.waitUntilElementIsVisible(userInforPageExt.getEmailElement());
		SeLionReporter.log("change successfully, at user information page now", true);
	}

	@Test(priority = 6)
	public void testChangeEmailBack() {
		userInforPageExt.gotoEmailPage();
		emailPageExt.changeEmail(email2, email1);
		WebDriverWaitUtils.waitUntilElementIsVisible(userInforPageExt.getEmailElement());
		SeLionReporter.log("change successfully, at user information page now", true);
	}

	@Test(priority = 7)
	@MobileTest
	public void testNoticeConfirmGo() {
		NoticeUtil.sendMeetingNotice();
		userInforPageExt.back();
		bottomToolbarExt.gotoNoticePage();
		noticePageExt.tapFirstNotice();
		noticePageExt.tapNoticeDetailOneButton();
		WebDriverWaitUtils.waitUntilElementIsInvisible(noticePageExt.getNoticeDetailTwoElement());
		SeLionReporter.log("确认参会成功", true);
	}

	@Test(priority = 8)
	@MobileTest
	public void testNoticeConfirmNotGo() {
		NoticeUtil.sendMeetingNotice();
		noticePageExt.backToNoticeList();
		bottomToolbarExt.gotoUserPage();
		bottomToolbarExt.gotoNoticePage();
		noticePageExt.tapFirstNotice();
		noticePageExt.tapNoticeDetailTwoButton();
		WebDriverWaitUtils.waitUntilElementIsInvisible(noticePageExt.getNoticeDetailTwoElement());
		SeLionReporter.log("确认不参会成功", true);
	}

	private void init() {
		loginPageExt = new LoginPageExt();
		studyPageExt = new StudyPageExt();
		userPageExt = new UserPageExt();
		userInforPageExt = new UserInforPageExt();
		phonePageExt = new PhonePageExt();
		emailPageExt = new EmailPageExt();
		registerPageExt = new RegisterPageExt();
		noticePageExt = new NoticePageExt();
		bottomToolbarExt = new BottomToolbarExt();
	}

}
