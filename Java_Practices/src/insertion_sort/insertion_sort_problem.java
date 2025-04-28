package insertion_sort;

import java.util.Arrays;

public class insertion_sort_problem {

	public static void main(String[] args) {
		/* 
		 * Takes an element and place its correct order 
		 */
		int[] arr = {6, 5, 4, 3, 2, 1};
		problem(arr);
	}

	public static void problem(int[] arr) {
		int n = arr.length;
		for(int i=0; i<n; i++) {
			int j=i;
			while(j>0 && arr[j-1]>arr[j]) {
				int temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;
				j--;
			}
		}
		
		System.out.println("Sorted Array : "+ Arrays.toString(arr));
	}
}
