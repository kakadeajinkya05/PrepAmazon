package CountPairsWithGivenSum;

import java.util.HashMap;
import java.util.Map;

public class CountPairs {

	public static void main(String[] args) {
			int arr[] = {1, 5, 7, -1};
			int sum = 6;
			countPairs(arr, sum);
	}

	private static void countPairs(int[] arr, int sum) {
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++){
			map.put(arr[i], map.containsKey(arr[i]) ? map.get(arr[i]) + 1 : 1);
		}
		int pairCount = 0;
		for(int i=0;i<arr.length;i++){
			System.out.println("Checking element ="+arr[i]);
			if(map.containsKey(sum-arr[i])){
				System.out.println(" Pair found "+ arr[i] + " + " + (sum-arr[i]) + " = "+ sum);
				pairCount++;
			}
		}
		System.out.println("PAir found = "+pairCount/2);
		
		
	}

}
