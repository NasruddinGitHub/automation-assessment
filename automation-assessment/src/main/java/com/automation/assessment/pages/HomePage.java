package com.automation.assessment.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.assessment.constants.Browser;
import com.automation.assessment.hooks.ApplicationHooks;

public class HomePage extends BasePage {
	private ApplicationHooks appHooks;
	private Properties properties;
	private int timeout = 10;

	@FindBy(xpath = "//nav[@id='facetScroll']/descendant::li[@data-categoryparent='Departments']/child::a[@title='Men']")
	private WebElement menDepartment;

	@FindBy(xpath = "//div[@id='MenCategoryLink']/descendant::button[text()='Winter Shop']")
	private WebElement winterShopInMenDepartment;

	@FindBy(xpath = "//div[@id='MenCategoryLink']/parent::div[@class='container']/child::div[@class='level-2-navigation-container']/descendant::li[@data-categoryparent='Winter Shop']/child::a[text()='View All']")
	private WebElement viewAllInWinterShopInMenDepartment;

	@FindBy(xpath = "//a[contains(@copy,'American Designer Pop-Up')]")
	private WebElement countDownBanner;

	public HomePage(ApplicationHooks appHooks, Properties properties) {
		this.appHooks = appHooks;
		this.properties = appHooks.getProperties();
		PageFactory.initElements(driver, this);
	}

	public void navigateToHomePage() {
		navigateToUrl(properties.getProperty("url"));
		waitUntilElementIsVisible(countDownBanner, timeout);
	}

	public void clickViewAllInWinterShopInMenDepartment() {
		Actions actions = new Actions(driver);
		actions.moveToElement(menDepartment).pause(Duration.ofSeconds(2));
		actions.moveToElement(winterShopInMenDepartment).pause(Duration.ofSeconds(2));
		actions.click(viewAllInWinterShopInMenDepartment).build().perform();
	}

}
