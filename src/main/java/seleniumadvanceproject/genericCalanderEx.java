package seleniumadvanceproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class genericCalanderEx {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companions");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
	
		//click on the calendar
		Thread.sleep(2000);
		driver.findElement(By.id("travel_date")).click();
		System.out.println("pass1");
		Thread.sleep(1000);
		
		//now select  month by using while(false) loop
		
		while(!driver.findElement(By.className("datepicker-switch")).getText().contains("August")) 
		{
			driver.findElement(By.className("next")).click();
		}
		
		//now select the data of that month
		
		List<WebElement> Date =driver.findElements(By.className("day"));
		
		for(int i=0;i<Date.size();i++) 
		{
			if(Date.get(i).getText().equalsIgnoreCase("20"))
			{
				Date.get(i).click();
				break;
			}
		}
		System.out.println("date selected");
		
		driver.close();
	}

}
