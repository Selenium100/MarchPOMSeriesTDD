package com.qa.opencart.InterviewQuestions;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		String str = "NITYA";
		
		char[] eachChar= str.toCharArray();
		
		
		LinkedHashMap<Character, Integer> hm = new LinkedHashMap<Character, Integer>();
		
		for(Character each : eachChar) {
			
			if(hm.get(each)==null) {
				hm.put(each, 1);
			}else {
				hm.put(each, hm.get(each)+1);
			}
			
			
		}

	}
	
	


}
