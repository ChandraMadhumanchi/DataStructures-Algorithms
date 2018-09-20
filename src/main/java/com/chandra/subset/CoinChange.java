package com.chandra.subset;

public class CoinChange {

	public static void main(String[] args) {

		System.out.println(change(4, new int[]{1,2}));
	}
	// https://www.youtube.com/watch?v=Y0ZqKpToTic
	public static int change(int amount, int[] coins){
		
		int[] combinations = new int[amount + 1];
		
		combinations[0] = 1;
		
		for(int coin : coins){
			for(int i = 1; i < combinations.length; i++){
				if( i >= coin){
					combinations[i] = combinations[i] + combinations[i - coin];
					printAmount(combinations);
				}
			}
			System.out.println("");
		}
		return combinations[amount];
	}
	
	public static void printAmount(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print( arr[i] + " ");
		}
		System.out.println();
	}

}
