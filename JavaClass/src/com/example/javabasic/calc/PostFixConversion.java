package com.example.javabasic.calc;

import java.util.Stack;

public class PostFixConversion {

	Stack<String> postFix = new Stack<String>();
	char[] splitExp;

	Stack<String> postFixConversion(String expression){
		splitExp = expression.toCharArray();	

		for(int i=0;i<splitExp.length;i++) {
			char value = splitExp[i];
			if(!Character.isDigit(value)) {
				i = operationSwitch(value, i);
			}else if(i != splitExp.length -1){
				i = toAddNumbers(i);
			}
		}
		return postFix;
	}

	int operationSwitch(char value, int index) {		
		switch(value) {
		case '+':
			index= plusMinusOperator(index);
			postFix.push("+");
			break;

		case '-':
			index = plusMinusOperator(index);
			postFix.push("-");
			break;						

		case '*':
			index = multiplicationDivisionOperator(index);
			postFix.push("*");
			break;

		case '/':
			index = multiplicationDivisionOperator(index);
			postFix.push("/");

			break;
		case '(':
			index = withInBracket(index);
			break;
		}		
		return index;
	}

	int plusMinusOperator(int i) {
		char value = splitExp[i];
		if((i < splitExp.length-1)&&(i != -1)) { 
			if(Character.isDigit(splitExp[i+1])) {
				i = toAddNumbers(i+1);
			}else {
				value = splitExp[i+1];	
				++i;
				i = operationSwitch(value, i);
			}

		}else {
			i = splitExp.length;
		}
		return i;
	}

	int multiplicationDivisionOperator(int indexVal) {

		if(Character.isDigit(splitExp[indexVal+1])) {
			indexVal = toAddNumbers(indexVal+1);
		}else if((indexVal < splitExp.length-1)&&(indexVal != -1) && (splitExp[indexVal+1] == '(')){
			indexVal = withInBracket(indexVal+1);
		}
		return indexVal;
	}



	int withInBracket(int index) {
		if(index < splitExp.length-1) {
			char value = splitExp[index];
			while(value != ')') {
				index++;
				if(index < splitExp.length-1) {
					if( Character.isDigit(splitExp[index])) {
						index = toAddNumbers(index);
					}
					value = splitExp[index];	
					index = operationSwitch(value, index);
				}else {
					return index;
				}			

			}	
		}
		return index;
	}

	int toAddNumbers(int inderNo) {
		String numberConcat = "";
		int len = splitExp.length -1;
		if(inderNo <= len) {
			char value = splitExp[inderNo];			
			while(Character.isDigit(value)) {
				numberConcat += String.valueOf(value);
				if(inderNo < len) {
					++inderNo;
					value = splitExp[inderNo];
				}else if(inderNo == len) {
					postFix.push(numberConcat);
					return inderNo;
				}
			}
			postFix.push(numberConcat);
			inderNo = inderNo-1;
		}
		return inderNo;
	}	
}
