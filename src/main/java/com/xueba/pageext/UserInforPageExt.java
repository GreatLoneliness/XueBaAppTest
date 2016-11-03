package com.xueba.pageext;

import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.zhijin.xueba.UserInforPage;

/**
 * 
 * @author hxl
 *
 */

public class UserInforPageExt extends UserInforPage {

	public void gotoPhonePage() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getPhoneElement());
		SeLionReporter.log("at user information page now", true);
		getPhoneElement().tap();
	}
	
	public void gotoEmailPage() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getEmailElement());
		SeLionReporter.log("at user information page now", true);
		getEmailElement().tap();
	}
	
	public void back() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getBackElement());
		SeLionReporter.log("at user information page now", true);
		getBackElement().tap();
	}
	
}
