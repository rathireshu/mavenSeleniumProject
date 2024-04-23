package updatedSel4Practice2023;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectingGenericDateInCalaender {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		//now for latest ver of chrome v111 , we have to set more system properties as give below and add same dependency is pom.xml
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");			
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		//select April 23 in calender;
		
		driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).click();
			}

}
