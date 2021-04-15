package com.example.classExercise;

public class Employee {

	int id;
	String name;
	double salary;
//	Employee(){}
	Employee(int id,String name,double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	void setEmployeeDetails(int id,String name,double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	void display() {
		System.out.println("Employee id :" + id + "\nEmployee Name : " + name+ "\nSalary :"+salary +"\n");
	}
}
