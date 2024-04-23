package updatedSel4Practice2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import io.github.bonigarcia.wdm.WebDriverManager;


public class EcommerceProject_Nov23 {

	public static void main(String[] args) 
	{
		//we used WebDriverManager to set up browser drivers for selenium 4.1.X versions untill early nov 2023 by adding below line ,
		//after adding this line we donot need to set up system properties and driver.exe file.	
		
		//WebDriverManager.chromedriver().setup();
		
	// but now in NOV 2023 selenum again replace "WebDriverManager" by "selenium manager" and we do not need to write 
	//"WebDriverManager.chromedriver().setup()"  for selenium latest versions sel 4.11.0
	//Now its super easy wedo not need any thisng extra just below
	//create driver object of requried browser and selenium manager will take care every thing automatechlly.	
		
		
		//just if i want to set any specific version of browser then i will use chromeoptions class.
		ChromeOptions op = new ChromeOptions();
		op.setBrowserVersion("112");
		
		WebDriver driver = new ChromeDriver(op);	//my default chrome version is v118

		driver.get("https://www.google.com/gmail/about/");
	}

}

