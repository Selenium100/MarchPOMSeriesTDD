package com.qa.opencart.InterviewQuestions;

import java.util.stream.IntStream;

public class ElementPresentInArrayOrNot {

	public static void main(String[] args) {
		
     int[] arr = {34,57,68,79,23,54};
     
     
     
     System.out.println(isElementPresent(arr, 78));
     
     
	
}
	
	public static boolean isElementPresent(int[] arr,int ele) {
		
		boolean isMatch = IntStream.of(arr).anyMatch(e -> e == ele);
		
		if(isMatch) {
		   return true;
		}
		return false;
	}
}
