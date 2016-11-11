package com.xueba.pageext;

import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.grid.SeLionAppiumIOSDriver;
import com.paypal.selion.platform.mobile.elements.MobileTextField;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.zhijin.xueba.EmailPage;

/**
 * 
 * @author hxl
 *
 */

public class EmailPageExt extends EmailPage {

	public void changeEmail(String email1, String email2) {
		WebDriverWaitUtils.waitUntilElementIsVisible(getEmailTextField());
		SeLionReporter.log("at email page now", true);
		clearText(getEmailTextField(), email1);
		getEmailTextField().setText(email2);
		if (Grid.driver() instanceof SeLionAppiumIOSDriver) {
			getHideKeyBoardButton().tap();
		}
		getBindButton().tap();
	}

	public void clearText(MobileTextField tx, String str) {
		if (Grid.driver() instanceof SeLionAppiumIOSDriver) {
			tx.clearText();
		} else {
			for (int i = 0; i < str.length(); ++i) {
				tx.clearText();
			}
		}
	}
}
