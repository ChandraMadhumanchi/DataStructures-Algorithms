package arraydatastrucrute;

public class Intersection {

	public static void main(String[] args) {

		int[] arr1 = new int[] {1,2,4,5,6};
		int[] arr2 = new int[] {2,3,5,7};
		
		
		
	}
	
	void printUnion(int arr1[], int arr2[], int m, int n){
		
		int i=0; int j = 0;
		while( i < m && j < n){
			if(arr1[i] < arr2[j])
				System.out.print(arr1[i++]);
			else if (arr2[j] < arr1[i])
				System.out.print(arr2[j++]);
			else
			{
				System.out.print(arr2[j+1]);
				i++;
			}
		}
		
		/* Print remaining elements of larger array*/
		while ( i < m)
			System.out.println(arr1[i++]);
		while ( j < n)
			System.out.println(arr1[j++]);
	}

	void printInterSection(int[] arr1, int[] arr2, int m, int n){
		
		int i = 0,  j = 0;
		while( i < m && j < n){
			
			if(arr1[i] < arr2[j])
				i++;
			else if (arr2[j] < arr1[i])
				j++;
			else  /* if arr1[i] == arr[j] */
			{
				System.out.print("" + arr2[j++]);
				i++;
			}
			
		}
	}
	
	
	
	
}
