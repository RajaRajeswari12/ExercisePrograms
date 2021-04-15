package com.example.javabasic.calc;

import java.util.Scanner;
import java.util.Stack;

public class Calculator {



	double calculateExp(String expression) {
		double finalValue = 0;
		Stack<String> postFixExp = new Stack<String>();
		PostFixConversion pf = new PostFixConversion();
		postFixExp = pf.postFixConversion(expression);
		while(!postFixExp.isEmpty()) {
			System.out.println("inside CAlc"+postFixExp.pop());
		}
		System.out.println(postFixExp);
		return finalValue;
	}

	public static void main(String[] args) {
		boolean validData = false;

		Scanner inputReader = new Scanner(System.in);
		System.out.println("Enter the Arthmetic Expression to be calculated");
		while(!validData) {
			String expression = inputReader.next();
			Calculator c = new Calculator();
			Validation validTest = new Validation();
			
			boolean validExp = validTest.validExpression(expression);
			if(validExp) {
				
				c.calculateExp(expression);
				validData = true;
			}else {
				System.out.println("Enter valid Expression to be Calculated: (Allows numbers,+,*,-,/,(,))");
			}
		}


	}

}
