package com.example.javabasic.calc;

import java.util.Stack;

public class PostFixConversion {

	Stack<String> postFix = new Stack<String>();
	char[] splitExp;

	Stack<String> postFixConversion(String expression){

		splitExp = expression.toCharArray();	
		System.out.println(splitExp.length);
		for(int i=0;i<splitExp.length;i++) {
			char value = splitExp[i];


			if(!Character.isDigit(value)) {
				switch(value) {
				case '+':
				{
					i= plusOperator(i);
					break;
				}
				case '-':
				{
					i = minusOperator(i);
					break;						
				}

				case '*':
					i = multiplicationOperator(i);
					break;
				case '/':
					i = DivisionOperator(i);

					break;
				case '(':
				{
					i = withInBracket(i);
					break;
				}
				}
			}else if(i != splitExp.length -1){

				i = toAddNumbers(i);

			}



		}
		return postFix;
	}

	int plusOperator(int i) {
		char value = splitExp[i];
		if(Character.isDigit(splitExp[i+1])) {
			i = toAddNumbers(i+1);
		}
		if((i < splitExp.length-1)&&(i != -1)) { 

			value = splitExp[i+1];	
			++i;
			switch(value){
			case '*':				
			{
				i = toAddNumbers(i+1);
				postFix.push("*");
				postFix.push("+");
				break;
			}
			case '/':		{
				i = toAddNumbers(i+1);
				postFix.push("/");
				postFix.push("+");
				break;
			}
			case '(':
			{
				i = withInBracket(i);
				postFix.push("+");
				break;
			}
			default:
				postFix.push("+");
				i = toAddNumbers(i+1);
				
				break;
			}

		}else {
			i = splitExp.length;
			postFix.push("+");

		}

		return i;
	}
	int minusOperator(int i) {
		char value = splitExp[i];

		if(Character.isDigit(splitExp[i+1])) {
			i = toAddNumbers(i+1);
		}
		System.out.println("i and value "+ i +">>>>>>>>>>"+value);
		if((i < splitExp.length-1)&&(i != -1)) { 
			value = splitExp[i+1];	
			++i;	
			switch(value){

			case '*':			
			{
				i = toAddNumbers(i+1);
				postFix.push("*");
				postFix.push("-");
				break;
			}
			case '/':		{
				i = toAddNumbers(i+1);
				postFix.push("/");
				postFix.push("-");
				break;
			}
			case '(':
			{
				i = withInBracket(i);
				postFix.push("-");
				break;
			}
			default:
				i = toAddNumbers(i+1);
				postFix.push("-");
				break;

			}
		}else {
			i = splitExp.length;
			postFix.push("-");
		}
		return i;
	}

	int multiplicationOperator(int indexVal) {
		char value = splitExp[indexVal];

		if(Character.isDigit(splitExp[indexVal+1])) {
			indexVal = toAddNumbers(indexVal+1);
			System.out.println(" value inside **** "+value);
			postFix.push(String.valueOf(value));
		}else if(splitExp[indexVal+1] == '('){

			indexVal = withInBracket(indexVal+1);
			postFix.push("*");
		}
		return indexVal;
	}

	int DivisionOperator(int indexVal) {
		char value = splitExp[indexVal];

		if(Character.isDigit(splitExp[indexVal+1])) {
			indexVal = toAddNumbers(indexVal+1);
			postFix.push(String.valueOf(value));
		}else if(splitExp[indexVal+1] == '('){

			indexVal = withInBracket(indexVal+1);
			postFix.push("/");
		}
		return indexVal;
	}
	
	
	int withInBracket(int index) {
		char value = splitExp[index];

		while(value != ')') {
			index++;

			if(index < splitExp.length-1) {
				if( Character.isDigit(splitExp[index])) {
					index = toAddNumbers(index);
				}
				value = splitExp[index];	
				switch(value) {
				case '+':
				{
					index= plusOperator(index);
					break;
				}
				case '-':
				{
					index = minusOperator(index);
					break;						
				}
				case '*':{
					index = multiplicationOperator(index);
					break;
				}
				case '/':{
					index = DivisionOperator(index);
					break;
				}
				case '(':
				{
					index = withInBracket(index);
					break;
				}

				}
			}else {
				return index;

			}
			
		}

	;
		return index;
	}

	int toAddNumbers(int inderNo) {
		String numberConcat = "";
		char value = splitExp[inderNo];
		int len = splitExp.length -1;

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

		return inderNo;
	}


	
}
