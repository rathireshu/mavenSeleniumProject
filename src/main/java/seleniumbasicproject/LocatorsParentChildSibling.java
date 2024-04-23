package seleniumbasicproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsParentChildSibling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//driver.findElement(By.xpath("//header[contains(@class,'jumbotron')]/div/button[text()='Practice']/following-sibling::button[1]"));
		
		
		//parent-child to sibling traverse
		
		String element= driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
		System.out.println(element);
		
		//parent-child to sibling and sibling to parent again traverse
		
		driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header/a[@class='blinkingText']")).click();
		//System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());

		driver.close();

	}

}
