package com.example.javabasic;

import java.util.HashSet;
import java.util.Set;

public class Hset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> hash = new HashSet<String>();
		hash.add("LG");
		hash.add("Samsung");
		hash.add("Lenova");
		
		hash.add("LG");
		hash.add("ALG");
		hash.add("Samsung1");
		
		hash.add(null);
		
		System.out.println(hash);
	}

}
