package com.xueba.testcase;

import org.testng.annotations.Test;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.xueba.datagenerator.EmailGenerator;
import com.xueba.datagenerator.IDGenerator;
import com.xueba.datagenerator.PhoneGenerator;
import com.xueba.pageext.EmailPageExt;
import com.xueba.pageext.LoginPageExt;
import com.xueba.pageext.NoticePageExt;
import com.xueba.pageext.PhonePageExt;
import com.xueba.pageext.RegisterPageExt;
import com.xueba.pageext.StudyPageExt;
import com.xueba.pageext.UserInforPageExt;
import com.xueba.pageext.UserPageExt;
import com.xueba.util.NoticeUtil;

public class AllPageTest {
	private RegisterPageExt registerPageExt;
	private LoginPageExt loginPageExt;
	private StudyPageExt studyPageExt;
	private UserPageExt userPageExt;
	private UserInforPageExt userInforPageExt;
	private PhonePageExt phonePageExt;
	private EmailPageExt emailPageExt;
	private NoticePageExt noticePageExt;

	private String phone = PhoneGenerator.getPhone();
	private String id = IDGenerator.getID();
	private String email = EmailGenerator.getEmail(6, 9);
	private String phone1 = "18910213610";
	private String phoneEdit = "18910222222";
	private String emailEdit = "ting3jinjin@gmail.com";
	private static String authcode = "789456";

	private void init() {
		registerPageExt = new RegisterPageExt();
		loginPageExt = new LoginPageExt();
		studyPageExt = new StudyPageExt();
		userPageExt = new UserPageExt();
		userInforPageExt = new UserInforPageExt();
		phonePageExt = new PhonePageExt();
		emailPageExt = new EmailPageExt();
		noticePageExt = new NoticePageExt();
	}

	@Test
	@MobileTest
	public void testAll() {
		init();
		testRegister();
		testChangeEmail();
		testChangePhone();
		testLogin();
		testNoticeConfirmGo();
		testNoticeConfirmNotGo();
	}

	public void testRegister() {
		loginPageExt.gotoRegisterPage();
		registerPageExt.register(phone, authcode, id, email);
		WebDriverWaitUtils.waitUntilElementIsVisible(studyPageExt.getDynamicList());
		SeLionReporter.log("register successfully, goto study page now", true);
	}

	public void testChangeEmail() {
		studyPageExt.gotoUserPage();
		userPageExt.gotoUserInforPage();
		userInforPageExt.gotoEmailPage();
		emailPageExt.changeEmail(email, emailEdit);
		WebDriverWaitUtils.waitUntilElementIsVisible(userInforPageExt.getEmailElement());
		SeLionReporter.log("change successfully, goto user information page now", true);
	}

	public void testChangePhone() {
		userInforPageExt.gotoPhonePage();
		phonePageExt.changePhone(phone, phoneEdit, authcode);
		WebDriverWaitUtils.waitUntilElementIsVisible(userInforPageExt.getPhoneElement());
		SeLionReporter.log("change successfully, goto user information page now", true);
		userInforPageExt.back();
		userPageExt.logout();
		WebDriverWaitUtils.waitUntilElementIsVisible(loginPageExt.getLoginButton());
		SeLionReporter.log("用户退出登录", true);
	}

	public void testLogin() {
		loginPageExt.login(phone1, authcode);
		WebDriverWaitUtils.waitUntilElementIsVisible(studyPageExt.getNoticeButton());
		SeLionReporter.log("login successfully, goto study page now", true);
	}

	public void testNoticeConfirmGo() {
		NoticeUtil.sendMeetingNotice();
		studyPageExt.gotoNoticePage();
		noticePageExt.tapFirstNotice();
		noticePageExt.tapNoticeDetailOneButton();
		WebDriverWaitUtils.waitUntilElementIsInvisible(noticePageExt.getNoticeDetailTwoButton());
		SeLionReporter.log("确认参会成功", true);
		NoticeUtil.sendMeetingNotice();
		noticePageExt.backToNoticeList();
	}

	public void testNoticeConfirmNotGo() {
		studyPageExt.gotoNoticePage();
		noticePageExt.tapFirstNotice();
		noticePageExt.tapNoticeDetailTwoButton();
		WebDriverWaitUtils.waitUntilElementIsInvisible(noticePageExt.getNoticeDetailTwoButton());
		SeLionReporter.log("确认不参会成功", true);
		noticePageExt.backToNoticeList();
	}

}
