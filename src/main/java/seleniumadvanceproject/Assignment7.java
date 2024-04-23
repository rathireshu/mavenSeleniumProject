package seleniumadvanceproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");	 
	    driver.manage().window().maximize();
	    
	    JavascriptExecutor js= (JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,400)");
	    
	    WebElement table=driver.findElement(By.xpath("//table[@name='courses']"));
	    
	    //1.number of rows
	   int rowscount= table.findElements(By.tagName("tr")).size();
	   System.out.println(rowscount);
	   
	   //2.number of columns
	   
	   System.out.println(table.findElements(By.tagName("th")).size());
	   
	 //3.print data of 2nd row
	    
	   List<WebElement> columndata=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
	   
	   //for(WebElement w:columndata)
	   //{
		  // System.out.println(w.getText());
	   //}
	   
	   for(int i=0;i<columndata.size();i++) {
		   System.out.println(columndata.get(i).getText());
	   }
	   }
	}


