package seleniumbasicproject;
import org.openqa.selenium.chrome.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyBrokenLinks {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhanu\\chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		
		//Collect all the links from the webpage. All the links are associated with the Tag ‘a‘
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are "+links.size());	

		//Create a list of type "WebElement" to store all the Link elements in it.
		
		for(int i =0;i<=links.size();i++)
		{
			
			WebElement linkelement=links.get(i);
			String url=linkelement.getAttribute("href");
			verifyLink(url);			
		}
	}
		
		    public static void verifyLink(String urlLink)
		    {
		        //Sometimes we may face exception "java.net.MalformedURLException".
		    	//Keep the code in try catch block to continue the broken link analysis
		       
		    	try 
		    	{
					//Use URL Class - Create object of the URL Class and pass the urlLink as parameter 
		        	URL link = new URL(urlLink);
		        	
					// Create a connection using URL object (i.e., link)
		        	HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();

					//Set the timeout for 2 seconds
					httpConn.setConnectTimeout(2000);
					
					//Now connect using connect method
					httpConn.connect();
					
					//use getResponseCode() to get the response code.
					
						if(httpConn.getResponseCode()== 200) 
						{	
							System.out.println(link+" - "+httpConn.getResponseMessage());
						}
						
						if(httpConn.getResponseCode()== 404) 
						{
							System.out.println(link+" - "+httpConn.getResponseMessage());
						}
					}
		    	
					//getResponseCode method returns = IOException - if an error occurred connecting to the server. 
		    	
				catch (Exception e) 
		    	{
					e.printStackTrace();
				}
		    } 
		
		
		
//		Some of the HTTP status codes are :
//			200 – valid Link
//			404 – Link Not Found
//			400 – Bad Request
//			401 – Unauthorized
//			500 – Internal error

		
	}

