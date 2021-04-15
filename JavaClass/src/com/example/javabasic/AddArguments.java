package com.example.javabasic;

public class AddArguments {
public static void main(String args[]) {
	try {
	int sum = 0;
	for(int i = 0;i<args.length;i++) {
		sum += Integer.parseInt(args[i]);
	}
	
	System.out.println("sum = "+sum);
	int errorCreation = sum/0;
	}catch(NumberFormatException nfe) {
		System.err.println("Enter Numbers only");
	}catch(ArithmeticException ae) {
		System.err.println("Error :"+ae.getMessage());
	}
}
}
