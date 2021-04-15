package com.example.javabasic;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListEx {

	public static void main(String[] args) {
		ArrayList<String> example = new ArrayList<String>();
		example.add("Raji");
		example.add("Koushal");
		example.add("Bhavesh");
		Iterator itr = example.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

}
