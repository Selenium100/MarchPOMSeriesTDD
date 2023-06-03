package com.qa.opencart.InterviewQuestions;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Test5 {

	public static void main(String[] args) {

		String str = "Nitya is a good boy";

		char[] eachChar = str.toCharArray();

		LinkedHashMap<Character, Integer> hm = new LinkedHashMap<Character, Integer>();
		for (Character each : eachChar) {
			if (hm.get(each) == null) {
				hm.put(each, 1);
			} else {
				hm.put(each, hm.get(each) + 1);
			}
		}

		Map<Character, Integer> sortedMap = hm.entrySet().stream()
				.sorted((a, b) -> a.getValue().compareTo(b.getValue()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2));
		System.out.println(sortedMap);
	}

}
