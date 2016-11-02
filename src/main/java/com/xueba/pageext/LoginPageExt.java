package com.xueba.pageext;

import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.zhijin.xueba.LoginPage;

/**
 * 
 * @author hxl
 *
 */

public class LoginPageExt extends LoginPage {
	
	public void login(String phone, String authcode) {
		WebDriverWaitUtils.waitUntilElementIsVisible(getPhoneTextField());
		getPhoneTextField().setText(phone);
		getAuthcodeTextField().setText(authcode);
		getLoginButton().tap();
	}

	public void gotoRegisterPage() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getRegisterButton());
		getRegisterButton().tap();
	}

}
