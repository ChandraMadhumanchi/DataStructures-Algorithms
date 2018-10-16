package codingcrackingInterview;

import java.util.HashMap;

public class MakeChange {

	public static void main(String[] args) {

		// Make change (27 - {25,10,5,13})
		int[] coins = new int[] {1,2,3}; 
		int money = 4;
		System.out.println("memorization :  "+ makeChange(coins, money,0, new HashMap<String, Long>()));
		System.out.println("recursion: "+ makeChangeRec(coins, money,0));
	}
	
	public static long makeChangeRec(int[] coins, int money,int index){
		if(money == 0){
			return 1;
		}
		if(index >= coins.length){
			return 0;
		}
		
		int amountWithCoin = 0;
		long ways = 0;
		while( amountWithCoin <= money){
			int remaining = money - amountWithCoin;
			ways += makeChangeRec(coins,remaining,index + 1);
			amountWithCoin += coins[index];
		}
		return ways;
	}
	

	public static long makeChange(int[] coins, int money,int index,HashMap<String,Long> memo){
		if(money == 0){
			return 1;
		}
		if(index >= coins.length){
			return 0;
		}
		
		String key = money + "-" + index;
		if(memo.containsKey(key)){
			return memo.get(key);
		}
		
		int amountWithCoin = 0;
		long ways = 0;
		while( amountWithCoin <= money){
			int remaining = money - amountWithCoin;
			ways += makeChange(coins,remaining,index + 1,memo);
			amountWithCoin += coins[index];
		}
		memo.put(key, ways);
		return ways;
	}
	
}
