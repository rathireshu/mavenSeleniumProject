package seleniumbasicproject;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicDropdownWithoutSelectTag {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// System.out.println(driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_0']")).getText());

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		String title = driver.findElement(By.cssSelector("h3.title1")).getText();
		System.out.println(title);

		// To select departure city
		driver.findElement(By.xpath("//a[@value='GOI']")).click();
		Thread.sleep(1000);

		/*
		 * but when selecting arrival city its shows 2 matches for every city elements as page is not changing and it counts 2 web elements
		 *  one from arrival and another from departure drop down with the same locator, so in that case we need to use unique locator 
		 *  method:--Parent-Child locator identification method to identify dynamic drop down options as below.
		 */
		
		// To select arrival city		
		driver.findElement(By.cssSelector("#glsctl00_mainContent_ddl_destinationStation1_CTNR a[value='GOP']")).click();
		
		driver.close();	
		
						
		
	}

}
