package com.appium.pages;

import com.appium.manager.GlobalParams;
import com.appium.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProductDetailsPage extends MenuPage {
	TestUtils utils = new TestUtils();
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]\n" + 
			"") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"test-Description\"]/child::XCUIElementTypeStaticText[1]")
	private MobileElement title;
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[2]"
			+ "") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"test-Description\"]/child::XCUIElementTypeStaticText[2]")
	private MobileElement desc;

	@AndroidFindBy (accessibility = "test-BACK TO PRODUCTS") 
	@iOSXCUITFindBy (id = "test-BACK TO PRODUCTS")
	private MobileElement backToProductsBtn;

	@iOSXCUITFindBy (id = "test-Price")
	private MobileElement iOSProductPrice;

	@iOSXCUITFindBy (id = "test-ADD TO CART") private MobileElement addToCartBtn;

public String getTitle() {
	return getText(title, "title is: ");
}

public String getDesc() {
	return getText(desc, "description is: ");
}

public String getPrice() throws Exception {
	switch(new GlobalParams().getPlatformName()){
		case "Android":
			return getText(andScrollToElementUsingUiScrollable("description", "test-Price"), "price is: ");
		case "iOS":
			return getText(iOSScrollToElementUsingMobileScroll(iOSProductPrice), "price is: ");
		default:
			throw new Exception("Invalid platform name");
	}
}

public Boolean isAddToCartBtnDisplayed() {
	return addToCartBtn.isDisplayed();
}

public ProductsPage pressBackToProductsBtn() {
	click(backToProductsBtn, "navigate back to products page");
	return new ProductsPage();
}

}
