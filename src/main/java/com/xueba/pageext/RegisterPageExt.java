package com.xueba.pageext;

import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.zhijin.xueba.RegisterPage;

/**
 * 
 * @author hxl
 *
 */

public class RegisterPageExt extends RegisterPage {
	
	public void register(String phone, String authcode, String id, String mail) {
		WebDriverWaitUtils.waitUntilElementIsVisible(getPhoneTextField());
		getPhoneTextField().setText(phone);
		getAuthcodeTextField().setText(authcode);
		getIdTextField().setText(id);
		getMailTextField().setText(mail);
		getRegisterButton().tap();
	}
	
}
