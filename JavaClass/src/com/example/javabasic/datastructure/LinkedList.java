package com.example.javabasic.datastructure;

public class LinkedList<T extends Comparable<T>> implements Cloneable {
private Node<T> head = null;
public LinkedList() {
	Node<T> h = head;
	while(h!=null) {
		h = h.getNext();
	}
}
}
