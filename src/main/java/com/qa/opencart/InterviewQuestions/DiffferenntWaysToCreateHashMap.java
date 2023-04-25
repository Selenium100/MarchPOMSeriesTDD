package com.qa.opencart.InterviewQuestions;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DiffferenntWaysToCreateHashMap {
	
	public static HashMap<Integer, String> hm;
	static {
		hm = new HashMap<>();
		hm.put(1, "Nitya");
		hm.put(2, "Abhay");
		hm.put(3, "Viswa");
		hm.put(4, "Chiku");
	}

	public static void main(String[] args) {
		
		//1. with new keywork
		
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "Nitya");
		hm.put(2, "Abhay");
		hm.put(3, "Chiku");
		hm.put(4, "Viswa");
		
		//2. using static block
		
		System.out.println(DiffferenntWaysToCreateHashMap.hm.get(1));
		
		//3. Immutable map with only single entry
		Map<Integer, String> map1 = Collections.singletonMap(1, "Nitya");
		System.out.println(map1.get(1));
		//map1.put(2, "Abhay");//UnsupportedOperationException
		
		//4. Stream.of and abstractmap.simpleentry
		
	Map<String, String> comMap = Stream.of(new AbstractMap.SimpleEntry<>("Nitya","Accenture"),new AbstractMap.SimpleEntry<>("Abhay","Cognizant")).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
		System.out.println(comMap.get("Nitya"));
		
		
		
		

	}

}
