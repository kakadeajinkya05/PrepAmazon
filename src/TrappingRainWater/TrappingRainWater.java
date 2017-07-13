package TrappingRainWater;

public class TrappingRainWater {
	
	public static void findTotalWaterVolume(int[] arr){
		int rightMax[] = new int[arr.length];
		rightMax[arr.length-1] = arr[arr.length-1];
		for(int i= arr.length-2;i>=0;i--){
				rightMax[i]= findMax(arr[i],rightMax[i+1]);
		}
		int leftMaxSoFar = arr[0];
		int totalRinWater = 0;
		for(int i=0;i< arr.length;i++){
			totalRinWater += findMax(findMin(leftMaxSoFar,rightMax[i]) - arr[i],0);
			System.out.println(arr[i] + " " + leftMaxSoFar + " " + rightMax[i] + " total="+totalRinWater);
			if(arr[i] > leftMaxSoFar){
				leftMaxSoFar = arr[i];
			}
		}
	}

	private static int findMin(int num1, int num2) {
		return num1>num2?num2:num1;
	}

	private static int findMax(int num1, int num2) {
		return num1>num2?num1:num2;
	}

	public static void main(String[] args) {
		int arr []= {3,0,0,2,0,4};
		findTotalWaterVolume(arr);
		
	}

}
