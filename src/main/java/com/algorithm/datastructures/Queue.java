package com.algorithm.datastructures;

public class Queue {


	public static class Node {
		
		private int data;
		private Node next;
		private Node(int data){
			this.data = data;
		}
	}
	
	private Node head;  // remove from the head
	private Node tail;	// add things here
	
	// Head -> O - O - O - O -Tail
	
	public boolean isEmpty(){
		return head == null;
	}
	public int peek() {
		return head.data;
	}	
	public void add(int data) {
		
		Node node = new Node(data);
		
		if(tail != null){
			tail.next = node;
		}
		tail = node;
		if(head == null){
			head = node;
		}
	}
	public int remove() {
		
		int data = head.data;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		return data;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
