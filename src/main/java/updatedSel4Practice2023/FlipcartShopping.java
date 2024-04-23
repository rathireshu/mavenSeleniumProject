package updatedSel4Practice2023;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipcartShopping {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='JFPqaw']/span")).click();
		
		/*
		 * Set <String> win=driver.getWindowHandles(); Iterator<String>
		 * it=win.iterator(); String p=it.next(); String popup=it.next();
		 * driver.switchTo().window(popup); System.out.println(popup);
		 */
		
		driver.findElement(By.cssSelector(".YBLJE4")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.findElement(By.xpath("//p[text()='Xiaomi']")).click();
		driver.findElement(By.xpath("//div[@title='4 GB']")).click();
		
		
		//div[text()='RAM']/parent::div/following-sibling::div/div/div[@title='4 GB']
		//div[@title='4 GB']
		
	}

}
