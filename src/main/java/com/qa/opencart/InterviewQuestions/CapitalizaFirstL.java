package com.qa.opencart.InterviewQuestions;

public class CapitalizaFirstL {

	public static void main(String[] args) {

      String str = "nitya ranjan behera";
      
      System.out.println(capitalize(str));

	}

	private static String capitalize(String str) {
		
		String[] words = str.split(" ");
		
		String completeWord="";
		for(String each : words) {
			String firstLetter = each.substring(0,1).toUpperCase();
			String remainingWords = each.substring(1,each.length());
			
			String fullWord = firstLetter+remainingWords+" ";
			completeWord = completeWord+fullWord;
		}
		return completeWord;
		
	}

}
