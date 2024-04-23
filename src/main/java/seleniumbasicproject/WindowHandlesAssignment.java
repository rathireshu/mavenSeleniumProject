package seleniumbasicproject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	    driver.get("http://the-internet.herokuapp.com/");	    
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;	    
	    WebElement link = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::ul/li[33]/a"));
	    js.executeScript("arguments[0].scrollIntoView(true)", link);
	    link.click();
	    
	    String title1=driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText();
	    
	    driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
	    //now new window will open
	    
	    Set<String> windows =driver.getWindowHandles();
	    Iterator<String> it=windows.iterator();
	    String parentwindow=it.next();
	    String childwindow=it.next();
	    driver.switchTo().window(childwindow);
	    System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText()); 
	    
	    driver.switchTo().window(parentwindow);  
	    System.out.println(title1);
	}

}
