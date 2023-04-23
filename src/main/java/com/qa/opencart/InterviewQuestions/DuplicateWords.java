package com.qa.opencart.InterviewQuestions;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;



public class DuplicateWords {

	public static void main(String[] args) {
		
		String str = "I LOVE LOVE INDIA INDIA INDIA";
		

	}

	public static Map<String, Long> getNumberOfWords(String str) {

		String[] eachWords = str.split(" ");

		Map<String, Long> wordsCountMap = Arrays.asList(eachWords).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		return wordsCountMap;
		
		
	}

}
