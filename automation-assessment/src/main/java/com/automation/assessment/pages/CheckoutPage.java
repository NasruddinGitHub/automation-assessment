package com.automation.assessment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {
	private int timeout = 10;

	@FindBy(xpath = "//a[@aria-controls='loginAsGuest']")
	private WebElement checkoutAsGuestNaviationTab;

	@FindBy(id = "checkoutLoginSubmit")
	private WebElement checkoutAsGuestButton;
	
	@FindBy(id="j_username.errors")
	private WebElement mandatoryEmailAddressError;

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickGuestCheckoutInNaviation() {
		click(checkoutAsGuestNaviationTab, timeout);
	}

	public void clickGuestCheckoutButton() {
		click(checkoutAsGuestButton, timeout);
	}
	
	public String getMandatoryEmailAddressErrorMessage() {
		return getText(mandatoryEmailAddressError, timeout);
	}

}
