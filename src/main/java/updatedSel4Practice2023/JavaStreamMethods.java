package updatedSel4Practice2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaStreamMethods {

	public static void main(String[] args)
	{
		//java stream methods:- stream(),filter(lambda expression),map(),limit(),count(),foreach(argument),
		
		
		List <String> names = new ArrayList<String>();
				
			names.add("sam");
			names.add("ranu");
			names.add("Amit");
			names.add("mike");
			names.add("ram");
			names.add("Anu");
		
			System.out.println(names);
			
			//count the number of names that start with A.
		
			int count =0;
		     for(int i=0;i<names.size();i++ ) 
		       {
			       String name= names.get(i);
			       if(name.startsWith("A")) 
			       {
			    	   count++;
			       }
		        }
		     System.out.println("name start with A count is :"+count);
		     
		 	//Now count the number of names start with A using JAVA STREAM.
		     
		    //step 1: first we have to convert list into stream
		   //step 2: now we have to perform intermediate operation like FILTER to transform it into another stream
		   // step 3: now perform terminal operation on final stream.	
			
		long c=names.stream().filter(s-> s.startsWith("A")).count();
		System.out.println(c);
		
		
		//create a list of numbers and print only even number from that list
		
		//method 1 to create array list
		List<Integer> num = new ArrayList<Integer>();
		
		num.add(2);
		num.add(12);		
		Arrays.asList(num);
		
		//method 2 to create array list in one line
		List<Integer> num1 = Arrays.asList(1,3,4,2,6,7,8,4,9,10,23,24);
		
		//now we will use java stream on list
		
	List<Integer> evennum=	num1.stream().filter(e->e%2==0).collect(Collectors.toList());
	
	System.out.println("first even number: "+evennum.get(1));
	System.out.println("list of even number: "+evennum);
		
		
		//now print names with letter count more than 3
	
	names.stream().filter(s->s.length()>3).limit(1).forEach(s->System.out.println(s));
	names.stream().filter(s->s.length()>3).forEach(s->System.out.println(s));
	
	
	//now we will use MAP method --we use map method when we want to modify the filter results
	
	//so here we are converting name that ends with "u" into upper case
	
		names.stream().filter(s->s.endsWith("u")).map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
		
		//now merging 2 streams and than sort the final stream
		
		List<String> colors = Arrays.asList("red","pink","blue","black");
		
		Stream finalstream =Stream.concat(names.stream(), colors.stream());
		System.out.println("print final result:--");
		finalstream.sorted().forEach(s->System.out.println(s));
		
	}

}
