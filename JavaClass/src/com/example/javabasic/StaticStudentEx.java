package com.example.javabasic;

public class StaticStudentEx {

	int rollno;
	String name;
	static String college = "Anna Univ";
	static void change() {
		college = "MIT";
	}
	StaticStudentEx(int rollno,String name){
		this.rollno = rollno;
		this.name = name;
	}
	
	void display() {
		System.out.println("RollNo : "+ rollno+"\nName Of the Student : "+ name+"\nCollege Name: "+college +"\n");
	}


}
