package com.qa.opencart.InterviewQuestions;

public class Test8 {

	public static void main(String[] args) {
		
		String str = "nitya ranjan behera"; //output Nitya Ranjan Behera
		
		
		System.out.println(capitalize(str));
		

	}

	private static String capitalize(String str) {
		
		String[] eachWord = str.split(" ");
		
		String counter = "";
		for(String each : eachWord) {
			String firstLetter = each.substring(0,1).toUpperCase();
			String otherLetters = each.substring(1,each.length());
			
			String totalString = firstLetter+otherLetters;
			counter = counter+totalString+" ";
			
		}
		return counter;
		
		
		
		
	}

}
