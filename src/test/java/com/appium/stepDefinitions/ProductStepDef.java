package com.appium.stepDefinitions;

import org.testng.Assert;

import com.appium.pages.LoginPage;
import com.appium.pages.ProductDetailsPage;
import com.appium.pages.ProductsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStepDef {

	@Given("I'm logged in")
	public void iMLoggedIn() {
		new LoginPage().login("standard_user", "secret_sauce");
	}

	@Then("the product is listed with title {string} and price {string}")
	public void theProductIsListedWithTitleAndPrice(String expectedTitle, String expectedPrice) throws Exception {
		Boolean titleCheck = new ProductsPage().getProductTitle(expectedTitle).equalsIgnoreCase(expectedTitle);
		Boolean priceCheck = new ProductsPage().getProductPrice(expectedTitle, expectedPrice)
				.equalsIgnoreCase(expectedPrice);
		// Assert.assertTrue("titleCheck = " + titleCheck + ", priceCheck = " +
		// priceCheck, titleCheck & priceCheck);

		/* Rajat */
		Assert.assertTrue(titleCheck, "Product Title Check");
		Assert.assertTrue(priceCheck, "Product priceCheck Check");
	}

	@When("I click product title {string}")
	public void iClickProductTitle(String title) throws Exception {
		new ProductsPage().pressProductTitle(title);
	}

	@Then("I should be on product details page with title {string}, price {string} and description {string}")
	public void iShouldBeOnProductDetailsPageWithTitlePriceAndDescription(String expectedTitle, String expectedPrice,
			String expectedDescription) throws Exception {
		ProductDetailsPage productDetailsPage = new ProductDetailsPage();
		boolean titleCheck = productDetailsPage.getTitle().equalsIgnoreCase(expectedTitle);
		boolean descCheck = productDetailsPage.getDesc().equalsIgnoreCase(expectedDescription);
		boolean priceCheck = productDetailsPage.getPrice().equalsIgnoreCase(expectedPrice);
//		Assert.assertTrue("titleCheck = " + titleCheck + ", descCheck = " + descCheck + ", priceCheck = " + priceCheck,
//				titleCheck & descCheck & priceCheck);

		/* Rajat */
		Assert.assertTrue(titleCheck, "Product Title Check");
		Assert.assertTrue(priceCheck, "Product priceCheck Check");
		Assert.assertTrue(descCheck, "Product descCheck Check");

	}

}
