package com.chandra.hackerank;

import java.io.IOException;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerToWord {

	public static void main(String[] args) throws IOException {
		String[] tokens = new String[] { "2", "1", "+", "3", "*" };
		//System.out.println(evalRPN(tokens));
		
		String c = new String("abcd");
		//String d = "abcd";
		c = "abcd1";
		//System.out.println(c == d);  // False
		//System.out.println(c.equals(d)); // True
		
		System.out.println(c);  // False
		
	}
 
	public static int evalRPN(String[] tokens) {
		int returnValue = 0;
		String operators = "+-*/";
 
		Stack<String> stack = new Stack<String>();
 
		for (String t : tokens) {
			if (!operators.contains(t)) { //push to stack if it is a number
				stack.push(t);
			} else {//pop numbers from stack if it is an operator
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				switch (t) {
				case "+":
					stack.push(String.valueOf(a + b));
					break;
				case "-":
					stack.push(String.valueOf(b - a));
					break;
				case "*":
					stack.push(String.valueOf(a * b));
					break;
				case "/":
					stack.push(String.valueOf(b / a));
					break;
				}
			}
		}
 
		returnValue = Integer.valueOf(stack.pop());
 
		return returnValue;
	}

}
