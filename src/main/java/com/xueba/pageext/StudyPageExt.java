package com.xueba.pageext;

import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.zhijin.xueba.StudyPage;

/**
 * 
 * @author hxl
 *
 */

public class StudyPageExt extends StudyPage {

	public void gotoNoticePage() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getNoticeButton());
		getNoticeButton().tap();
	}

	public void gotoUserPage() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getUserElement());
		SeLionReporter.log("at study page now", true);
		getUserElement().tap();
	}
}
