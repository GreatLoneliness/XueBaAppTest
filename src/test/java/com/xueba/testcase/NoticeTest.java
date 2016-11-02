package com.xueba.testcase;

import org.testng.annotations.Test;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.xueba.util.NoticeUtil;
import com.zhijin.xueba.LoginPage;
import com.zhijin.xueba.NoticePage;
import com.zhijin.xueba.StudyPage;

/**
 * 通知测试
 * 
 * @author wliting
 *
 */
@Test(singleThreaded = true)
@MobileTest
public class NoticeTest {
	private String phone = "18910213610";
	private String authcode = "789456";

	private NoticePage noticePage;
	private LoginPage loginPage;
	private StudyPage studyPage;

	/**
	 * 初始化界面对象
	 */
	private void init() {
		loginPage = new LoginPage();
		studyPage = new StudyPage();
		noticePage = new NoticePage();
		NoticeUtil.sendMeetingNotice();// 发送两条通知
		NoticeUtil.sendMeetingNotice();
	}

	@Test(priority = 1)
	@MobileTest
	public void testNoticeConfirmGo() {
		init();
		login();
		studyPage.getNoticeButton().tap(noticePage.getNoticeOneLabel());// 点击主页通知按钮
		SeLionReporter.log("goto noticeList now", true);
		noticePage.getNoticeOneLabel().tap(noticePage.getNoticeDetailOneButton());// 点击通知列表第一项通知
		noticePage.getNoticeDetailOneButton().tap();// 点击确认参会按钮
		WebDriverWaitUtils.waitUntilElementIsInvisible(noticePage.getNoticeDetailTwoButton());// 等待直到界面只显示一个按钮
		SeLionReporter.log("notice confirm successfully", true);
		noticePage.getNoticeBackButton().tap(studyPage.getNoticeButton());// 返回到通知列表
	}

	@Test(priority = 2)
	@MobileTest
	public void testNoticeConfirmNotGo() {
		studyPage.getNoticeButton().tap(noticePage.getNoticeOneLabel());// 点击主页通知按钮
		SeLionReporter.log("goto noticeList now", true);
		noticePage.getNoticeOneLabel().tap(noticePage.getNoticeDetailOneButton());// 点击通知列表第一项通知
		noticePage.getNoticeDetailTwoButton().tap();// 点击不参会按钮
		WebDriverWaitUtils.waitUntilElementIsInvisible(noticePage.getNoticeDetailTwoButton());// 等待直到界面只显示一个按钮
		SeLionReporter.log("notice confirmNotGo successfully", true);
		noticePage.getNoticeBackButton().tap(studyPage.getNoticeButton());// 返回到通知列表
	}

	/**
	 * 登录
	 */
	private void login() {
		WebDriverWaitUtils.waitUntilElementIsVisible(loginPage.getPhoneTextField());
		loginPage.getPhoneTextField().setText(phone);
		loginPage.getAuthcodeTextField().setText(authcode);
		loginPage.getLoginButton().tap(studyPage.getNoticeButton());
		SeLionReporter.log("login successfully, goto homepage now", true);
	}

}
