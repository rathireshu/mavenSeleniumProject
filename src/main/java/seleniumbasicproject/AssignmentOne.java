package seleniumbasicproject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AssignmentOne {

	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		//now for latest ver of chrome v111 , we have to set more system properties as give below and add same dependency is pom.xml
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		
		login(driver);
		shopItems(driver);
	    driver.close();
	}
	
	public static void login(WebDriver driver)
	{
		
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']/following-sibling::span")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'functionalities')]")));
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'functionalities')]")).isDisplayed(), true);
		driver.findElement(By.xpath("//button[text()='Okay']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='form-control']")));
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select s = new Select(dropdown);
		s.selectByIndex(2);
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();		
		System.out.println("login successfully");		
	}
	
	public static void shopItems(WebDriver driver) 
	{
		System.out.println("in second method");
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(2));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Shop Name']")));
		System.out.println("in second method1");
		Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Shop Name']")).getText(), "Shop Name", "not matched");
		List <WebElement> itemlist =driver.findElements(By.xpath("//button[text()='Add ']"));
		System.out.println(itemlist.size());
		for(int i=0;i<itemlist.size();i++)
		{
			itemlist.get(i).click();
		}
		
		//now verify checkout item and click btn
		
		Assert.assertEquals(driver.findElement(By.xpath("//a[contains(text(),'Checkout ( 4 )')]")).isDisplayed(), true);		
		WebElement checkout=driver.findElement(By.cssSelector("li.nav-item.active"));		
		checkout.click();
		
		//now click on success checkout 
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.btn-success")));
		driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("country")));
		driver.findElement(By.id("country")).sendKeys("india");
		//driver.findElement(By.id("checkbox2")).click();
		driver.findElement(By.xpath("//input[@value='Purchase']")).click();
		boolean h=driver.findElement(By.xpath("//strong[text()='Success!']")).isDisplayed();
		System.out.println(h);
		
	}

}
