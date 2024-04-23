package seleniumadvanceproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("Ind");
        Thread.sleep(2000);
        
        List<WebElement> countryname=driver.findElements(By.cssSelector("ul.ui-autocomplete li"));
        for(WebElement name:countryname )
        { 
        	if(name.getText().equalsIgnoreCase("India")) {
        		
        		name.click();
        	}
        	
        }
        
	}
}
