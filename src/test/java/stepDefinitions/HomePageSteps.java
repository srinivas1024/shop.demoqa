package stepDefinitions;

import context.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.HomePage;

public class HomePageSteps {
	
	 TestContext testContext;
	 HomePage homePage;
	 
	 /*Using PicoContainer to share state between steps in a scenario is easy and non-intrusive. 
	  * All you need is a constructor that requires an object that PicoContainer can create and inject. 
	  * PicoContainer is invisible. 
	  * Add a dependency to cucumber-picocontainer and make sure that the constructors for the step classes require an instance of the same class.
	  */

 	
	 public HomePageSteps(TestContext context) {
		 testContext = context;
		 homePage = testContext.getPageObjectManager().getHomePage();
		 }
	 
	 @Given("^user is on Home Page$")
	 public void user_is_on_Home_Page(){
	 homePage.navigateTo_HomePage(); 
	 }
	 
	 @When("^he search for \"([^\"]*)\"$")
	 public void he_search_for(String product)  {
	 homePage.perform_Search(product);
	 }
	 
	}
