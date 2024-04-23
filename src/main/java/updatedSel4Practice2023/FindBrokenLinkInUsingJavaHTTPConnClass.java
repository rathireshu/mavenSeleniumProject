package updatedSel4Practice2023;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class FindBrokenLinkInUsingJavaHTTPConnClass {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//So now we have to find broken link into footer section for that follow below steps.
		//Step1:-To get all the url tied up with links into a list via selenium
		//Ster2:Now use Java build in method which will call URLs & get their status code.if code>400 than link broken.
		
	   //Note:-We will use these java classes "URL", "URLConnection" and "HttpURLConnection" .see below ex how to use these classes
		
		          //String url = "https://google.com";		
		          //URL urlObj = new URL(url);................pass string url as argument to URL class.
		          //URLConnection urlConn = urlObj.openConnection();...now we will open network conn on this url object
		          // Note:--but The above program will fail silently if the server returns a response code other than 200.
		           //so lets use the parent class "HttpUrlConnection" instead
	              //HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();
		          //int responseCode = httpCon.getResponseCode();	 
		
		SoftAssert a=new SoftAssert();
		
		//Step1:-To get list of links
		
		List<WebElement>links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));	
		
		//Step2:-use java class To get response code ,use for loop for multiple links.
		
		for(WebElement link:links) 
		{
			//get url for links
			String url=link.getAttribute("href");
			
			//crete object of url class and pass url into tht
			URL urlobj = new URL(url);
			HttpURLConnection httpconn =(HttpURLConnection) urlobj.openConnection();
			int responseCode=httpconn.getResponseCode();
			
			//now use soft assert to verify condation and print msg
		
			a.assertTrue(responseCode<400, "link "+link.getText() +" is broken with code "+responseCode);		
			
		  }
		
		 a.assertAll();
		
		
	}

}
