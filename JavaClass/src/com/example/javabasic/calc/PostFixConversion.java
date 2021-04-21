package com.example.javabasic.calc;

import java.util.Stack;

public class PostFixConversion {

	Stack<String> postFix = new Stack<String>();
	char[] splitExp;
	int expLength ;
	char currOperator;
	char prevOperator;
	
	
	public void setCurrOperator(char currOperator) {
		this.currOperator = currOperator;
	}

	public void setPrevOperator(char prevOperator) {
		this.prevOperator = prevOperator;
	}

	Stack<String> postFixConversion(String expression){
		splitExp = expression.toCharArray();	
		expLength = splitExp.length -1;
		for(int i=0;i<=expLength ;i++) {
			char value = splitExp[i];
			if(!Character.isDigit(value)) {
				
				i = operationSwitch(value, i);
			}else if(i != expLength){
				i = toAddNumbers(i);
			}
		}
		return postFix;
	}

	int operationSwitch(char value, int index) {	

		switch(value) {
		case '+':
			if(currOperator == '+' && prevOperator == '-') {
				postFix.push("-");
				index= plusMinusOperator(index);

			}else {
				index= plusMinusOperator(index);				
			}

			if(prevOperator != '-') {
				postFix.push("+");
			}

			break;

		case '-':
			if(prevOperator == '+' && currOperator == '-') {
				postFix.push("+");
				index= plusMinusOperator(index);

			}else {
				index = plusMinusOperator(index);

			}

			if(prevOperator != '+') {
				postFix.push("-");
			}
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
			int prevIndex = index;
			index = withInBracket(index);
			if(prevIndex != 0 && (Character.isDigit(splitExp[prevIndex-1]) || splitExp[prevIndex-1] == ')')) {
				postFix.push("*");
			}
			break;
		}		
		return index;
	}


	int plusMinusOperator(int index) {
		setPrevOperator(splitExp[index]);

		if(index < expLength) { 
			if(Character.isDigit(splitExp[index+1])) {
				index = toAddNumbers(index+1);
			}
			++index;
			if(index < expLength) {
				char value = splitExp[index];	
				setCurrOperator(splitExp[index]);
				index = operationSwitch(value, index);
			}
		}
		return index;
	}

	int multiplicationDivisionOperator(int indexVal) {
		
		if(Character.isDigit(splitExp[indexVal+1])) {
			indexVal = toAddNumbers(indexVal+1);
		}else if((indexVal < expLength) && (splitExp[indexVal+1] == '(')){
			indexVal = withInBracket(indexVal+1);
		}
		return indexVal;
	}



	int withInBracket(int index) {
		if(index < expLength) {
			char value = splitExp[index];
			while(value != ')') {
				index++;
				if(index < expLength) {
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
		if(inderNo <= expLength) {
			char value = splitExp[inderNo];			
			while(Character.isDigit(value)) {
				numberConcat += String.valueOf(value);
				if(inderNo < expLength) {
					++inderNo;
					value = splitExp[inderNo];
				}else if(inderNo == expLength) {
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
