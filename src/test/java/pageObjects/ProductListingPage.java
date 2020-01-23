package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductListingPage {
	
	public ProductListingPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
		 }
		 
		 @FindBy(how = How.CSS, using = "button.single_add_to_cart_button") 
		 private WebElement btn_AddToCart;
		 
		 @FindAll(@FindBy(how = How.CSS, using = ".noo-product-inner"))
		 private List<WebElement> prd_List; 
		 
		 @FindBy(how = How.ID, using = "pa_color") 
		 private WebElement color;
		 
		 @FindBy(how = How.ID, using = "pa_size") 
		 private WebElement size;
		 
		 
	  public void select_Product(int productNumber) {
		 prd_List.get(productNumber).click();
		 }
	  
	  public String getProductName(int productNumber) {
		  return prd_List.get(productNumber).findElement(By.cssSelector("h3")).getText();
		  }
		  
	  
	  public void clickOn_AddToCart() throws InterruptedException {
		    Select s = new Select(color);
			s.selectByValue("white");
			
			Select s1 = new Select(size);
			s1.selectByValue("medium");
			
			//add to cart
			btn_AddToCart.click();
			Thread.sleep(1000);
	 }

}
