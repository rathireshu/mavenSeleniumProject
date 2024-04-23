package updatedSel4Practice2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLCertificationHandling {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		//now for latest ver of chrome v111 , we have to set more system properties as give below and add same dependency is pom.xml
	     System.setProperty("webdriver.http.factory", "jdk-http-client");
		
	     //now we have to handle SSL certification by changing browser behiour
	     //so for that selenium has a class called "ChromeOptions" which has build in function "setAcceptInsecureCerts".
	     //for tht we will create object for this class & pass this object into ChromeDriver class constructor as argument
	     
	     // and this options class is present for each browser ex: EdgeOptions,SafariOptions,FirefoxOptions,ChromeOptions
	     
	     //Ex for chrome browser
	     ChromeOptions ChOption =new ChromeOptions();
	     ChOption.setAcceptInsecureCerts(true);     
	     
	     //Ex for firefox browser
	     FirefoxOptions ffOption =new FirefoxOptions();
	     ffOption.setAcceptInsecureCerts(true); 
	     
	     
	     //and here pass the requried options class object as argument
	     WebDriver driver= new ChromeDriver(ChOption);
		driver.get("http://expired.badssl.com");	
		System.out.println(driver.getTitle());
		
	}

}
