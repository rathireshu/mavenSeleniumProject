package seleniumbasicproject;
import org.openqa.selenium.chrome.*;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddItemToCart {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");	
		Thread.sleep(1000);
		
		//get the list of all item present on shopping site
		            List< WebElement> productList= driver.findElements(By.xpath("//h4[@class='product-name']"));
		            System.out.println("Item in List:"+productList.size());
		            int j=0;
		            //array of all item which need to be added into cart  
		          String[] itemNeeded = {"Cucumber","Brocolli","Carrot","Tomato"};
		            
		            for(int i=0;i<productList.size();i++)
		            {
		            	
		            	String ItemName=productList.get(i).getText();
		            	System.out.println("item found:-"+ItemName);
		            	
		            	//Need to add shopping items to the cart but to do that first we need to compare "itemNeeded" array with "ItemName" list
		            	//and again to do that first need to convert "itemNeeded" array into arraylist for easy search
		            	
		            	List<String> itemNeededList = Arrays.asList(itemNeeded);
		            	
		            	//String[] name=productList.get(i).getText().split("-");
		            	String[] name1=ItemName.split("-");
		            	String formatted=name1[0].trim();
		            	
		            	if(itemNeededList.contains(formatted))
		            	{
		            		j++;
		            		driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
		            		System.out.println("item added to the cart");
		            		
		            	}
		            	System.out.println("total item in shopping cart:-"+j);
		            	if(j==itemNeeded.length) 
		            	{
		            		break;
		            	}
		            	
		            	
		            }
		          driver.close();   
	}
	
}