package seleniumbasicproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class seleniumtest {

	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
      System.out.println("setting  chrome driver exe in system properties");
     // System.setProperty("webdriver.gecko.driver", "C:\\Users\\bhanu\\Downloads\\geckodriver-v0.31.0-win64.exe");
      System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
     // WebDriver driver= new FirefoxDriver();
      WebDriver driver= new ChromeDriver();
      //String URL="https://www.google.com/";
      driver.get("https://google.com/");
     // driver.wait(long 10000);
      System.out.println("validate the current url");
      
      System.out.println("get current title:=="+driver.getTitle());
      driver.get("https://facebook.com");
      System.out.println("get current title:="+driver.getTitle());
   
      driver.get("https://www.west-windsor-plainsboro.k12.nj.us/departments/Community_Education");
      System.out.println("get current title:="+driver.getTitle());
      driver.wait(10000);
          driver.close();
	}
	
	
}
