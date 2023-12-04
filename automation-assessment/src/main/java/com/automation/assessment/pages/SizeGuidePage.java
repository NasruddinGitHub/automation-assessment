package com.automation.assessment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SizeGuidePage extends BasePage {
	private int timeout = 10;

	@FindBy(xpath = "//h1[text()='Size Guide']")
	private WebElement sizeGuideText;

	public SizeGuidePage() {
		PageFactory.initElements(driver, this);
	}

	public String getSizeGuideText() {
		return getText(sizeGuideText, timeout);
	}

}
