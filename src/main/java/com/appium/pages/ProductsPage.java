package com.appium.pages;

import org.openqa.selenium.By;

import com.appium.manager.GlobalParams;
import com.appium.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProductsPage extends MenuPage {
	TestUtils utils = new TestUtils();
	
	@AndroidFindBy (xpath = "//android.widget.ScrollView[@content-desc=\"test-PRODUCTS\"]/preceding-sibling::android.view.ViewGroup/android.widget.TextView") 
	@iOSXCUITFindBy (xpath ="//XCUIElementTypeOther[@name=\"test-Toggle\"]/parent::*[1]/preceding-sibling::*[1]")
	private MobileElement titleTxt;

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"test-PRODUCTS\"]/XCUIElementTypeScrollView")
	private MobileElement iOSSCrollView;

	public String getTitle() {
		return getText(titleTxt, "product page title is - ");
	}

	public String getProductTitle(String title) throws Exception {
		switch(new GlobalParams().getPlatformName()){
			case "Android":
				return getText(andScrollToElementUsingUiScrollable("text", title), "product title is: " + title);
			case "iOS":
				return getText(iOSScrollToElementUsingMobileScrollParent(iOSSCrollView, "label == '"+ title +"'"),
						"product title is: " + title);
			default:
				throw new Exception("Invalid platform name");
		}
	}

	public By defProductPrice(String title) throws Exception {
		switch(new GlobalParams().getPlatformName()){
			case "Android":
				return By.xpath("//*[@text=\"" + title + "\"]/following-sibling::*[@content-desc=\"test-Price\"]");
			case "iOS":
				return By.xpath("//XCUIElementTypeOther[@name=\"" + title + "\"]/following-sibling::*[1]/child::XCUIElementTypeStaticText[@name=\"test-Price\"]");
			default:
				throw new Exception("Invalid platform name");
		}
	}

	public String getProductPrice(String title, String price) throws Exception {
		return getText(scrollToElement(defProductPrice(title), "up"), "product price is: " + price);
	}

	public ProductDetailsPage pressProductTitle(String title) throws Exception  {
		switch(new GlobalParams().getPlatformName()){
			case "Android":
				click(andScrollToElementUsingUiScrollable("text", title), "press " + title + " link");
				return new ProductDetailsPage();
			case "iOS":
				click(iOSScrollToElementUsingMobileScrollParent(iOSSCrollView, "label == '"+ title +"'"), "press " + title + " link");
				return new ProductDetailsPage();
			default:
				throw new Exception("Invalid platform name");
		}
	}
}
