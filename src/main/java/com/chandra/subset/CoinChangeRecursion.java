package com.chandra.subset;

/*
 *  you are given coins of different denomination and a total amount of money
 *  Write a function to complete the number of combination that make up that amount.
 *  coins 1 2 3 5
 *  coin val 0,1,2,3,4,5,6,7,8,9
 *  https://www.youtube.com/watch?v=PPgGJvgv2Ag
 */
public class CoinChangeRecursion {

	public static int[] coins = {1,2,3,5};
	public static int amount = 9;
	
	public static void main(String[] args) {
		System.out.println(combo(4,0));
		System.out.println("====");
		
		System.out.println("" + minCoins(coins,amount));
		
	}

	private static int combo(int amount,int currentCoin) {
		
		if(amount == 0)
			return 1;
		
		if(amount < 0)
			return 0;
		
		int nCombos = 0;
		
		for(int coin = 0; coin < coins.length; coin++){
			nCombos += combo( amount - coins[coin],coin);
		}
		return nCombos;
	}

	private static int minCoins(int[] coins, int targetChange){
		
		int uniqueCoins = coins.length;
		int[][] table = new int[uniqueCoins][targetChange+1];
		
		for(int i=0; i<uniqueCoins; i++){
			table[i][0] = 0;
		}
		for(int i=0; i <uniqueCoins; i++){
			for(int j=0; j <= targetChange; j++){
				if( j >= coins[i]) { // only check values less than coin val
					for(int k= i; k < uniqueCoins; k++){ // update current value and all other below
						table[k][j] = table[i][j-coins[i]] + 1;
					}
				}
			}
		}
		
		for(int i=0; i < uniqueCoins; i++){
			for(int j=0; j<= targetChange; j++){
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		return table[uniqueCoins-1][targetChange];
	}
}
