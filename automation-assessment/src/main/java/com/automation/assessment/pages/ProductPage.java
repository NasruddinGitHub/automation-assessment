package com.automation.assessment.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {
	private int timeout = 10;

	@FindBy(xpath = "//div[@class='row']/descendant::div[@class='product-details']/p")
	private WebElement productName;

	@FindBy(xpath = "//div[@class='row']/descendant::div[@class='product-details']/h1")
	private WebElement productDescription;

	@FindBy(xpath = "//div[@class='row']/descendant::div[@class='product-details']/child::div[@class='price']")
	private WebElement productPrice;

	@FindBy(xpath = "//div[@class='row']/descendant::div[@class='product-details']/child::div[@class='product-rrp']")
	private WebElement recommendedRetailPrice;

	@FindBy(xpath = "//div[@class='row']/descendant::div[@class='product-details']/child::div[@class='product-save-price u-font-bold u-colour-mu']")
	private WebElement productSaveprice;

	@FindBy(xpath = "//button[text()='Size guide']")
	private WebElement sizeGuide;

	@FindBy(xpath = "//form[@id='product']/descendant::div[@class='radio-container']")
	private List<WebElement> productSizes;

	@FindBy(xpath = "//div[@id='pdp-quantity_button']")
	private WebElement productQuantity;

	@FindBy(xpath = "//ul[@id='pdp-quantity_listbox']/child::li")
	private List<WebElement> productQuantityOptions;
	
	@FindBy(id = "addToCartButton")
	private WebElement addToBagButton;

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	public String getProductName() {
		return getText(productName, timeout);
	}

	public String getProductDescription() {
		return getText(productDescription, timeout);
	}

	public String getProductPrice() {
		return getText(productPrice, timeout);
	}

	public String getRecommendedRetailPrice() {
		return getText(recommendedRetailPrice, timeout);
	}

	public String getProductSaveprice() {
		return getText(productSaveprice, timeout);
	}

	public void clickSizeGuide() {
		click(sizeGuide, timeout);
	}

	public void selectProductSize(String size) {
		List<WebElement> allProductSizes = productSizes;
		for (WebElement productSize : allProductSizes) {
			if (productSize.getText().equalsIgnoreCase(size)) {
				click(productSize);
				break;
			}
		}
	}

	public void selectQuantity(String quantity) {
		click(productQuantity);
		for (WebElement productQuantityOption : productQuantityOptions) {
			if (productQuantityOption.getText().equalsIgnoreCase(quantity)) {
				click(productQuantityOption);
				break;
			}
		}
	}
	
	public void clickAddToBagButton() {
		click(addToBagButton, timeout);
	}
}
