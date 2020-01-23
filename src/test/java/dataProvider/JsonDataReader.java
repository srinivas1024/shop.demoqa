package dataProvider;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
//import com.google.gson.Gson;
import gherkin.deps.com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.Customer;

/*As of now there is just one JSON data file for Customer, but later there can be many other files like Product, Payment etc.
This class may have a method which can return a whole list of Customer data like getAllCustomers() and 
later you filter the data as per your requirement. Or you can make it bit restrict and expose different methods to access data 
like getCustomerByName or getCustomerFromIndia(). Decide what suits you best.*/

public class JsonDataReader {

	private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "Customer.json";
	private List<Customer> customerList;
	 
	 public JsonDataReader(){
		 /*getCustomerData() :This is a private method, which has the logic implemented to read the Customer Json and 
		   save it to the class instance variable. 
	       You should be creating more methods like this if you have more test data files like getPaymentOptions(), getProducts() etc*/
	 
	        customerList = getCustomerData();
	        }
	 
	 private List<Customer> getCustomerData() {
		 /*GSON is the main class that exposes the methods fromJson() and toJson() for conversion. For default implementation, 
		  * we can create this object directly or we can use GsonBuilder class that provide useful options for conversion.
		  */
	 Gson gson = new Gson();
	 BufferedReader bufferReader = null;
	 try {
	 bufferReader = new BufferedReader(new FileReader(customerFilePath));
	 Customer[] customers = gson.fromJson(bufferReader, Customer[].class);
	 return Arrays.asList(customers);
	 }catch(FileNotFoundException e) {
	 throw new RuntimeException("Json file not found at path : " + customerFilePath);
	 }finally {
	 try { if(bufferReader != null) bufferReader.close();}
	 catch (IOException ignore) {}
	 }
	 }
	 
	 	
	 public final Customer getCustomerByName(String customerName){
	 for(Customer customer : customerList) {
	 if(customer.firstName.equalsIgnoreCase(customerName)) return customer;
	 }
	 return null;
	 }
}
