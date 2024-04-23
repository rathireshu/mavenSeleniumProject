package updatedSel4Practice2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assingment_SubmitForm {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		submitForm(driver);
		
		
	}

	 public static void submitForm(WebDriver driver) 
	 {
		 
		 driver.findElement(By.name("name")).sendKeys("reshutest");
		 driver.findElement(By.name("email")).sendKeys("reshutest@qa.com");
		 driver.findElement(By.id("exampleInputPassword1")).sendKeys("#test45");
		 driver.findElement(By.className("form-check-input")).click();
		 
		 WebElement genderDD=driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));
		 
		 Select options = new Select(genderDD);
		 options.selectByVisibleText("Female");
		 
		 driver.findElement(By.xpath("//input[@class='form-check-input']/following-sibling::label[text()='Student']")).click();
		 driver.findElement(By.name("bday")).sendKeys("2023-12-31");
		 driver.findElement(By.xpath("//input[@value='Submit']")).click();
		 
		 WebElement SuccessMSG=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		 
		 Assert.assertTrue(SuccessMSG.isDisplayed());
		 System.out.println(SuccessMSG.getText());
		 driver.quit();
		 
		 
	 }
	
}
