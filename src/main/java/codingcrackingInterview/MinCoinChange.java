package codingcrackingInterview;

public class MinCoinChange {

	public static int minCoinDynamic(int amount, int[] coins){
		
		// this will store the optimal solution
		// for all the values -- from 0 to givn amount.
		
		int[] coinReq = new int[amount+1];
		// resets for every smaller problems
		// and minimum in it is the optimal solution for the smaller problem.
		int[] CC = new int[coins.length];
		
		coinReq[0] = 0; // 0 coins are required to make the change for 0
		// now solve for all the amounts
		for (int amt = 1; amt <= amount; amt++) {
			for (int j = 0; j < CC.length; j++) {
				CC[j] = -1;
			}
			// Now try taking every coin one at a time and fill the solution in the CC[]
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= amt) { // check if coin value is less than amount
					// select the coin and add 1 to solution of (amount-coin value)
					CC[j] = coinReq[amt - coins[j]] + 1; 											
				}
			}
			//Now solutions for amt using all the coins is stored in CC[]
//			take out the minimum (optimal) and store in coinReq[amt]
			coinReq[amt]=-1;
			for(int j=0;j<CC.length;j++){
				if(CC[j]>0 && (coinReq[amt]==-1 || coinReq[amt]>CC[j])){
					coinReq[amt]=CC[j];
				}
			}
		}
		//return the optimal solution for amount
		return coinReq[amount];
	}
	public static void main(String[] args) {

		int[] coins = {1,2,3};
		int amount = 20;
		
		System.out.println("(Dynamic Programming) Minimum Coins required to make change for "
				+ amount + " are: " + minCoinDynamic(amount, coins));
	}

}
