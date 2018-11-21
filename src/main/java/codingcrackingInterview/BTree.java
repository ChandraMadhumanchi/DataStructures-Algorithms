package codingcrackingInterview;

import java.util.Stack;

class Node {
	Node left, right;
	int data;

	public Node(int data) {
		this.data = data;
	}
}

public class BTree {

	Node root;

	BTree() {
		root = null;
	}

	void inorder() {
		// <Left Subtree> <Root> <Right Subtree>
		if (root == null)
			return;

		Stack<Node> s = new Stack<Node>();
		Node curr = root;

		// traverse the tree
		while (curr != null || s.size() > 0) {
			// reach the left most node of the current node
			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}

			curr = s.pop();
			System.out.print(curr.data + " ");

			curr = curr.right;
		}
	}
	
	void preorder() {
		// <Root> <Left Subtree>  <Right Subtree>
		if (root == null)
			return;

		Stack<Node> s = new Stack<Node>();
		s.push(root);
		/*
		 *  Pop all items one by one. Do following for every popped item
		 *  print it
		 *  push it's right child
		 *  push it's left child
		 *  Note that right child is pushed firt so that left is process first 
		 */
		while (s.isEmpty() == false) {
			// Pop the top item from stack and print it
			Node curr = s.pop();
			System.out.print(curr.data + " ");

			// Push right and left children
			if(curr.right != null){
				s.push(curr.right);
			}
			
			if(curr.left != null) {
				s.push(curr.left);
			}
				
			
		}
	}


	void postorder() {
		// <Root> <Left Subtree>  <Right Subtree>
		if (root == null)
			return;

		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		
		// push root to first stack is not emptry
		s1.push(root);
		
		// Run while first stack is not empty
		while (!s1.isEmpty()) {
			// Pop the top item from stack and print it
			Node curr = s1.pop();
			s2.push(curr);

			// Push left and right children
			
			if(curr.left != null) {
				s1.push(curr.left);
			}
				
			if(curr.right != null){
				s1.push(curr.right);
			}
			
		}
		
		while(!s2.isEmpty()){
			Node temp = s2.pop();
			System.out.print(" "+ temp.data);
		}
	}


	
	public static void main(String[] args) {

		BTree tree = new BTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inorder();
        System.out.println();
        tree.preorder();
        System.out.println();
        tree.postorder();
	}

}
