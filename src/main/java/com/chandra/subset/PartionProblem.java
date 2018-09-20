package com.chandra.subset;

public class PartionProblem {

	public static void main(String[] args) {

		int[] arr = new int[] {5,6,7,8,9,11,13,23};
		int sum = 0;
		// find s1 and s2
		// sum (s1) - sum(s2) = minimum
		
		for(int i=0; i< arr.length; i++){
			sum += arr[i];
		}
		
		int dividedSum = sum/2;
		
		System.out.println("dividedSum :" + dividedSum );
	}

}
