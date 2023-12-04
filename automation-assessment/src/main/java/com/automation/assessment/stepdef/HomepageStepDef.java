package com.automation.assessment.stepdef;

import org.testng.Assert;

import com.automation.assessment.constants.Brand;
import com.automation.assessment.constants.ProductDetails;
import com.automation.assessment.datashare.ScenarioContext;
import com.automation.assessment.pages.BagPage;
import com.automation.assessment.pages.CheckoutPage;
import com.automation.assessment.pages.HomePage;
import com.automation.assessment.pages.ProductPage;
import com.automation.assessment.pages.SelectApparelPage;
import com.automation.assessment.pages.SizeGuidePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomepageStepDef {
	private HomePage homePage;
	private SelectApparelPage selectApparelPage;
	private ProductPage productPage;
	private ScenarioContext scenarioContext;
	private SizeGuidePage sizeGuidePage;
	private BagPage bagPage;
	private CheckoutPage checkoutPage;

	public HomepageStepDef(HomePage homePage, SelectApparelPage selectApparelPage, ProductPage productPage,
			ScenarioContext scenarioContext, SizeGuidePage sizeGuidePage, BagPage bagPage, CheckoutPage checkoutPage) {
		this.homePage = homePage;
		this.selectApparelPage = selectApparelPage;
		this.productPage = productPage;
		this.scenarioContext = scenarioContext;
		this.sizeGuidePage = sizeGuidePage;
		this.bagPage = bagPage;
		this.checkoutPage = checkoutPage;
	}

	@Given("I navigate to home page url")
	public void iNavigateToHomePageUrl() {
		homePage.navigateToHomePage();
	}

	@When("I checkout as guest without email id")
	public void iCheckoutAsGuestWithoutEmailId() {
		homePage.clickViewAllInWinterShopInMenDepartment();
		selectApparelPage.openCloseBrandOptions();
		selectApparelPage.selectBrand(Brand.POLICE_883);
		selectApparelPage.selectBrand(Brand.ADH);
		selectApparelPage.openCloseBrandOptions();
		selectApparelPage.clickFirstProductInTheGrid();
		scenarioContext.setContext(ProductDetails.PRODUCT_NAME, productPage.getProductName());
		scenarioContext.setContext(ProductDetails.PRODUCT_DESCRIPTION, productPage.getProductDescription());
		scenarioContext.setContext(ProductDetails.PRODUCT_PRICE, productPage.getProductPrice());
		scenarioContext.setContext(ProductDetails.RECOMMENDED_RETAIL_PRICE, productPage.getRecommendedRetailPrice());
		scenarioContext.setContext(ProductDetails.PRODUCT_SAVE_PRICE, productPage.getProductSaveprice());
		productPage.clickSizeGuide();
		productPage.switchToWindowUsingContainsUrl("size-guide");
		Assert.assertEquals(sizeGuidePage.getSizeGuideText(), "Size Guide");
		productPage.switchToWindowUsingContainsUrl("mens-winter-shop");
		scenarioContext.setContext(ProductDetails.PRODUCT_SIZE, "XL");
		scenarioContext.setContext(ProductDetails.PRODUCT_QUANTITY, "2");
		productPage.selectProductSize("XL");
		productPage.selectQuantity("2");
		productPage.clickAddToBagButton();
		Assert.assertEquals(bagPage.getProductName(), scenarioContext.getContext(ProductDetails.PRODUCT_NAME));
		Assert.assertEquals(bagPage.getProductDescription(),
				scenarioContext.getContext(ProductDetails.PRODUCT_DESCRIPTION));
		Assert.assertEquals(bagPage.getProductSize(), scenarioContext.getContext(ProductDetails.PRODUCT_SIZE));
		Assert.assertEquals(bagPage.getProductQuantity(), scenarioContext.getContext(ProductDetails.PRODUCT_QUANTITY));
		bagPage.clickCheckoutButton();
		checkoutPage.clickGuestCheckoutInNaviation();
		checkoutPage.clickGuestCheckoutButton();
	}

}
