package seleniumbasicproject;

//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingAssignment {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");	 
	    driver.manage().window().maximize();
	    
	    //Scenario 1: To scroll down the web page by pixel...executeScript("window.scrollBy(x-pixels,y-pixels)
	    //Scenario 2: To scroll down the web page by the visibility of the element.
	    //Scenario 3: To scroll down the web page at the bottom of the page.
	    //Scenario 4: Horizontal scroll on the web page.
	    //Scenario 5: scroll into a web element present on the web page.

	    
	    //WebElement inputbox= driver.findElement(By.id("displayed-text"));
	    
	    //Scenario 2/4:--This will scroll the page Horizontally till the element is visibile
	    //arguments[0]” means first index of page starting at 0.
	    
	    JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].scrollIntoView(true)", inputbox);
		
		//Scenario 1:--This  will scroll down the page by  500 pixel vertical
	    js.executeScript("window.scrollBy(0,500)");
	    
	    Thread.sleep(2000);
	    
	    
	    //Scenario 5:--scroll within webelement-table, present on webpage
	    //will use this java script to access dom object...."(document.querySelector("cssselector").scrollTop=100")
	    js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
	    
	    Thread.sleep(2000);
	    
	    //Scenario 2:--This will scroll the web page till end.here body =webpage	
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    
	    //driver.close();   
	    
	}

}
