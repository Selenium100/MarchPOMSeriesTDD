package com.qa.opencart.InterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class HigestWordsStringInSentence {

	public static void main(String[] args) {
		
	
	String str = "The company is structured around two areas: its global distribution system and its Information Technology business";
	
	String[] eachWords = str.split(" ");
	
	LinkedHashMap<String, Integer> hm = new LinkedHashMap<String, Integer>();
	
	for(String each:eachWords) {
		hm.put(each, each.length());
	}
	
	int val = hm.entrySet().stream().mapToInt(e -> e.getValue()).summaryStatistics().getMax();
	
	

  for(Entry<String, Integer> keyValue: hm.entrySet()) {
	  if(keyValue.getValue() == val) {
		  System.out.println(keyValue.getKey());
	  }
	  
  }
		
		
}
}
