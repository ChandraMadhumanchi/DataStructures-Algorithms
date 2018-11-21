package codingcrackingInterview;

import java.util.Arrays;

public class MaximumSubArrayDP {

    //bottom up approach
    public int solve(int [] a){
        int [] solution = new int[a.length+1];
        solution[0] = 0;

        for (int j = 1; j <solution.length ; j++) {
            solution[j] = Math.max(solution[j-1]+a[j-1],a[j-1]);
        }
        //this will print the solution matrix
        //System.out.println(Arrays.toString(solution));
        //now return the maximum in the solution arrayyy
        int result = solution[0];
        for (int j = 1; j <solution.length ; j++) {
            if(result<solution[j])
                result = solution[j];
        }

        return result;
    }
    
    public static int maxsum(int[] arr) {
    	
    	int sum = 0; int temp = 0;
    	for(int i=0; i< arr.length; i++){
    		
    		temp += arr[i];
    		
    		if(sum < temp)
    			sum += temp;
    		
    		
    		if(temp < 0)
    			temp = 0;

    	}
    	return sum;
    }

    public static void main(String[] args) {
        int arrA[] = { 1, 2, -3, -4, 2, 7, -2, 3 };
        MaximumSubArrayDP i = new MaximumSubArrayDP();
        System.out.println("Maximum subarray is  " + i.solve(arrA));
        
        System.out.println("recursive Maximum sum is  " + maxsum(arrA));
    }
}