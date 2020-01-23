package stepDefinitions;

import context.TestContext;
import cucumber.api.java.en.When;
import enums.Context;
import pageObjects.ProductListingPage;

public class ProductPageSteps {

	TestContext testContext;
	 ProductListingPage productListingPage;
	 
	 public ProductPageSteps(TestContext context) {
	 testContext = context;
	 productListingPage = testContext.getPageObjectManager().getProductListingPage();
	 }
	 
	 @When("^choose to buy the first item1$")
	 public void choose_to_buy_the_first_item1() throws Throwable {
		 /*using the getProductName() method in the ProductListingPage class, 
		  * get the name and save it into the scenarioContext object in ProductPageSteps class
		  */
		 String productName = productListingPage.getProductName(0); 
		 testContext.scenarioContext.setContext(Context.PRODUCT_NAME, productName);
	     productListingPage.select_Product(0);
	     productListingPage.clickOn_AddToCart(); 
	 }
}
