package com.xueba.pageext;

import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.zhijin.xueba.StudyPage;

/**
 * 
 * @author hxl
 *
 */

public class StudyPageExt extends StudyPage {

	public void gotoUserPage() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getUserElement());
		getUserElement().tap();
	}
}