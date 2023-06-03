package com.qa.opencart.InterviewQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Test1 {

	public static void main(String[] args) {
		
		HashMap<Integer, Character> h1 = new HashMap<Integer, Character>();
		h1.put(4, 'B');
		h1.put(2, 'A');
		h1.put(5, 'D');
		h1.put(6, 'C');
		
		LinkedHashMap<Integer, Character> sortedMap = h1.entrySet().stream().sorted((k,v) -> k.getValue().compareTo(v.getValue())).collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1,e2) ->e2, LinkedHashMap::new));
		System.out.println(sortedMap);

	}

}
