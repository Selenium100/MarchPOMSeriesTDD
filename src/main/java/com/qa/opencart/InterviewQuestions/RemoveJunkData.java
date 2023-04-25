package com.qa.opencart.InterviewQuestions;

public class RemoveJunkData {

	public static void main(String[] args) {
		
		String str = "#$#@# nitya #$@#^% ranjan %$#$%^ behera" ; //nitya ranjan behera
		str = str.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(str);

	}

}
