package updatedSel4Practice2023;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FlightBookingSample {

	public static void main(String[] args) throws InterruptedException 
	
	{
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		//now for latest ver of chrome v111 , we have to set more system properties as give below and add same dependency is pom.xml
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		verifyHomePage(driver);
		bookFlight(driver);
		
		driver.quit();	

	}
	
	public static void verifyHomePage(WebDriver driver) 
	{
		
		Assert.assertEquals(driver.getTitle(), "QAClickJet - Flight Booking for Domestic and International, Cheap Air Tickets");
		System.out.println("landing on home page");
	}
	
	public static void bookFlight(WebDriver driver) throws InterruptedException 
	{
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");	
		Thread.sleep(2000);
		//now we get list of options in autosuggest dropdown so we will make a list of webelements and use loop to find our option
		
		 List<WebElement> countryOptions =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		System.out.println("india country");
		
		for(WebElement option: countryOptions)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}			
		}	
		
		
		//select date 28 april
		
		driver.findElement(By.name("ctl00$mainContent$view_date1")).click();
			
		// so first check which month is selected if its not april then keep clicking next arrow to select desire mnths	
		
		while(!driver.findElement(By.cssSelector(".ui-datepicker-month")).getText().contains("April")) 
		{
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
			
		}
		
		//now select desired date
		//so for that make a list of all day by using generic css selector for dates
		List<WebElement> dates=	driver.findElements(By.cssSelector(".ui-state-default"));
		
		for(int i=0;i<dates.size();i++) 
		{
			String date=dates.get(i).getText();
			if(date.equalsIgnoreCase("28")) 
			{
				dates.get(i).click();
				
				break;
			}
		}
		
	
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));	
		
		
		//now add passanger
		System.out.println("now add passanger");
		driver.findElement(By.id("divpaxinfo")).click();
		
		int i=1;
		while(i<5)
		{
		driver.findElement(By.id("hrefIncAdt")).click();
		i++;
		}
		
		String aduldcount= driver.findElement(By.id("divpaxinfo")).getText();
		
		System.out.println("aduldcount :-"+aduldcount);
		
		for(int y=0;y<4;y++) 
		{
		driver.findElement(By.id("hrefIncChd")).click();		
		
		}
		
		System.out.println("totalcount :-"+driver.findElement(By.id("divpaxinfo")).getText());
		
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		WebElement CurrencyDD=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select CurrencyVlaue= new Select(CurrencyDD);
		CurrencyVlaue.selectByIndex(2);
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		System.out.println("pass");
		
	}
	
	
	
}
