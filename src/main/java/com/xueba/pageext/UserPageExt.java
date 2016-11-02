package com.xueba.pageext;

import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.zhijin.xueba.UserPage;

/**
 * 
 * @author hxl
 *
 */

public class UserPageExt extends UserPage {

	public void gotoUserInforPage() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getUserInforElement());
		getUserInforElement().tap();
	}
	
	public void logout() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getLogoutButton());
		getLogoutButton().tap();
	}
}
