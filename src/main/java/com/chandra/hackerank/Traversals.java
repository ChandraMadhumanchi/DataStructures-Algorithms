package com.chandra.hackerank;

/*
 * 
 * preOreder => root => leftSubTree => rightSubTree 
 * inOreder  => leftSubTree => root => rightSubTree
 * postOreder=> leftSubTree =>  rightSubTree => root
 * */
 
import java.util.Stack;

public class Traversals {

	Node root;
	
	void preOreder()
    {
		preOreder(root);
    }
	
	void inOreder(){
		inOreder(root);
	}

	void postOreder() {
		postOreder(root);
	}
	
	public static void main(String[] args) {
		Traversals tree = new Traversals();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);
        tree.preOreder();
        System.out.println("");
        tree.inOreder();
        System.out.println("");
        tree.postOreder();
	}
	
	public static void postOreder(Node root){
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		
		if(root == null)
			return;
		
		// push root to first stack
		s1.push(root);
		// Run while first stack is not empty
		while( !s1.isEmpty()){
			//Pop an item from s1 and push it s2
			Node temp = s1.pop();
			s2.push(temp);
			
			// push left and right children of removed item to s1
			if(temp.left != null)
				s1.push(temp.left);
			if(temp.right != null)
				s1.push(temp.right);
		}
		
		// Print all elements of second stack
		while( !s2.isEmpty()){
			Node n = s2.pop();
			System.out.print(" "+ n.data);
		}
	}

	public static void preOreder(Node root){
		
		if(root == null) return;
		Stack<Node> s = new Stack<Node>();
		
		s.push(root);
		while(! s.empty()){
			
			Node n = s.pop();
			System.out.print(" "+ n.data);
			
			if(n.right != null){
				s.push(n.right);
			}
			
			if(n.left != null){
				s.push(n.left);
			}
			
		}
	}
	
	public static void inOreder(Node root){
		
		/*
		 *  1) Create an empty stack S.
			2) Initialize current node as root
			3) Push the current node to S and set current = current->left until current is NULL
			4) If current is NULL and stack is not empty then 
     			a) Pop the top item from stack.
     			b) Print the popped item, set current = popped_item->right 
     			c) Go to step 3.
			5) If current is NULL and stack is empty then we are done.
		 * 
		 */
		
		if(root == null) return;
		Stack<Node> s = new Stack<Node>();
		
		Node current = root;
		
		// traverse the tree
		while( current !=null || s.size() > 0){
			
			/* Reach the left most Node of the
            curr Node */
			
			while( current != null){
				s.push(current);
				current = current.left;
			}
			
			/* Current must be NULL at this point */
			current = s.pop();
			System.out.print(" "+current.data );
			
			
			/* we have visited the node and its
            left subtree.  Now, it's right
            subtree's turn */
			current = current.right;
		}
	}
}

class Node {
	int data;
	Node left,right;
	
	public Node(int value){
		data = value;
		left = right = null;
	}
}
