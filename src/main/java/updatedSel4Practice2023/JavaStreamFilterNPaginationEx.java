package updatedSel4Practice2023;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaStreamFilterNPaginationEx {

	public static void main(String[] args) 
	
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
	    List<WebElement> firstColNameList=	driver.findElements(By.xpath("//tbody/tr/td[1]"));
	    
	    //now capture text of all veg name from column first by using java stream
	    
	List<String> itemNameList= firstColNameList.stream().map(list->list.getText()).collect(Collectors.toList());
	
	//print item name of list
	itemNameList.forEach(name->System.out.println(name));
	
	//now sort the original list 
	
	List<String> sortedList=itemNameList.stream().sorted().collect(Collectors.toList());
	
	System.out.println("sorted list by java stream");
	sortedList.forEach(name->System.out.println(name));
	//now compare both the list to check whether sorting is working or not on application.
	
	Assert.assertTrue(itemNameList.equals(sortedList));	
	//now find the price based upon veggi name Ex:price for Rice which is on 4th page and to check whole page s use paginatation
	
	List<String> itemPrice;
	do {
		 List<WebElement> rows=	driver.findElements(By.xpath("//tbody/tr/td[1]"));
		    
	     itemPrice= rows.stream().filter(colname->colname.getText().contains("Rice"))
			.map(s->getPrice(s)).collect(Collectors.toList());	
	     
	     if(itemPrice.size()<1)
	     {
		    driver.findElement(By.cssSelector("[aria-label='Next']")).click();
	     }
	
	}while(itemPrice.size()<1);
	itemPrice.forEach(a->System.out.println("price of rice is :-"+a));
	 driver.close();  
	}	
	

	private static String getPrice(WebElement s)
	{
		String price=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}
	
	
	
}
