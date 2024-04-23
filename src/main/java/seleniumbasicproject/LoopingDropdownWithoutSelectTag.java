package seleniumbasicproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoopingDropdownWithoutSelectTag {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Passengers drop down without select tag
		driver.findElement(By.id("divpaxinfo")).click();
	    Thread.sleep(1000);
	   // driver.findElement(By.xpath("//div[@id='divAdult']/div[2]/span[@id='hrefIncAdt']")).click();
	    
		/*
		 * // int i=1; // while(i<5) // { //
		 * driver.findElement(By.id("hrefIncAdt")).click(); // i++; //
		 * }System.out.println("No of adult selected:-"+i); //
		 */	   
	    
	    for(int i=1;i<5;i++)
	    {
	    	driver.findElement(By.id("hrefIncAdt")).click();
	    }
	       System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	       driver.findElement(By.id("btnclosepaxoption")).click();		   
		   driver.close();

	}

}
