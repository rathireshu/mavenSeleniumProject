package seleniumadvanceproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;


public class RelativeLocatorsEX {

	public static void main(String[] args) {
		
		     System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
		     WebDriver driver=new ChromeDriver();
		     driver.get("https://rahulshettyacademy.com/angularpractice/");
		    driver.manage().window().maximize();
	         WebElement inputbox= driver.findElement(By.xpath("//input[@name='name2']"));
	         
	         //need to find the name label above input box 
	         String s=driver.findElement(with(By.tagName("label")).above(inputbox)).getText();
		   	System.out.println(s);
		   	
		  //need to click check box left of text 
		   	WebElement checkboxtext= driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
		   	driver.findElement(with(By.tagName("input")).toLeftOf(checkboxtext)).click();

		    //need to click submit btn below data of birth label 
		   	
		   	WebElement w= driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		   	driver.findElement(with(By.tagName("input")).below(w)).click();
		   	
		  //need to click radio btn right side of student radio btn text 
		   	
		   	WebElement r=driver.findElement(By.xpath("//label[@for='inlineRadio1']"));
		   	driver.findElement(with(By.tagName("input")).toRightOf(r)).click();
		   	
		   	driver.close();
		   	
	}

}

