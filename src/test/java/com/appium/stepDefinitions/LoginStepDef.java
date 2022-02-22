package com.appium.stepDefinitions;

import org.testng.Assert;

import com.appium.pages.LoginPage;
import com.appium.pages.ProductsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {

	@When("I enter username as {string}")
	public void iEnterUsernameAs(String username) {
		new LoginPage().enterUserName(username);
	}

	@When("I enter password as {string}")
	public void iEnterPasswordAs(String password) {
		new LoginPage().enterPassword(password);
	}

	@When("I login")
	public void iLogin() {
		new LoginPage().pressLoginBtn();
	}

	/* @Then -> Assertions should be done here */
	@Then("login should fail with an error {string}")
	public void loginShouldFailWithAnError(String expectedError) {
		Assert.assertEquals(new LoginPage().getErrTxt(), expectedError);
	}

	@Then("I should see Products page with title {string}")
	public void iShouldSeeProductsPageWithTitle(String expectedTitle) {
		Assert.assertEquals(new ProductsPage().getTitle(), expectedTitle);
	}

}
