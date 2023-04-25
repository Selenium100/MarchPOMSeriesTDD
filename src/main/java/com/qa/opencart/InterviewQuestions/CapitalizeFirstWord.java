package com.qa.opencart.InterviewQuestions;

public class CapitalizeFirstWord {

	public static String capitalized(String str) {

		String[] words = str.split(" ");

		String counter = "";

		for (String each : words) {
			String firstWord = each.substring(0, 1).toUpperCase();
			String restWords = each.substring(1, each.length());

			String totalWord = firstWord + restWords;

			counter = counter + totalWord ;

		}
		return counter;

	}

	public static void main(String[] args) {

		String str = "naveen automation labs"; // NaveenAutomationLabs

		System.out.println(capitalized(str));

	}

}
