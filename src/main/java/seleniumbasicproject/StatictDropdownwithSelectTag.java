package seleniumbasicproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StatictDropdownwithSelectTag {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//static currency drop down with select tag---webelement shld be select tag
		
		WebElement currencydropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));		
		Select currencyvalue = new Select(currencydropdown);
		currencyvalue.selectByIndex(2);
		currencyvalue.selectByValue("AED");
		currencyvalue.selectByVisibleText("USD");		
		
		driver.close();
		

	}

}
