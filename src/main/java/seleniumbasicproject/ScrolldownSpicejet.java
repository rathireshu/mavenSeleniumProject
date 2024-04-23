package seleniumbasicproject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ScrolldownSpicejet {

	public static void main(String[] args) throws InterruptedException {
		
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
	      WebDriver driver =new ChromeDriver();
	      driver.get("http://spicejet.com"); 
	      
	      //click on to city drop down
	      
	      driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/div")).click();
	      Thread.sleep(1000);
	      //WebDriverWait wait=new WebDriverWait(driver, 20);
	      //Object Element = wait.until(ExpectedConditions.alertIsPresent());
	      //driver.switchTo().alert().accept();
	      //System.out.println(driver.switchTo().alert().getText());
	  	  //driver.switchTo().alert().accept();
	  	
	      	// Create instance of Javascript executor
	      
	     	JavascriptExecutor je = (JavascriptExecutor) driver;
	     	
		//Identify the WebElement which will appear after scrolling down here finding chandigarh city
     		WebElement element = driver.findElement(By.xpath("//div[text()='IXC']"));
     		System.out.println("Now find chandigarh");
     		
	    //Now execute query which actually will scroll until that element is not appeared on page.
        	je.executeScript("arguments[0].scrollIntoView(true);",element);

 		    System.out.println("Now click on chandigarh");
	        driver.findElement(By.xpath("//div[text()='IXC']")).click();
            System.out.println("clicked");
            Thread.sleep(2000);
            driver.close();


	}

}
