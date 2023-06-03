package com.qa.opencart.InterviewQuestions;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test10 {

	public static void main(String[] args) {
		
		
		System.out.println(generatePrimeNumber(10));

	}

	private static List<Integer> generatePrimeNumber(int range) {
		
		List<Integer> intList = IntStream.range(0, 11).boxed().collect(Collectors.toList());
		
		Predicate<Integer> isPrime = n ->{
			if(n<=1) {
				return false;
			}
			for(int i=2;i<Math.sqrt(n);i++) {
				return false;
			}
			
			return true;
			
		};
		
		return intList.stream().filter(isPrime).collect(Collectors.toList());
		
	}

}
