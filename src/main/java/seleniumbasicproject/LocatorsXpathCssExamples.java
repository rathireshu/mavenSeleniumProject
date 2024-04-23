package seleniumbasicproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

public class LocatorsXpathCssExamples {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		Thread.sleep(1000);
		//forgot password flow
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		//locator with indexing on xpath n cssselector
		driver.findElement(By.xpath("//input[@type='text'][1]")).sendKeys("Reshurathi");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("reshu@gmail.com");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("123456789");		
		driver.findElement(By.xpath("//button[contains(@class,'reset')]")).click();
		Thread.sleep(1000);
		//Please use temporary password 'rahulshettyacademy' to Login.
		//validate temp password text and try again
		
		String teppwd=driver.findElement(By.cssSelector("p.infoMsg")).getText();
		System.out.println("Temp pwd text="+teppwd);
		
		//going back to login page and try again with temp password
		
		driver.findElement(By.xpath("//button[contains(@class,'login')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("reshu");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxTwo")).click();
		
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='login-container']/h2[contains(.,'Hello reshu')]"));
		System.out.println("sing in pass");
		
		driver.close();

	}

}
