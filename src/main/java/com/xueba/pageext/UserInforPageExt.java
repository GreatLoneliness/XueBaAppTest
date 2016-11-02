package com.xueba.pageext;

import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.zhijin.xueba.UserInforPage;

/**
 * 
 * @author hxl
 *
 */

public class UserInforPageExt extends UserInforPage {

	public void gotoPhonePage() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getPhoneElement());
		getPhoneElement().tap();
	}
	
	public void gotoEmailPage() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getEmailElement());
		getEmailElement().tap();
	}
	
	public void back() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getBackElement());
		getBackElement().tap();
	}
	
}
