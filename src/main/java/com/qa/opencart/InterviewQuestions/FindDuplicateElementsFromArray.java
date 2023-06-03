package com.qa.opencart.InterviewQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateElementsFromArray {

	public static void main(String[] args) {
		
		String[] arr = {"JAVA","JAVA","JAVASCRIPT","PYTHON","PYTHON","SHELLSCRIPT" , "RUBY" , "RUBY"};
		
		Set<String> duplicateElement = new HashSet<String>();
		List<String> duplicateEle = Arrays.stream(arr).filter(e -> !duplicateElement.add(e)).collect(Collectors.toList());
 
		System.out.println(duplicateEle);
		
		Map<String, Long> occurenceMap = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));
		System.out.println(occurenceMap);
	}

}
