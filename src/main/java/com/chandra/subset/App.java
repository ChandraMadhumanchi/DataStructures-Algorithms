package com.chandra.subset;

public class App {

	public static void main(String[] args) {

		int[] numbers = {2, 3, 5, 6, 8, 10};
		
		int sum = 10;
		
		SubsetSumProblem subsetSumProblem = new SubsetSumProblem(numbers,sum);
		
		subsetSumProblem.solveProblem();
		subsetSumProblem.hasSolution();
		subsetSumProblem.showSums();
		
	}

}
