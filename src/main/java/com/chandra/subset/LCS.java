package com.chandra.subset;

import java.util.*;
import java.lang.Math.*;
/*
 * Longest common subsequence (LCS)
 * String 1: abcdefghik
 * 
 * String 2: cddgi
 */
public class LCS {

	public static int find(char[] X, char[] Y, int m, int n){
		int[][] L = new int[m+1][n+1];
		String[][] solution = new String[m + 1][n + 1];
		
		/*
		 * Following steps build L[m+1] [n+1] in botton up fashion
		 * Note that L[i][j] contains length of LCS of X[0...i-1] and Y[0...j-1]
		 */
		
		// fill the rest of the matrix
		for(int i=0; i<=m; i++){
			for(int j=0; j<=n; j++){
				
				if( i == 0 || j == 0){
					L[i][j] = 0;
					solution[i][i] = "0";
				} else if (X[i-1] == Y[j-1]){
					L[i][j] = L[i-1][j-1] + 1;
					solution[i][j] = "diagonal";
				} else {
					L[i][j] = Math.max(L[i-1][j],L[i][j-1]);
					if (L[i][j] == L[i - 1][j]) {
						solution[i][j] = "top";
					} else {
						solution[i][j] = "left";
					}
				}
					
			}
		}
		
				
		return L[m][n];
	}
	public static void main(String[] args) {

		String A = "tutorialhorizon";
		String B = "dynamictutorialProgramming";
		
		char[] X = A.toCharArray();
		char[] Y = B.toCharArray();
		int m = X.length;
		int n = Y.length;
		System.out.println("LCS length :" + find(X,Y,m,n));
	}

}
