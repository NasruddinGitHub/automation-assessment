package com.automation.assessment.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BagPage extends BasePage {
	private int timeout = 10;

	@FindBy(xpath = "//a[@class='name brand']")
	private WebElement productName;

	@FindBy(xpath = "//a[@class='name']")
	private WebElement productDescription;

	@FindBy(xpath = "//button[text()='Size guide']")
	private WebElement sizeGuide;

	@FindBy(xpath = "//div[@class='size']")
	private WebElement productSize;

	@FindBy(xpath = "//div[@class='qty']")
	private WebElement productQuantity;

	@FindBy(xpath = "//span[text()='Checkout']")
	private WebElement checkoutButton;

	public BagPage() {
		PageFactory.initElements(driver, this);
	}

	public String getProductName() {
		return getText(productName, timeout);
	}

	public String getProductDescription() {
		return getText(productDescription, timeout);
	}

	public String getProductSize() {
		return getText(productSize, timeout).split(":")[1].trim();
	}

	public String getProductQuantity() {
		return getText(productQuantity, timeout).split("x")[1].trim();
	}

	public void clickCheckoutButton() {
		click(checkoutButton, timeout);
	}

}
