package com.rajendra;

public class LinkedList {

	Node head;
	
	public LinkedList(){
		head = null;
	}
	
	public void add(int data){
		
		Node n = new Node(data);
		
		if (head == null){
				head = n;
				return; 
		}
		
		n.next = head;
		head = n;
		
		
	}
	
 public void display(){
	 
	 Node tnode = head; 
     while (tnode != null) 
     { 
         System.out.print(tnode.data+" "); 
         tnode = tnode.next; 
     } 
 }
 
public void delete(int position){
	
	// If linked list is empty 
    if (head == null) 
        return; 

    // Store head node 
    Node temp = head; 

    // If head needs to be removed 
    if (temp.data == position) 
    { 
        head = temp.next;   // Change head 
        return; 
    } 

    while(temp.next != null && temp.next.data == position){
    	temp = temp.next;
    }

    // If position is more than number of ndoes 
    if (temp == null || temp.next == null) 
        return; 

    // Node temp->next is the node to be deleted 
    // Store pointer to the next of node to be deleted 
    Node next = temp.next.next; 

    temp.next = next;  // Unlink the deleted node from list
 }
	
	public static void main(String[] args) {

		LinkedList l = new LinkedList();
		l.add(2);
		l.add(5);
		l.add(6);
		 
		System.out.println("Before");
		
		System.out.println("");
		
		l.display();
		
		l.delete(5);
		System.out.println("");
		
		System.out.println("after");
	    l.display();	
	}

}

class Node {
	int data;
	Node next;
	
	public Node(int data){
		this.data = data;
		next = null;
	}
}
