package seleniumbasicproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class RadiobtnCheckBoxExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
						
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				
				// is radio btn checked
			    
			    boolean value=driver.findElement(By.cssSelector("input[value='radio2']")).isSelected();
			    System.out.println("radio btn checked:-"+value);
			    driver.findElement(By.cssSelector("input[value='radio2']")).click();
			    boolean valuelatest=driver.findElement(By.cssSelector("input[value='radio2']")).isSelected();
			    System.out.println("radio btn checked:-"+valuelatest);
                
			    //is first check box selected on page
				
				System.out.println(driver.findElement(By.cssSelector("div[id='checkbox-example'] input[id='checkBoxOption1']")).isSelected());
			    driver.findElement(By.cssSelector("div[id='checkbox-example'] input[id='checkBoxOption1']")).click();
			    System.out.println(driver.findElement(By.cssSelector("div[id='checkbox-example'] input[id='checkBoxOption1']")).isSelected());
			    
			    //check how many total checkboxes present on the page:---for that need to find a common selector for all checkboxes
			    
			    int checkboxcount=driver.findElements(By.cssSelector("input[type='checkbox']")).size();
			    System.out.println(checkboxcount);
			    
			    driver.close();	    
			    
			     }

}
