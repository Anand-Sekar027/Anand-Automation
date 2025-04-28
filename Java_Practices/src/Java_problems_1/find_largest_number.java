package Java_problems_1;

public class find_largest_number {

	public static void main(String[] args) {

		int[] arr = {7, 65, 8, 95, 25};
		
		int largest_number = find_largest_number_in_array(arr);
		System.out.println("find_largest_number_in_array : "+largest_number);
		
		int Slargest = find_second_largest_number_in_array(arr);
		System.out.println("find_second_largest_number_in_array : "+Slargest);
		
		int[] nums = {3,4,5,1,2};
		boolean bool = L_1752_Check_if_Array_Is_Sorted_and_Rotated(nums);
		System.out.println("L_1752_Check_if_Array_Is_Sorted_and_Rotated : "+bool);


	}

	public static int find_largest_number_in_array(int[] arr) {
		int largest = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			if (arr[i]>largest) {
				largest = arr[i];
			}
		}
		return largest;	
	}
	
	public static int find_second_largest_number_in_array(int[] arr) {
		int largest = arr[0];
		int Slargest = -1;
		for(int i=0; i<arr.length; i++) {
			if (arr[i]>largest) {				
				Slargest = largest;
				largest = arr[i];
			}
			else if(arr[i]>Slargest && largest!=Slargest) {
				Slargest = arr[i];
			}
		}
		return Slargest;	
	}
	
	public static boolean L_1752_Check_if_Array_Is_Sorted_and_Rotated(int[] nums) {
		int count = 0;
        int n = nums.length;
        for (int i=0; i<n; i++){
            if(nums[i]>nums[(i+1)%n]){
                count++;
            }
        }
        return count<=1;
		
		
		
	}
}
