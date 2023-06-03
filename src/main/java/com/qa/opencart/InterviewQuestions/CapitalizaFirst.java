package com.qa.opencart.InterviewQuestions;

public class CapitalizaFirst {

	public static void main(String[] args) {
		
		String str = "nitya ranjan behera"; //Nitya Ranjan Behera
		
		System.out.println(capitalize(str));
		

	}

	private static String capitalize(String str) {
		
		String[] words = str.split(" ");
		
		String counter = "";
		
		for(String each: words) {
			
			String firstLetter= each.substring(0, 1).toUpperCase();
			String remainingLetters = each.substring(1, each.length());
			
			String completeWord = firstLetter+remainingLetters;
			
			counter = counter+completeWord+" ";
			
		}
		return counter;
		
	}

}
