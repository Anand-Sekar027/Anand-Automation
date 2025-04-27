package bubble_sort;

import java.util.Arrays;

public class Basic_problem {

	public static void main(String[] args) {
		/* Push the maximum to the last
		 * by using adjacent swaps
		 */
		int[] arr = {99, 77, 55, 8, 14, 186, 1};
		bubble_sort_1(arr);		
	}
	
	public static void bubble_sort_1(int[] arr) {
		int n = arr.length;
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-1-i; j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			System.out.println("Sorted Array @ i=  "+i+" -->"+ Arrays.toString(arr));
		}
		System.out.println("Sorted Array : "+ Arrays.toString(arr));
		
	}

}
