package CountPairsWithGivenSum;

public class CountTriplets {

	public static void main(String[] args) {
		 int arr[] = {1, 4, 45, 6, 10, 8};
		 int sum = 22;
		 countTriplets(arr,sum);
	}

	private static void countTriplets(int[] arr, int sum) {
		quickSort(arr,0,arr.length-1);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		
		for(int i=0;i<arr.length-2;i++){
			int start = i+1;
			int end = arr.length-1;
			while(start < end){
				int currSum = arr[i] + arr[start]+arr[end];
				System.out.println(" Summin a triplet "+arr[i] + " " + arr[start] + " "+ arr[end]	+ " = "+ (arr[i]+arr[start]+arr[end]));
				if( currSum == sum){
					System.out.println(" Found a triplet ");
					break;
				} else if( currSum < sum){
					start ++;
				} else {
					end --;
				}
			}
		}
	}

	private static void quickSort(int[] arr, int start, int end) {
		if(start<end){
			int partition =  partition(arr,start,end);
			quickSort(arr, start, partition-1);
			quickSort(arr,partition+1,end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int swapFromHere = start;
		int pivot = arr[end];
		for(int i=start;i<=end;i++){
			if(arr[i] < pivot){
				swapNumbers(arr, swapFromHere, i);
				swapFromHere++;
			}
		}
		swapNumbers(arr, swapFromHere, end);
		return swapFromHere;
	}

	private static void swapNumbers(int[] arr, int swapFromHere, int i) {
		int temp = arr[swapFromHere];
		arr[swapFromHere] = arr[i];
		arr[i] = temp;
	}


}
