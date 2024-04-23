package seleniumadvanceproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("https://qaclickacademy.com/practice.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		WebElement chechbox=driver.findElement(By.id("checkBoxOption1"));
		String text=chechbox.getAttribute("value");
		chechbox.click();
		
		WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));
		Select s= new Select(dropdown);		
		s.selectByValue(text);		
		
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		
		String alerttext=driver.switchTo().alert().getText();
		Assert.assertEquals(alerttext.contains(text),true);
		driver.switchTo().alert().accept();
		
		driver.close();
		
		
	}

}
