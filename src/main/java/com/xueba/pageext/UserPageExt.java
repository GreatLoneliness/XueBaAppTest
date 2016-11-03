package com.xueba.pageext;

import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.zhijin.xueba.UserPage;

/**
 * 
 * @author hxl
 *
 */

public class UserPageExt extends UserPage {

	public void gotoUserInforPage() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getUserInforElement());
		SeLionReporter.log("at user page now", true);
		getUserInforElement().tap();
	}
	
	public void logout() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getLogoutButton());
		SeLionReporter.log("at user page now", true);
		getLogoutButton().tap();
	}
}
