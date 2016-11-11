package com.xueba.pageext;

import java.util.Set;

import org.openqa.selenium.WebElement;

import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.grid.SeLionAppiumIOSDriver;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.zhijin.xueba.NoticePage;

/**
 * 
 * @author wliting
 *
 */

public class NoticePageExt extends NoticePage {

	public void tapFirstNotice() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getNoticeOneLabel());
		getNoticeOneLabel().tap();// 点击通知列表第一项通知
	}

	public void tapNoticeDetailOneButton() {
		if (Grid.driver() instanceof SeLionAppiumIOSDriver) {
			WebElement element = Grid.driver().findElementByXPath(
					"//div[@class='weui_media_bd']//div[@ng-click='goMessageDetail(item)'][1]|确认参会");
			element.click();
		} else {
			WebDriverWaitUtils.waitUntilElementIsVisible(getNoticeDetailOneElement());
			getNoticeDetailOneElement().tap();// 点击通知详情第一个按钮
		}
	}

	public void tapNoticeDetailTwoButton() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getNoticeDetailTwoElement());
		getNoticeDetailTwoElement().tap();// 点击通知详情第二个按钮
	}

	public void backToNoticeList() {
		WebDriverWaitUtils.waitUntilElementIsVisible(getNoticeBackButton());
		getNoticeBackButton().tap();// 返回到通知列表
	}

}
