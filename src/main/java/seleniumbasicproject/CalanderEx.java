package seleniumbasicproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.*;


public class CalanderEx {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		// To select departure city
		driver.findElement(By.xpath("//a[@value='GOI']")).click();
		Thread.sleep(1000);
		
		// To select arrival city		
		driver.findElement(By.cssSelector("#glsctl00_mainContent_ddl_destinationStation1_CTNR a[value='GOP']")).click();		
		
		
		//select the current dates from auto populated calaender ui on the page
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		System.out.println("current data selected");
		
		//now validating return data calender is disable for one way selection.
		
		driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("0.5");
		
		if(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("0.5"))
		{
			System.out.println("Returen data calander is disabled for one way selection ");
		}
		else 
		{
			System.out.println("Wrong selection:--Returen data calander is enable for one way selection");
		}
		
		//now select round trip radiobtn
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("1"));
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("1"));
		System.out.println("Returen data calander is enabled now for 2 way selection ");
		
		
		
		//driver.close();
		
		

	}

}
