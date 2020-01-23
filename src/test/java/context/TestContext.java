package context;

import managers.PageObjectManager;
import managers.WebDriverManager;

public class TestContext {

	private WebDriverManager webDriverManager;
	 private PageObjectManager pageObjectManager;
	 public ScenarioContext scenarioContext;
	 
	 public TestContext(){
	 webDriverManager = new WebDriverManager();
	 pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	 scenarioContext = new ScenarioContext();
	 }
	 
	 public WebDriverManager getWebDriverManager() {
	 return webDriverManager;
	 }
	 
	 public PageObjectManager getPageObjectManager() {
	 return pageObjectManager;
	 }
	 
	 /*Include ScenarioContext in TextContext, so that it can be shared across all the Cucumber Steps using Pico-Container library. 
	  * Also, to make sure to add a getter method as getScenarioContext() to get the scenarioContext object.
	  */
	 public ScenarioContext getScenarioContext() {
		 return scenarioContext;
		 }
}
