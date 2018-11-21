package com.algorithm.datastructures;

import java.util.Arrays;

public class SortingAlgorithms {

	
	public static void quicksort(int[] array) {
		quicksort(array, 0, array.length - 1);
	}
    
	public static void quicksort(int[] array, int left, int right) {
        
		int i = left;
		int j = right;
		int temp;
		int pivot = array[(left+right)/2];
		while ( i <= j){
			while( array[i] < pivot)
				i++;
			while(array[j] > pivot)
				j--;
			if(i<=j){
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
			
			if( left < j){
				quicksort(array,left,j);
			}
			
			if( i < right){
				quicksort(array,i,right);
			}
		
	
	}
	
	public static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = array[temp];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] { 4, 6, 2, 9, 3,8 };
		quicksort(array);
		System.out.println("Quick sort is :" + Arrays.toString(array));
		
		System.out.println(" ");
		
		int[] array1 = new int[] { 4, 6, 2, 9, 3,8 };
		mergeSort(array1);
		System.out.println("Merge sort is :" + Arrays.toString(array1));
	}

	public static void mergeSort(int[] array){
		mergeSort(array,0,array.length-1);
	}
	
	public static void mergeSort(int[] array,int left, int right){
		if(left < right){
			int mid = (left + right)  /2 ;
			
			mergeSort(array,left,mid);
			mergeSort(array,mid+1,right);
			merge(array,left,mid,right);
		}
	}
	
	public static void merge (int[] arr, int l,int mid,int r){
		
		// find the size of two sub arrays
				int n1 = mid - l + 1;
				int n2 = r - mid;
				
				// create temp arrays
				int[] L = new int[n1];
				int[] R = new int[n2];
				
				// copy the elements to two arrays
				
				for(int i = 0; i < n1; i++){
					L[i] = arr[l+i];
				}
				
				for(int j = 0; j < n2; j++ ){
					R[j] = arr[mid +1 + j];
				}
				
				// merge temp arrays
				
				int i= 0, j =0;
				int k = l;
				
				
				while(i < n1 && j < n2){
					
					if(L[i] < R[j]){
						arr[k] = L[i];
						i++;
					} else {
						arr[k] = R[j];
						j++;
					}
					k++;
				}
				
				while(i < n1){
						arr[k] = L[i];
						i++;
						k++;
				}
				while(j < n2){
						arr[k] = R[j];
						j++;
						k++;
				}
		
	}
}
