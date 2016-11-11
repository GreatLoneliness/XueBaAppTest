package com.xueba.pageext;

import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.grid.SeLionAppiumIOSDriver;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.zhijin.xueba.LoginPage;

/**
 * 
 * @author hxl
 *
 */

public class LoginPageExt extends LoginPage {

	public void login(String phone, String authcode) {
		WebDriverWaitUtils.waitUntilElementIsVisible(getPhoneTextField());
		SeLionReporter.log("at login page now", true);
		getPhoneTextField().setText(phone);
		getAuthcodeTextField().setText(authcode);
		if (Grid.driver() instanceof SeLionAppiumIOSDriver) {
			getHideKeyBoardButton().tap();
		}
		getLoginButton().tap();

	}

	public void gotoRegisterPage() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getRegisterButton());
		SeLionReporter.log("at login page now", true);
		getRegisterButton().tap();
	}

}
