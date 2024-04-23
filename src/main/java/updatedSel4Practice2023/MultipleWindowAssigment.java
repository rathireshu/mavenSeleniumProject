package updatedSel4Practice2023;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowAssigment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();		
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it =windows.iterator();
		String parentwindow=it.next();
		String childwindow=it.next();
		driver.switchTo().window(childwindow);
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentwindow);
		
		String parentPageTitle=driver.findElement(By.xpath("//a[text()='Click Here']/parent::div/h3")).getText();
		System.out.println(parentPageTitle);
	}

}
