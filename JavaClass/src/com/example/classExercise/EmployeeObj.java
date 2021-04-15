package com.example.classExercise;

public class EmployeeObj {

	public static void main(String[] args) {
	Employee employee1 = new Employee();
	Employee employee2 = new Employee(2,"KRKB",90000);
	employee1.setEmployeeDetails(1, "KRKB1", 100000);
	employee1.display();
	employee2.display();
	}

}
