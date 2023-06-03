package com.qa.opencart.InterviewQuestions;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test7 {

	public static void main(String[] args) {
		
		String str = "I I AM AM A GOOD GOOD BOY BOY";
		
		 String[] eachWords = str.split(" ");
		 
		 LinkedHashSet<String> uniqueEle = new LinkedHashSet<String>();
		List<String> removeDuplicates =  Arrays.asList(eachWords).stream().filter(e -> uniqueEle.add(e)).collect(Collectors.toList());
		
		String afterRemovingDuplicates="";
		for(String each:removeDuplicates) {
			afterRemovingDuplicates = afterRemovingDuplicates+each+" ";
		}
		
		System.out.println(afterRemovingDuplicates);
		

	}

}
