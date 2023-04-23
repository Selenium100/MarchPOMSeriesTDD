package com.qa.opencart.InterviewQuestions;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class HigestWord {

	public static void main(String[] args) {
		
		String str = "As Technology & Talent are the biggest enablers of innovation and also the biggest challenges in today’s global economies";
		System.out.println(getHigestWord(str));

	}
	
	public static String getHigestWord(String str) {
		
		String[] eachWords= str.split(" ");
		LinkedHashMap<String, Integer> hm = new LinkedHashMap<String, Integer>();
		
		for(String each:eachWords) {
			
			hm.put(each, each.length());
		}
		
	int maxLength =	 hm.entrySet().stream().mapToInt(e -> e.getValue()).summaryStatistics().getMax();
	
	for(Entry<String, Integer> keyValue:hm.entrySet()) {
		if(keyValue.getValue() == maxLength) {
			return keyValue.getKey();
		}
	}
	return str;
	}

}
