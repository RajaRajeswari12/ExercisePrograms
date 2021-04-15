package com.example.javabasic.calc;



public class Validation {
	boolean validExpression(String expression) {
		boolean validExp =false;
		if(expression.matches("(((\\()*([0-9]+[\\+\\-\\*\\/]{1}[0-9]+)*(\\))*)+([\\+\\-\\*\\/]{1}\\(*[0-9]+)*(\\(*[0-9]+\\)*)*([\\+\\-\\*\\/]{1}[0-9]+)*(\\))*)*")) {
			validExp = true;
		}

		return validExp;

	}	

}
