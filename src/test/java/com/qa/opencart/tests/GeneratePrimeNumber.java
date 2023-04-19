package com.qa.opencart.tests;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GeneratePrimeNumber {

	public static void main(String[] args) {
		
		
		System.out.println(generatePrime(10));

	}
	
	public static List<Integer> generatePrime(int range){
	List<Integer> numbers =	 IntStream.range(0, range).boxed().collect(Collectors.toList());
	
	Predicate<Integer> isprime = n -> {
		 if(n<=1) {
			 return false;
		 }
		 for(int i=2;i<=Math.sqrt(n);i++) {
			 if(n%i == 0) {
				 return false;
			 }
		 }
		 return true;
	};
	
	
	return numbers.stream().filter(isprime).collect(Collectors.toList());
	
	
	}

}
