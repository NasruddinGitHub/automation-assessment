package com.automation.assessment.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.assessment.constants.Brand;

public class SelectApparelPage extends BasePage {
	private int timeout = 10;
	@FindBy(xpath = "//button[@title='Brand']")
	private WebElement brandTitle;

	@FindBy(xpath = "//button[@title='Brand']/parent::li[@class='c-refine__item']/child::div[@role='listbox']/descendant::div[@class='c-refine__options-item']")
	private List<WebElement> allBrands;

	@FindBy(xpath = "//ul[@class='c-product-grid']/li")
	private WebElement firstProductInTheGrid;

	public SelectApparelPage() {
		PageFactory.initElements(driver, this);
	}

	public void openCloseBrandOptions() {
		click(brandTitle, timeout);
	}

	public void selectBrand(Brand brand) {
		List<WebElement> brands = allBrands;
		for (WebElement brandToSelect : brands) {
			if (brandToSelect.getText().equalsIgnoreCase(brand.getBrandValue())) {
				click(brandToSelect);
				break;
			}
		}
	}

	public void clickFirstProductInTheGrid() {
		click(firstProductInTheGrid, timeout);
	}
}
