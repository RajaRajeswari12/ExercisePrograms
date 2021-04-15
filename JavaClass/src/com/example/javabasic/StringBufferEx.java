package com.example.javabasic;

public class StringBufferEx {
	
	public static void main(String args[]) {
		StringBuffer sb = new StringBuffer("Welcome to");
		sb.append(" Core Java");
		System.out.println(sb);
		
		sb.insert(20, " Hello");
		System.out.println(sb);
		
	}

}
