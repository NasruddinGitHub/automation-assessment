package com.automation.assessment.stepdef;

import org.testng.Assert;

import com.automation.assessment.pages.CheckoutPage;

import io.cucumber.java.en.Then;

public class CheckoutpageStepdef {
	private CheckoutPage checkoutPage;

	public CheckoutpageStepdef(CheckoutPage checkoutPage) {
		this.checkoutPage = checkoutPage;
	}

	@Then("I should see mandatory email address error message")
	public void iShouldSeemandatoryEmailAddressErrorMessage() {
		Assert.assertEquals(checkoutPage.getMandatoryEmailAddressErrorMessage(), "Please enter an email address");
	}
}
