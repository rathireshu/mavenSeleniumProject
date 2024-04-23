package seleniumadvanceproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class getTableColumnDataText {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");	 
	    driver.manage().window().maximize();
	    
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,500)");
	    
	    List<WebElement>columndata=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));	    
	    int sum=0;
	    for(int i=0;i<columndata.size();i++) 
	    {
	    	int columnvalue=Integer.parseInt(columndata.get(i).getText());
	    	
	    	sum=sum+columnvalue;
	    	
	    }
	    
	    System.out.println(sum);
	    
	    String resulttext=driver.findElement(By.cssSelector(".totalAmount")).getText();
	    
	    int totalcount=Integer.parseInt(resulttext.split(":")[1].trim());	    
	   
	    System.out.println("totalcount:"+totalcount);
	    
	    Assert.assertEquals(totalcount, sum);
	    
	    //print name of cities
	    
	    List<WebElement>citieslist=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(3)"));
	    
	    for(int i= 0;i<citieslist.size();i++)
	    {
	    	 System.out.println(citieslist.get(i).getText());
	    	
	    }
	    
	    
	    driver.close();
	    
	}

}
