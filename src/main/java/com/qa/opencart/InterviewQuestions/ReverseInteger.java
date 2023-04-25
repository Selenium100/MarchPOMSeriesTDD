package com.qa.opencart.InterviewQuestions;

public class ReverseInteger {

	public static void main(String[] args) {
		
		int num = 45678;
		
		String myNum = String.valueOf(num);
		
		StringBuilder sf = new StringBuilder(myNum);
		sf.reverse();
		System.out.println(sf);
		
		int rev = Integer.parseInt(sf.toString());
		System.out.println(rev);

	}

}
