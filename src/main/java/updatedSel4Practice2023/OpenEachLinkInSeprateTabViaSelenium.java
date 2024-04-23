package updatedSel4Practice2023;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenEachLinkInSeprateTabViaSelenium {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//list of all links of footer sections
		List<WebElement> pagelinks=driver.findElements(By.tagName("a"));		
		WebElement footer=driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		List<WebElement> footerlinks=footer.findElements(By.tagName("a"));
		
		System.out.println(footerlinks.size());
		
		//list of all links from first cloumn of  footer sections
		WebElement firstcolumn= footer.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul"));
		List<WebElement> firstcolumnlinks =firstcolumn.findElements(By.tagName("a"));
		
		System.out.println(firstcolumnlinks.size());	
		
		
		for(WebElement link:firstcolumnlinks)
		{
			
			String url=link.getAttribute("href");
			
			//System.out.println(url);
			
			
		}
		
		//now open each link into separate tab by using only selenium methods not via java build in functions
		
		for (int i=0;i<firstcolumnlinks.size();i++)
		{		
		
		     String clickonlink = Keys.chord(Keys.CONTROL,Keys.ENTER);
		     firstcolumnlinks.get(i).sendKeys(clickonlink);
		}
		
		//now store all the open tabs in set and get their titles
		
		Set <String> tabs=driver.getWindowHandles();
		Iterator<String> it =tabs.iterator();
		while(it.hasNext()) 
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getCurrentUrl());
		}
		
	}
	
}