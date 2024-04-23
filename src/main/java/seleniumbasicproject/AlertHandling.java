package seleniumbasicproject;

	
	import org.openqa.selenium.By;	
	import org.openqa.selenium.WebDriver;	
	import org.openqa.selenium.chrome.ChromeDriver;
	
	public class AlertHandling {

	public static void main(String[] args)
	{

	String text="Reshu";
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
	//enter text and click on alert 
	
	driver.findElement(By.id("name")).sendKeys(text);
	driver.findElement(By.id("alertbtn")).click();
	
	//now validate text on alert box ,so for that switch to alert mode first and then accept the alert box
	
	System.out.println(driver.switchTo().alert().getText());
	driver.switchTo().alert().accept();
	driver.findElement(By.id("name")).sendKeys(text);
	driver.findElement(By.id("confirmbtn")).click();
	System.out.println(driver.switchTo().alert().getText());
	driver.switchTo().alert().dismiss();	
	driver.close();
	
    }
}