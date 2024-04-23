package updatedSel4Practice2023;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class SpiceJetFlightBookingSVGElements {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bhanu\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		// now for latest ver of chrome v111 , we have to set more system properties as
		// give below and add same dependency is pom.xml

		System.setProperty("webdriver.http.factory", "jdk-http-client");

		WebDriver driver = new ChromeDriver();
		driver.get("http://spicejet.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		verifyHomePage(driver);
		oneWayFlightBooking(driver);

		// driver.quit();

	}

	public static void verifyHomePage(WebDriver driver) {
		System.out.println("landed on home page");
		Assert.assertEquals("SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets",
				driver.getTitle());
	}

	public static void oneWayFlightBooking(WebDriver driver) {

		WebElement flightTab = driver.findElement(By.xpath(
				"//div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-vgw6uq r-156q2ks r-11ict49 r-8uuktl r-136ojw6']"));

		if (flightTab.getAttribute("style").contains("height")) {
			Assert.assertTrue(true);
			System.out.println("flight tab selected");
		} else {
			Assert.assertFalse(false);
			System.out.println("else  flight tab not selected");

		}
		// verify one way radio btn is selected

		WebElement radiobtn = driver.findElement(By.xpath("(//*[local-name()='svg']/*[local-name()='circle'])[1]"));

		Assert.assertTrue(radiobtn.isDisplayed());
		Assert.assertTrue(
				driver.findElement(By.xpath("(//*[local-name()='svg']/*[local-name()='circle'])[1]")).isDisplayed());

		System.out.println("Now select from city");

		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
		WebElement fromCity = driver
				.findElement(By.xpath("//div[@data-testid='to-testID-origin']//input[@autocapitalize='sentences']"));

		// entring city without city scrolling
		fromCity.sendKeys("blr");

		System.out.println("select to city");
		WebElement toCity = driver.findElement(
				By.xpath("//div[@data-testid='to-testID-destination']//input[@autocapitalize='sentences']"));

		toCity.click();
		toCity.sendKeys("de");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.findElement(By.xpath("//div[text()='DEL']")).click();

		WebElement date = driver.findElement(By.xpath(
				"//div[contains(@data-testid,'month-October-2023')]//div[@data-testid='undefined-calendar-day-19']"));
		date.click();
		System.out.println("date selected");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

		WebElement passangerDD = driver.findElement(By.xpath("//div[contains(text(),'Adult')]"));
		passangerDD.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7000));

		System.out.println("total adults is 1");

		driver.findElement(By.xpath("//div[@data-testid=\"Adult-testID-plus-one-cta\"]")).click();
		driver.findElement(By.xpath("//div[@data-testid=\"Children-testID-plus-one-cta\"]")).click();
		driver.findElement(By.xpath("//div[@data-testid=\"Children-testID-plus-one-cta\"]")).click();
		// driver.findElement(By.xpath("//div[text()='Done']")).click();
		passangerDD.click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='2 Adults, 2 Children']")).isDisplayed());

		/*
		 * clicking on svg element WebElement plusIcon =driver.findElement(By.
		 * xpath("(//*[local-name()='svg' and @data-testid='svg-img']/*[local-name()='path'])[1]"
		 * )); plusIcon.click(); Actions builder = new Actions(driver);
		 * builder.moveToElement(plusIcon).click().build().perform();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", plusIcon);
		 */

		// now select the currency

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7000));

		driver.findElement(By.xpath("//div[text()='Currency']")).click();
		// now collect all the currency option list
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

		List<WebElement> currencyOption = driver
				.findElements(By.xpath("//div[text()='Currency']/parent::div/following-sibling::div"));
		String[] opt = new String[currencyOption.size()];
		int u = 0;
		for (WebElement curOption : currencyOption) {
			System.out.println(curOption.getText());
			opt[u] = curOption.getText();
			u++;

			/*
			 * if (curOption.getText().equalsIgnoreCase("INR")) { curOption.click();
			 * System.out.println("curOption selected"); }
			 */
		}
		driver.findElement(By.xpath("//div[text()='Currency']")).click();

		List<WebElement> radiobtns = driver.findElements(
				By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-15d164r r-1otgn73']/div[2]"));

		String[] optionNames = new String[radiobtns.size()];
		int i = 0;
		for (WebElement option : radiobtns) {

			System.out.println("Otions are :-" + option.getText());
			// so now we can store these output strings into one string array to perform
			// further actions on them.
			optionNames[i] = option.getText();
			i++;

		}

		driver.findElement(By.xpath("//div[text()='Family & Friends']")).click();

		System.out.println("Now search flight");

		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Previous Day']")).isDisplayed());
	}

}
