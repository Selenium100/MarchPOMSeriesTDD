package com.qa.opencart.InterviewQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CompareHashMap {

	public static void main(String[] args) {

      HashMap<Integer, String> h1 = new HashMap<Integer, String>();
      h1.put(1, "A");
      h1.put(2, "B");
      h1.put(3, "C");
      h1.put(4, "D");
      h1.put(5, "E");
      h1.put(6, "F");
      
      HashMap<Integer, String> h2 = new HashMap<Integer, String>();
      
      h2.put(1, "B");
      h2.put(2, "A");
      h2.put(3, "C");
      h2.put(4, "E");
      h2.put(5, "D");
      
     
      
      //IDENTIFY THE EXTRA KEY.
      
     HashSet<Integer> combineSet = new HashSet<Integer>(h1.keySet());
     
     combineSet.addAll(h2.keySet());
     
     System.out.println(combineSet);
      
     combineSet.removeAll(h2.keySet());
     
     System.out.println(combineSet);

	}

}
