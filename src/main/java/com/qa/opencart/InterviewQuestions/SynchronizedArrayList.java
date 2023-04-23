package com.qa.opencart.InterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynchronizedArrayList {

	public static void main(String[] args) {

     List<String> nameList = Collections.synchronizedList(new ArrayList<String>());
     nameList.add("Nitya");
     nameList.add("Abhay");
     nameList.add("Rakesh");
     nameList.add("Sandeep");
     
     synchronized (nameList) {
    	 for(String names:nameList) {
        	 System.out.println(names);
         }
	}
     
     System.out.println("-----------------------------------");
     
     //2 . copyOnWriteArrayList
     
     CopyOnWriteArrayList<String> nameListWithCopyInWrite = new CopyOnWriteArrayList<String>();
     nameListWithCopyInWrite.add("Nitya");
     nameListWithCopyInWrite.add("Abhay");
     nameListWithCopyInWrite.add("Pathan");
     nameListWithCopyInWrite.add("Bhaizaan");
     
     for (String each : nameListWithCopyInWrite) {
    	 System.out.println(each);
     }

	}

}
