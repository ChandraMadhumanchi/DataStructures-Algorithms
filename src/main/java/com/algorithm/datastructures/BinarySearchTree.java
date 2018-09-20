package com.algorithm.datastructures;

import java.util.Stack;

public class BinarySearchTree {

	Node root;

	public BinarySearchTree() {
		root = null;
	}

	public void insertNonRecursive(int data) {

		Node newNode = new Node(data);

		if (root == null) {
			root = newNode;
			return;
		}

		Node current = root;
		Node parent = null;

		while (true) {
			parent = current;
			if (data < current.data) {

				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return;
				}
			} else {

				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return;
				}
			}
		}
	}

	public void printPostorder(Node node) {

		if (node == null)
			return;

		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.data + " ");
	}

	public void printInorder(Node node) {

		if (node == null)
			return;

		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);

	}

	public void printPreorder(Node node) {

		if (node == null)
			return;

		System.out.print(node.data + " ");
		printInorder(node.left);
		printInorder(node.right);

	}

	// Wrappers over above recursive functions
	void printPostorder() {
		printPostorder(root);
	}

	void printInorder() {
		printInorder(root);
	}

	void printPreorder() {
		printPreorder(root);
	}

	// Wrappers over above recursive functions
		void printPostorderNON() {
			postOrderNONRec(root);
		}

		public void postOrderNONRec(Node node) {
			if(root == null) return;
			
			Stack<Node> s = new Stack<Node>();
			Stack<Node> r = new Stack<Node>();
			
			s.push(root);
			while(! s.isEmpty()){
				
				Node n = s.pop();
				r.push(n);
				
				if(n.left != null){
					s.push(n.left);
				}
				
				if(n.right != null){
					s.push(n.right);
				}
				
			}
			while(!r.isEmpty()){
				Node p = r.pop();
				System.out.print(" "+ p.data);
			}
			
		}


	
	
	public boolean find(int data) {

		if (root == null)
			return false;

		Node current = root;

		while (current != null) {

			if (current.data == data)
				return true;
			if (data < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		// not found
		return false;

	}

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();

		/*
		 * Let us create following BST 50 / \ 30 70 / \ / \ 20 40 60 80
		 */
		bst.insertNonRecursive(50);
		bst.insertNonRecursive(30);
		bst.insertNonRecursive(20);
		bst.insertNonRecursive(40);
		bst.insertNonRecursive(70);
		bst.insertNonRecursive(60);
		bst.insertNonRecursive(80);

		boolean found = bst.find(80);

		if (found)
			System.out.println("Given number found in tree");
		else
			System.out.println("Given number not found in tree");

		System.out.println("Preorder traversal of binary tree is ");
		bst.printPreorder();

		System.out.println("\nInorder traversal of binary tree is ");
		bst.printInorder();

		System.out.println("\nPostorder traversal of binary tree is ");
		bst.printPostorder();
		
		System.out.println("\nPostorder traversal of binary tree is NON Rec");
		bst.printPostorderNON();
		
		

	}

}

class Node {

	Node left, right;
	int data;

	public Node(int data) {

		this.data = data;
		left = null;
		right = null;
	}

}
