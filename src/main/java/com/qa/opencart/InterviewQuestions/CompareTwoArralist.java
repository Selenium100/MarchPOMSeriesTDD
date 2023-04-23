package com.qa.opencart.InterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CompareTwoArralist {
	
	

	public static void main(String[] args) {

		
		ArrayList<String> l1 = new ArrayList<String>(Arrays.asList("A","B","C","D"));
		ArrayList<String> l2 = new ArrayList<String>(Arrays.asList("B","A","C","D"));
		
		Collections.sort(l1);
		Collections.sort(l2);
		
		System.out.println(l1.equals(l2));
		
		//2 . Find the additional element 
		ArrayList<String> l3 = new ArrayList<String>(Arrays.asList("A","B","C","D"));
		ArrayList<String> l4 = new ArrayList<String>(Arrays.asList("A","B","C","E"));
		
		l3.removeAll(l4);
		System.out.println(l3);
		
		//3 . Find out comon elements
		ArrayList<String> lang1 = new ArrayList<String>(Arrays.asList("JAVA","JAVASCRIPT","PYTHON","C#"));
		ArrayList<String> lang2 = new ArrayList<String>(Arrays.asList("JAVA","JAVASCRIPT","PYTHON","GROOVY"));
		
		lang1.retainAll(lang2);
		System.out.println(lang1);
		
		
		
		
	}

}
