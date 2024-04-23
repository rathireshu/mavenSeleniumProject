package seleniumbasicproject;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MultiWindowHandles {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		
		//opening a new window		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		//now store all the windows handle to a set
		
		Set<String> windows=driver.getWindowHandles();		
	    System.out.println("windows presents:-"+windows);	    
	    Iterator <String> it = windows.iterator();
	    String parent=it.next();
	    String child=it.next();
	    
	    // and now tell driver to switch on requried window to work
		
	    driver.switchTo().window(child);
	    System.out.println("at child window");
	     
	     
	    WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(4));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='im-para red']/strong/a")));	
	    
	    WebElement redtext=driver.findElement(By.xpath("//p[@class='im-para red']/strong/a"));
	    Assert.assertEquals(redtext.isDisplayed(), true);
	    
	    //now copy the email to use as username in parent window from red text 
	    //String emailId= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

	     String emailid=redtext.getText();
	     String username=emailid.split("@")[1].split("\\.")[0];
	     driver.switchTo().window(parent);
	     
	     System.out.println("at parent window");
	     
	     driver.findElement(By.id("username")).sendKeys(username);
	     driver.findElement(By.id("password")).sendKeys("learning");
	     driver.findElement(By.id("signInBtn")).click();   
	   
	   

	}

}
