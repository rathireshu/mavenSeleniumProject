package seleniumadvanceproject;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingMultipleWindow {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
	     WebDriver driver=new ChromeDriver();
	     driver.get("https://rahulshettyacademy.com/angularpractice/");
	     
	    driver.manage().window().maximize();
        
	    
	    //now invoke a new tab by using selenium 4.0 version
	    
	    driver.switchTo().newWindow(WindowType.TAB);
	    
	    Set<String> handles = driver.getWindowHandles();
	    
	   Iterator<String>  it =handles.iterator();
	   //String parantwindow= it.next();
	   String childwindow= it.next();
	   
	   driver.switchTo().window(childwindow);
	   driver.get("https://rahulshettyacademy.com/");
	   
	   
	  
	   
	
	
	
	
	
	}

}
