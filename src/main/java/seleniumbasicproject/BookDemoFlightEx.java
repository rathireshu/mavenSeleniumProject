package seleniumbasicproject;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.*;



public class BookDemoFlightEx {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");		
		
		
		Assert.assertTrue(driver.findElement(By.className("search-buttons-heading")).isDisplayed());
		driver.findElement(By.id("autosuggest")).sendKeys("aus");
		List <WebElement> countries = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));
		for(WebElement country : countries)
		{
			if(country.equals("Austria"))
			{
				driver.findElement(By.linkText("Austria")).click();
			}
		}
	
		//check which way is selected
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		Assert.assertTrue(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));
		
		// To select departure city
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='GOI']")).click();
		Thread.sleep(1000);
		
		// To select arrival city		
		driver.findElement(By.cssSelector("#glsctl00_mainContent_ddl_destinationStation1_CTNR a[value='GOP']")).click();
		Thread.sleep(1000);
		//select current data or if want to select any other data then use 2nd xpath
		driver.findElement(By.xpath("//td[contains(@class,'ui-datepicker-today')]")).click();		
		//div[contains(@class,'ui-datepicker-group-first')]/table[@class='ui-datepicker-calendar']/tbody/tr[3]/td/a[text()='16']
		
		//select returen data
		driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		driver.findElement(By.xpath("//div[contains(@class,'ui-datepicker-group-last')]/table[@class='ui-datepicker-calendar']/tbody/tr[3]/td/a[contains(.,'16')]")).click();	
		Thread.sleep(1000);
		//select passenger dropdown
		
		driver.findElement(By.id("divpaxinfo")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "1 Adult");
		Thread.sleep(1000);
		
		for(int i=1;i<3;i++)
		{
				driver.findElement(By.id("hrefIncAdt")).click();
		        
		}
		for(int i=1;i<3;i++)
		{
		       driver.findElement(By.id("hrefIncChd")).click();		
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "3 Adult, 2 Child");
		
		// select currency drop down
		
		WebElement currencydropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));		
		Select currencyval = new Select(currencydropdown);
		currencyval.selectByVisibleText("USD");		
		
		
		//checking number of checkboxes on page
		
		Assert.assertEquals(driver.findElements(By.xpath("//input[@type='checkbox']")).size(), 6);		
		driver.findElement(By.id("familyandfriend")).click();
		
		//click on search button
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		Thread.sleep(1000);
		
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected());
		driver.close();	
	
	}

}
