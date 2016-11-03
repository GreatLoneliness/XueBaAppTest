package com.xueba.pageext;

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
		getPhoneTextField().setText(phone);
		getAuthcodeTextField().setText(authcode);
		getIdTextField().setText(id);
		getMailTextField().setText(mail);
		getRegisterButton().tap();
	}
	
}
