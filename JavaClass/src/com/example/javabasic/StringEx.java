package com.example.javabasic;
import java.util.Spliterators;
import java.util.regex.*;
public class StringEx {

	boolean stringMatches;

	boolean stringMatch(String sentence,String word) {
		if(sentence.matches("(.*)"+word+"(.*)")) {
			stringMatches = true;
		}else {
			stringMatches = false;
		}


		return stringMatches;
	}

	String[] splitString(String sentenceToSplit) {
		String[] splitedString ;
		splitedString = sentenceToSplit.split("\\s");


		return splitedString;
	}
	
	
	public static void main(String args[]) {

		//Concat Method 
		String empNm = "Java String Matches method d";
		String updateEmpNm = empNm.concat(".K");
		System.out.println("The Employee Name is "+updateEmpNm);

		//Matches Method
		StringEx test = new StringEx();
		String inputSentence = "Java String Matches method check .";
		System.out.println("Output value is "+	test.stringMatch(inputSentence, "string"));

		//CompareTo Method
		System.out.println(empNm.compareTo(inputSentence) );

		//Split method
		String[] splitedString = test.splitString(inputSentence);

		for(String value:splitedString){
			System.out.println(value);
		}
		
		
		//toCharArray
		
		char[] testArr = inputSentence.toCharArray();
		for(char i:testArr) {
			System.out.println(i);
		}
	}
}
