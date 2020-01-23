package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testDataTypes.Customer;


public class CheckoutPage {
	JavascriptExecutor je;

	public CheckoutPage(WebDriver driver) {
	     PageFactory.initElements(driver, this);
	     je = (JavascriptExecutor) driver;
	 }
	
	
	@FindBy(how = How.CSS, using = "#billing_first_name") 
	private WebElement txtbx_FirstName;
	
	@FindBy(how = How.CSS, using = "#billing_last_name") 
	private WebElement txtbx_LastName;
	
	@FindBy(how = How.CSS, using = "#billing_email") 
	private WebElement txtbx_Email;
	
	@FindBy(how = How.CSS, using = "#billing_phone") 
	private WebElement txtbx_Phone;
	
	@FindBy(how = How.CSS, using = "#billing_country_field .select2-selection__arrow") 
	private WebElement drpdwn_CountryDropDownArrow;
	
	@FindBy(how = How.CSS, using = "#billing_state_field .select2-selection__arrow") 
	private WebElement drpdwn_CountyDropDownArrow;
	
	@FindAll(@FindBy(how = How.XPATH, using = "//li[@class='select2-results__option']"))
	private List<WebElement> country_List;	
	
	@FindBy(how = How.CSS, using = "#billing_city") 
	private WebElement txtbx_City;
	
	@FindBy(how = How.CSS, using = "#billing_address_1") 
	private WebElement txtbx_Address;
	
	@FindBy(how = How.CSS, using = "#billing_postcode") 
	private WebElement txtbx_PostCode;
	
		
	@FindBy(how = How.CSS, using = "#terms.input-checkbox") 
	private WebElement chkbx_AcceptTermsAndCondition;
	
	@FindBy(how = How.CSS, using = "#place_order") 
	private WebElement btn_PlaceOrder;
	
	
	public void enter_Name(String name) {
		txtbx_FirstName.sendKeys(name);
	}
	
	public void enter_LastName(String lastName) {
		txtbx_LastName.sendKeys(lastName);
	}

	public void enter_Email(String email) {
		txtbx_Email.sendKeys(email);
	}
	
	public void enter_Phone(String phone) {
		txtbx_Phone.sendKeys(phone);
	}
	
	public void enter_Address(String address) {
		txtbx_Address.sendKeys(address);
	}
	
	public void enter_City(String city) {
		txtbx_City.sendKeys(city);
	}
	
	public void enter_PostCode(String postCode) {
		txtbx_PostCode.sendKeys(postCode);
	}
	
		
	public void select_Country(String countryName) {
		
		//je.executeScript("arguments[0].scrollIntoView(true);",drpdwn_CountryDropDownArrow);
		je.executeScript("scroll(250, 0)");
		drpdwn_CountryDropDownArrow.click();
		for(WebElement country : country_List){
			if(country.getText().equals(countryName)) {
				country.click();	
				try { Thread.sleep(1000);}
				catch (InterruptedException e) {}
				break;
			}
		}
	}
	
	public void select_County(String countyName) {
		drpdwn_CountyDropDownArrow.click();
		for(WebElement county : country_List){
			if(county.getText().equals(countyName)) {
				county.click();	
				try { Thread.sleep(1000);}
				catch (InterruptedException e) {}
				break;
			}
		}
	}
	
	public void check_TermsAndCondition(boolean value) {
		if(value) chkbx_AcceptTermsAndCondition.click();
	}
	
	public void clickOn_PlaceOrder() {
		btn_PlaceOrder.submit();
		
		
	}
	
	
	/*public void fill_PersonalDetails() {
		enter_Name("Aotomation");
		 enter_LastName("Test");
		 enter_Phone("0000000000");
		 enter_Email("Automation@gmail.com");		 
		 enter_City("Delhi");
		 enter_Address("Shalimar Bagh");
		 enter_PostCode("110088");
		 select_Country("India");
		 select_County("Delhi");
		
	}*/
	
	public void fill_PersonalDetails(Customer customer) {
		 enter_Name(customer.firstName);
		 enter_LastName(customer.lastName);
		 enter_Phone(customer.phoneNumber.mob);
		 enter_Email(customer.emailAddress);
		 enter_City(customer.address.city);
		 enter_Address(customer.address.streetAddress);
		 enter_PostCode(customer.address.postCode);
		 select_Country(customer.address.country);
		 select_County(customer.address.county); 
		 }

}
	 


