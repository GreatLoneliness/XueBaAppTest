package com.xueba.pageext;

import com.paypal.selion.platform.mobile.elements.MobileTextField;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.zhijin.xueba.PhonePage;

/**
 * 
 * @author hxl
 *
 */

public class PhonePageExt extends PhonePage {
	
	public void changePhone(String phone1, String phone2, String authcode) {
		WebDriverWaitUtils.waitUntilElementIsVisible(getPhoneTextField());
		SeLionReporter.log("at phone page now", true);
		clearText(getPhoneTextField(), phone1);
		getPhoneTextField().setText(phone2);
		getAuthcodeTextField().setText(authcode);
		getBindButton().tap();
	}
	
	public void clearText(MobileTextField tx, String str) {
		for (int i = 0; i < str.length(); ++i) {
			tx.clearText();
		}
	}
	
}
