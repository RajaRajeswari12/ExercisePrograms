package com.example.javabasic;

class Student5{
	int id;
	String name;
	int age;
	Student5(int i,String n){
		id = i;
		name = n;
	}
	Student5(int i,String n,int a){
		id = i;
		name = n;
		age=a;
	}
	public Student5() {
		// TODO Auto-generated constructor stub
	}
	void setValue(int i,String n,int a){
		id = i;
		name = n;
		age=a;
	}
	void display(){System.out.println(id+" "+name+" "+age);}

	public static void main(String args[]){
		Student5 s1 = new Student5(111,"Karan");
		Student5 s2 = new Student5(222,"Aryan",25);
		Student5 s3 = new Student5();
		s3.setValue(222,"Aryan",25);
		s1.display();
		s2.display();
		s3.display();
	}
}