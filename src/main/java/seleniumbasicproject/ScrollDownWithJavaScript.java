package seleniumbasicproject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class ScrollDownWithJavaScript {

	public static void main(String[] args) {				
				
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");		
		
//		    General syntax how to use java script in selenium :		
//			So to utilize JavascriptExecutor, first we need to create a reference for the interface and 
//          assign it to the WebDriver instance by type casting it.

			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   
//			Scroll down to the desired location vertically by 1000 pixels on web page by using scrollBy(x-pixels,y-pixels) method.

			   js.executeScript("window.scrollBy(0,1000)");
		

			   System.out.println("scrolled till end");
			   
			   driver.close();
			   
			   
//https://www.lambdatest.com/blog/how-to-use-javascriptexecutor-in-selenium-webdriver/
				//scrollBy() method is used to scroll down the webpage	
				//executeScript("window.scrollBy(x-pixels,y-pixels)");
				//js.executeScript(“window.scrollBy(0,500)”);
				//js.executeScript(“window.scrollBy(0,document.body.scrollHeight)”);				
							   
			   
// how to send input in textbox without sendkeys(method by using java script
		
//		     JavascriptExecutor jse = (JavascriptExecutor) driver;
//		     jse.executeScript("document.getElementById(‘email').value=“abc.efg@xyz.com”);
			   
// how to click on button by using java script

			//js.executeScript("document.getElementById('enter element id').click();");
			 //or
			 //js.executeScript("arguments[0].click();", okButton);
			   
//To Handle Checkbox by passing the value as true or false   
			 //  js.executeScript("document.getElementById('enter element id').checked=false;");
	}
}