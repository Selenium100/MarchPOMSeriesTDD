package com.qa.opencart.InterviewQuestions;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumber {

	public static void main(String[] args) {
		System.out.println(findPrimeNumbers(10));

	}
	
	public static List<Integer> findPrimeNumbers(int range){
		
		List<Integer> numbers = IntStream.range(0, range).boxed().collect(Collectors.toList());
		
		Predicate<Integer> p = e -> {
			if(e<=1) {
				return false;
			}
			
			for(int i=2;i<=Math.sqrt(e);i++) {
				if(e%i==0) {
					return false;
				}
			}
			return true;
		};
		
		return numbers.stream().filter(p).collect(Collectors.toList());
	}

}
