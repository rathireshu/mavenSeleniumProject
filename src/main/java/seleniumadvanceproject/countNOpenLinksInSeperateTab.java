package seleniumadvanceproject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class countNOpenLinksInSeperateTab {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("https://qaclickacademy.com/practice.php");
		
		//1.find all the links of the webpage.
		
		int linkcount=driver.findElements(By.tagName("a")).size();
		System.out.println("link count on page:-"+linkcount);
		
		
		//2.now find the links within footer section only......so to achive this we will limit the scope of driver to footer		
		
		WebElement footerdriver=driver.findElement(By.id("gf-BIG"));
		int footerlinkcount=footerdriver.findElements(By.tagName("a")).size();
		System.out.println("footerlinkcount:-"+footerlinkcount);
		
		//3. now find the links in first column of footer
		
		WebElement columndriver =  footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		
		//4.open each link of column in a seperate tab and get title
		
		//first open all the tabs
		for(int i=1;i<columndriver.findElements(By.tagName("a")).size();i++)
		{
			String clickonlink=Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);
			
		}
		
		//and now print the title of each tab
		
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		
		while(it.hasNext())
		{
		driver.switchTo().window(it.next());
		System.out.println(driver.getTitle());
		}
		
		
		driver.close();
		
		
	}

}
