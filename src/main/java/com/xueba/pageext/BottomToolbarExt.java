package com.xueba.pageext;

import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.zhijin.xueba.BottomToolbar;

/**
 * 
 * @author hxl
 *
 */

public class BottomToolbarExt extends BottomToolbar {
	
	public void gotoUserPage() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getUserElement());
		SeLionReporter.log("at study page now", true);
		getUserElement().tap();
	}
	
	public void gotoNoticePage() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getNoticeElement());
		getNoticeElement().tap();;
	}
}
