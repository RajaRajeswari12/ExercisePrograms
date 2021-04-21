package com.example.javabasic;

public class ThreadTester {

	public static void main(String[] args) {
HelloRunner h  = new HelloRunner();
Thread t = new Thread(h);
t.start();
	}

}
