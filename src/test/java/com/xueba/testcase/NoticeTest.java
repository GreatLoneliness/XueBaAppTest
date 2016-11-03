package com.xueba.testcase;

import org.testng.annotations.Test;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.xueba.pageext.BottomToolbarExt;
import com.xueba.pageext.LoginPageExt;
import com.xueba.pageext.NoticePageExt;
import com.xueba.pageext.StudyPageExt;
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

	private NoticePageExt noticePageExt;
	private LoginPageExt loginPageExt;
	private BottomToolbarExt bottomToolbarExt;

	/**
	 * 初始化界面对象
	 */
	private void init() {
		noticePageExt = new NoticePageExt();
		loginPageExt = new LoginPageExt();
		bottomToolbarExt = new BottomToolbarExt();
		NoticeUtil.sendMeetingNotice();// 发送两条通知
		NoticeUtil.sendMeetingNotice();
	}

	@Test(priority = 1)
	@MobileTest
	public void testNoticeConfirmGo() {
		init();
		loginPageExt.login(phone, authcode);
		bottomToolbarExt.gotoNoticePage();
		noticePageExt.tapFirstNotice();
		noticePageExt.tapNoticeDetailOneButton();
		noticePageExt.backToNoticeList();
	}

	@Test(priority = 2)
	@MobileTest
	public void testNoticeConfirmNotGo() {
		bottomToolbarExt.gotoNoticePage();
		noticePageExt.tapFirstNotice();
		noticePageExt.tapNoticeDetailTwoButton();
		noticePageExt.backToNoticeList();
	}

}
