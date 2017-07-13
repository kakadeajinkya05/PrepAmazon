package LargestSumContiguousSubarray;

public class LargestSumContiguousSubarray {

	static void sumSubArray(int[] arr) {
		int currMax = 0;
		int max = 0;
		currMax = arr[0];
		max = arr[0];
		int start = 0, end = 0;
		for (int i = 1; i < arr.length; i++) {
			if (currMax + arr[i] > arr[i]) {
				currMax = currMax + arr[i];
			} else {
				currMax = arr[i];
				start = i;
			}
			if (currMax > max) {
				max = currMax;
				end = i;
				System.out.println("new Max =" + max + " started at=" + start + " ended at =" + end);
			}
		}
	}

	public static void main(String[] args) {
		// int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3 };

		int arr[] = { 2, -3, 4, -1, -2, 1, 5, -3 };
		sumSubArray(arr);
	}

}
