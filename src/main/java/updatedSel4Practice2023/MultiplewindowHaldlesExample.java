package updatedSel4Practice2023;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiplewindowHaldlesExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.manage().window().maximize();
		//open another window	
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		Set<String> window=driver.getWindowHandles();
		System.out.println(window.size());
		
		//now store all open window in a iterator
		Iterator<String> it=window.iterator();
		
		String parentwindowID=it.next(); //return the next element in the iterator
		System.out.println(parentwindowID);
		String childwindowID=it.next();
		System.out.println(childwindowID);
		
		driver.switchTo().window(childwindowID);
		
		String redtext=driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
		System.out.println(redtext);
		//Please email us at mentor@rahulshettyacademy.com with below template to receive response
		//driver.quit();
		String email=redtext.split("at")[1].trim().split(" ")[0];
		
		System.out.println(email);
		driver.switchTo().window(parentwindowID);
		driver.findElement(By.id("username")).sendKeys(email);
		
		
	}

	 
}
