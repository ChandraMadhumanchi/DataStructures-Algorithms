package com.algorithm.datastructures;


public class LinkedList {

	Node head;  // Head of list
	
	// add a new node at front of the list
	public void push(int data){
		
		Node newNode = new Node(data); // construct a new node
		
		newNode.next = head;  // make next of new node as head
		
		head = newNode; // move the head to point to new Node
	}
	
	// Checks whether the value data is present in the list
	public boolean search (Node pointer,int key){
		
		Node current = head;   // Intialize current
		
		while(current != null){
			if(current.data == key)
				return true;  // data found
			current = current.next;
		}
		return false;
	}
	
	public void append(int data){
		
		if( head == null){
			head = new Node(data);
			return;
		}
		Node current = head;
		while(current.next != null){
			current = current.next;
		}
		current.next = new Node(data);
	}
	
	public void prepend(int data){
		
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
	}
	
	public void deleteWithValue(int data){
		
		if(head == null) return;
		
		if(head.data == data){
			head = head.next;
			return;
		}
		
		Node current = head;
		while(current.next != null){
			
			if(current.next.data == data) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
	
	public void display(Node head){
		Node current = head;
		
		while(current != null){
			System.out.print("->" + current.data);
			current = current.next;
		}
	}
	
	public static void main(String[] args) {

		// start with the empty list
		LinkedList lst = new LinkedList();
		
		// Use push to construct the below list
		
		//14->21->11-11->30->10
		lst.push(10);
		lst.push(30);
		lst.push(11);
		lst.push(21);
		lst.push(14);
		
		if (lst.search(lst.head, 21))
			System.out.println("Found");
		else
			System.out.println("Not Found");
		
		lst.display(lst.head);
	}
  
	class Node {
		
		int data;
		Node next;
		
		public Node (int data){
			
			this.data = data;
			next = null;
		}
	}
}
