package com.example.javabasic;

public class VotingAgeValidation {

	void validate(int age) throws InvalidAgeException{
		if(age < 18) {
			throw new InvalidAgeException("Not a Valid age to vote.Come again after "+(18-age) + " years");
		}else {
			System.out.println("Welcome to vote");
		}
	}
	
	public static void main(String[] args) {
	VotingAgeValidation person1 = new VotingAgeValidation();
	try {
		person1.validate(12);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Exception occurred "+ e);
	}
	finally {
	System.out.println("Finally block executed");
	}
	
	System.out.println("Code executed");

	}

}
