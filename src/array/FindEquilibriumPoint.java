package array;

public class FindEquilibriumPoint {
	public static void main(String[] args) {
		int arr[] = {3,3,12,6,6,6,6}; 
		findEQ(arr);
	}

	private static void findEQ(int[] arr) {
		int rightSum = 0;
		for(int i=1;i<arr.length;i++){
			rightSum+=arr[i];
		}
		int leftSum= 0;
		for(int i=0;i<arr.length;i++){
			if(leftSum == rightSum){
				System.out.println(i+" is the Equlibrium point value = "+arr[i]);
			}
			leftSum +=arr[i];
			rightSum-=arr[i];
		}
	}
}
