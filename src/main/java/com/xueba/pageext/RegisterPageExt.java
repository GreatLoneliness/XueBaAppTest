package com.xueba.pageext;

import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.grid.SeLionAppiumIOSDriver;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.zhijin.xueba.RegisterPage;

/**
 * 
 * @author hxl
 *
 */

public class RegisterPageExt extends RegisterPage {
	
	public void register(String phone, String authcode, String id, String mail) {
		WebDriverWaitUtils.waitUntilElementIsVisible(getPhoneTextField());
		SeLionReporter.log("at register page now", true);
		getAuthcodeTextField().setText(authcode);
		getPhoneTextField().setText(phone);
		getIdTextField().setText(id);
		getMailTextField().setText(mail);
		if (Grid.driver() instanceof SeLionAppiumIOSDriver) {
			getHideKeyBoardButton().tap();
		}
		getRegisterButton().tap();
	}
	
}
