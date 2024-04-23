package seleniumbasicproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdownEx {

	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("Ind");
		Thread.sleep(1000);
		
		//now traverse all the options present in drop down via loop 
		
		List <WebElement> countryoptions = driver.findElements(By.xpath("//ul[contains(@class,'ui-autocomplete')]/li/div"));
		
		for(WebElement option:countryoptions)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				System.out.println("Pass");
				
			}else
			{
				System.out.println("fail");
			}		
			driver.close();
		}

	}

}
