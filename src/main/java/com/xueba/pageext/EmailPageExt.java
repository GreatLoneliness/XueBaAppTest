package com.xueba.pageext;

import com.paypal.selion.platform.mobile.elements.MobileTextField;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.zhijin.xueba.EmailPage;

/**
 * 
 * @author hxl
 *
 */

public class EmailPageExt extends EmailPage {

	public void changeEmail(String email1, String email2) {
		WebDriverWaitUtils.waitUntilElementIsVisible(getEmailTextField());
		clearText(getEmailTextField(), email1);
		getEmailTextField().setText(email2);
		getBindButton().tap();
	}
	
	public void clearText(MobileTextField tx, String str) {
		for (int i = 0; i < str.length(); ++i) {
			tx.clearText();
		}
	}
}
