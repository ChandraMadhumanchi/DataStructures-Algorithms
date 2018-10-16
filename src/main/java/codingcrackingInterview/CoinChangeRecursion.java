package codingcrackingInterview;

public class CoinChangeRecursion {

	public static int totalRec(int n,int[] v, int i){
		
		if( n < 0){
			return 0;
		}
		if(n==0){
			return 1;
		}
		// means coins over and n > 0 so no solution
		
		if(i == v.length && n> 0){
			return 0;
		}
		return totalRec(n-v[i],v,i) + totalRec(n,v,i+1);
	}
	
	public static int dynamic(int[] c, int amount) {
		int[][] solution = new int[c.length + 1][amount + 1];

		// if amount=0 then just return empty set to make the change
		for (int i = 0; i <= c.length; i++) {
			solution[i][0] = 1;
		}

		// if no coins given, 0 ways to change the amount
		for (int i = 1; i <= amount; i++) {
			solution[0][i] = 0;
		}

		// now fill rest of the matrix.

		for (int i = 1; i <= c.length; i++) {
			for (int j = 1; j <= amount; j++) {
				// check if the coin value is less than the amount needed
				if (c[i - 1] <= j) {
					// reduce the amount by coin value and
					// use the subproblem solution (amount-v[i]) and
					// add the solution from the top to it
					solution[i][j] = solution[i - 1][j]
							+ solution[i][j - c[i - 1]];
				} else {
					// just copy the value from the top
					solution[i][j] = solution[i - 1][j];
				}
			}
		}
		return solution[c.length][amount];
	}
	
	public static void main(String[] args) {

		int amount = 5;
		int[] v = {1,2,3};
		System.out.println("By Recursion: " + totalRec(amount, v, 0));
		
		System.out.println("By Dynamic Programming " + dynamic(v, amount));
	}

}
