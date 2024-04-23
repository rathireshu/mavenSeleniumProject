package updatedSel4Practice2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SortingArrayNArrayListEx {

	public static void main(String[] args)
	{
		//sort array using sort() method to sort an array in ascending order and it does not return anything
		
		int[] num = {2,4,6,8,3,6,7};		
		
		Arrays.sort(num);		
		
		System.out.println("Elements of array sorted in ascending order: ");  
		
		//since sort function does not return anything so we have to use loop to print sorted array elements.  
		for (int i = 0; i < num.length; i++)   
		{       
		System.out.println(num[i]); 
		
		}
		
		
		/* SORTING ARRAY LIST:---
		 * 
		 * An ArrayList can be sorted by using the sort() method of the Collections class in Java.
		 * It accepts an object of ArrayList as a parameter to be sort & returns an ArrayList sorted 
		 * in the ascending order according to the natural ordering of its elements.
		 */	
		/*
		 * Another way to sort an array in Java is to use the Collections.sort() method OF ARRAY LIST.
		 * 
		 * For this first we have to convert array into array list using Arrays.asList(array) method.
		 * 
		 * This method takes a list as a parameter and sorts it in ascending order. 
		 * To sort a list in descending order, you can use the reverseOrder() method from
		 * the Collections class. Here is an example of how to use the Collections.sort() method: 
		 */
		
		
		List<Integer> myList = Arrays.asList(5, 2, 8, 3, 1); 
	    Collections.sort(myList);	
		
		
	    
	    
	    
	    
	    // now sort a ArrayList
		
		List <String> names = new ArrayList<String>();
				
			names.add("sam");
			names.add("ranu");
			names.add("amit");
			names.add("mike");
			names.add("ram");
			names.add("sonu");
			
			
		
		
	}

}
