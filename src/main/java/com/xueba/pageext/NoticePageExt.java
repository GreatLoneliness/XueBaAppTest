package com.xueba.pageext;

import com.paypal.selion.platform.mobile.elements.MobileTextField;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.zhijin.xueba.EmailPage;
import com.zhijin.xueba.NoticePage;

/**
 * 
 * @author wliting
 *
 */

public class NoticePageExt extends NoticePage {

	public void tapFirstNotice() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getNoticeOneLabel());
		getNoticeOneLabel().tap();// 点击通知列表第一项通知
	}

	public void tapNoticeDetailOneButton() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getNoticeDetailOneButton());
		getNoticeDetailOneButton().tap();// 点击通知详情第一个按钮
	}

	public void tapNoticeDetailTwoButton() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getNoticeDetailTwoButton());
		getNoticeDetailTwoButton().tap();// 点击通知详情第二个按钮
	}

	public void backToNoticeList() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getNoticeBackButton());
		getNoticeBackButton().tap();// 返回到通知列表
	}

	public void clearText(MobileTextField tx, String str) {
		for (int i = 0; i < str.length(); ++i) {
			tx.clearText();
		}
	}
}
