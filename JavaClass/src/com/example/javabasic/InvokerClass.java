package com.example.javabasic;

import java.util.Arrays;
import java.util.List;
import java.lang.Object;

public class InvokerClass {

	public static void main(String[] args) {
		child child1 = new child(9);
		child child2 = new child(10);
		child child3 = new child(4);
		child child4 = new child(12);
		child child5 = new child(13);
		child child6 = new child(8);
		child child7 = new child(9);
		child child8 = new child(11);
		child child9 = new child(2);
		child child10 = new child(1);
		child child11 = new child(3);
		child child12 = new child(01);
		
		List<child> childs = Arrays.asList(child1,child2,child3,child4,child5,child6,child7,child8,child9,child10);
		List<child> filtered = ChildPredicate.filterChilds(childs, ChildPredicate.filterByAge(7));
		
		for(child c: filtered) {
			System.out.println(c.getAge());
		}
	}

}
