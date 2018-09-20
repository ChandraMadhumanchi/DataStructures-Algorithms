package com.algorithm.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CheckValidParanthasis {

	public static void main(String[] args) throws IOException,IllegalArgumentException {

		/*
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); int numOfString =
		 * Integer.parseInt(br.readLine()); String s; String stringBalanced =
		 * "YES";
		 * 
		 * java.util.Stack<Character> exprStack = new java.util.Stack<> ();
		 * 
		 * while ((s = br.readLine()) != null) { stringBalanced = "YES"; int
		 * length = s.length() - 1; check(s, stringBalanced, exprStack, length);
		 * 
		 * }
		 */
		String s = "[()(]]";
		System.out.println(isValid(s));
	}

	public static boolean isValid(String s) {
		char arr[] = s.toCharArray();
		Stack<Character> set = new Stack();
		for (Character ch : arr) {
			if (ch == '{' || ch == '[' || ch == '(') {
				set.push(ch);
			} else if (ch == ']') {
				if (set.isEmpty() || set.peek() != '[') {
					return false;
				} 
				set.pop();
			} else if (ch == ')') {
				if (set.isEmpty() ||  set.peek() != '(') 
					return false;
				set.pop();	
			} else if (ch == '}') {
				if (set.isEmpty() ||  set.peek() != '{') 
					return false;
				set.pop();	
			}
		}
		return set.size() == 0;
	}
}