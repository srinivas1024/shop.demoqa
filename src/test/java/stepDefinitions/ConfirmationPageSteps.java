package stepDefinitions;

import java.util.List;

import org.junit.Assert;

import context.TestContext;
import cucumber.api.java.en.Then;
import enums.Context;
import pageObjects.ConfirmationPage;

public class ConfirmationPageSteps {
	
		 TestContext testContext;
		 ConfirmationPage confirmationPage;
		 
		 public ConfirmationPageSteps(TestContext context) {
		 testContext = context;
		 confirmationPage = testContext.getPageObjectManager().getConfirmationPage();
		 }
		 
		 /*To retrieve the value of the Product Name, just need to pass the Key to the getContext() method 
		  * which can be accessed like testContext.scenarioContext.getContext(Key Name).
		   But, the method returns any object, so we need to cast it to the right type. 
		   If we mistakenly cast it to wrong type, the test will fail here. 
		   So, we must sure for what object we stored for what key. Or even this can be handled with in the code, 
		   but let’s just avoid any complexity here for no*/
		 @Then("^verify the order details$")
		 public void verify_the_order_details(){
		 String productName = (String)testContext.scenarioContext.getContext(Context.PRODUCT_NAME);
		 List<String> productNames=confirmationPage.getProductNames();
		 for(String product:productNames)
		 {
			 if(product.equals(productName))
			 { Assert.assertTrue("Product names are matching", true); 
			   break;
			 }
		 }

}
}
