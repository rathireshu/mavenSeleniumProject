package seleniumbasicproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class mouseOverAction {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		Actions a = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
		
		
		//now enter some text in caps in search text box		
		WebElement textbox=driver.findElement(By.id("twotabsearchtextbox"));	
		Assert.assertEquals(textbox.isDisplayed(), true);
		a.moveToElement(textbox).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
		//mouseover on the sign in element
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		
		driver.close();
		
		
		
			
		

	}

}
