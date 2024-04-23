package seleniumbasicproject;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UtilityAddItemsToCart 
{

	public static void main(String[] args)
	{		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));		
		String[] shoppingItems= {"Carrot","Cucumber","Beetroot"};	
		
		addVeggies(driver,shoppingItems);
		verifyCartnPlaceorder(driver);
		driver.close();
		
	}
	
	public static void verifyCartnPlaceorder(WebDriver driver)
	{
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    WebElement cartitem=driver.findElement(By.xpath("//div[@class='cart-info']/table/tbody/tr[1]/td[3]/strong[text()='3']"));
	    Assert.assertEquals(cartitem.isDisplayed(), true);
	    
	    //Now checkout
	    
	    driver.findElement(By.cssSelector("a.cart-icon")).click();	    
	    driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
	    driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
	    driver.findElement(By.xpath("//button[text()='Apply']")).click();
	    
	    //Explicit wait is needed here to load the promo code success
	    
	    WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Code applied ..!']")));	  	    
	    Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Code applied ..!']")).isDisplayed(), true);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Place Order']")));
	    driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	    
	    //now select country and proceed
	    WebElement countryDropdown=driver.findElement(By.tagName("select"));
	    Select country= new Select(countryDropdown);
	    country.selectByValue("France");
	    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	    driver.findElement(By.xpath("//button[text()='Proceed']")).click();
	   
	}
	
	
	
	public static void addVeggies(WebDriver driver,String[] shoppingItems)
	
	{
		
        List<WebElement> totalItems=driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		System.out.println(totalItems.size());
		int j=0;
		
		for(int i=0;i<totalItems.size();i++) 
		{
			
			String name=totalItems.get(i).getText();
			String[] formattedname=name.split("-");
			String formattedproduct=formattedname[0].trim();
		    
			//now need to covert array into arraylist
			
			List<String> shoppingItemslist=Arrays.asList(shoppingItems);
			
			
			if(shoppingItemslist.contains(formattedproduct))
			{
				j++;				
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				System.out.println("total item added in bag: "+j);
			       if(j>totalItems.size())
			         {
			    	   
			    	   break;
			         }
			}
		  }
		
	}
}

