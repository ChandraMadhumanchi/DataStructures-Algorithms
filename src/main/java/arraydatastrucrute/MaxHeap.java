package arraydatastrucrute;

import java.util.Arrays;

public class MaxHeap {

	public static void main(String[] args) {

		char ch = 'A';
		int num = ch;
		
		char[] chArr = new char[26];
		
		System.out.println("ch: " + num);
		for(int i = 1; i < 26; i++){
			chArr[i] = ch;
			ch += i;
		}
		System.out.println(Arrays.toString(chArr));
	}
	

}
