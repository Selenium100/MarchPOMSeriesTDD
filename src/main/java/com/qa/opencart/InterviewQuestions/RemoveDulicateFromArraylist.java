package com.qa.opencart.InterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDulicateFromArraylist {

	public static void main(String[] args) {
		
		ArrayList<Integer> intList = new ArrayList<Integer>(Arrays.asList(1,1,1,2,2,2,3,3,3,4,4,4));
		
		LinkedHashSet<Integer> uniqueNumbers = new LinkedHashSet<Integer>();
		
		for(Integer each : intList) {
			uniqueNumbers.add(each);
		}
		
		ArrayList<Integer> distinctNumbers = new ArrayList<Integer>(uniqueNumbers);
		System.out.println(distinctNumbers);
		
		System.out.println("---------------------------------------");
		
		
		LinkedHashSet<Integer> uniqueNumbers1 = new LinkedHashSet<Integer>();
		List<Integer> removeDulicate =  intList.stream().filter(e -> uniqueNumbers1.add(e)).collect(Collectors.toList());
		System.out.println(removeDulicate);
		
		
		

	}

}
