package com.example.variable;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VariableExample {
	public double radius = 0;
	static double pie = 3.14;



	double areaOfCircle(double radius) {
		double result;
		result = pie * radius * radius;
		return result;
	}
	public static void main(String[] args) {

		VariableExample Ex = new VariableExample();

		double areaValue =0;
		boolean getCorrectValue = false;
		while(!getCorrectValue) {
			Scanner sc= new Scanner(System.in); 
			System.out.println("Enter the value of the Circle Radius : ");
			try {
				Ex.radius= sc.nextDouble();

				areaValue = Ex.areaOfCircle(Ex.radius);
				getCorrectValue = true;
			}
			catch (InputMismatchException e) {
				System.out.println("Please enter the radius value in numbers Ex: 23, 34.5. Special characters and alphabets are not valid. ");
//				break outer;
			}
		}

		System.out.println("Area Of th Circle is "+ areaValue);
	}



}
