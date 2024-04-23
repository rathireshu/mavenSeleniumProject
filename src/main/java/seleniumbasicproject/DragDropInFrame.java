package seleniumbasicproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropInFrame {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		//now switch to frame 
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement target=driver.findElement(By.id("droppable"));
		
		//now create object of actions class to perform drag n drop
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
		
		//now back to main web page		
		driver.switchTo().defaultContent();
		driver.close();		
		
	}

}
