package editArray;


/*
 * 
 * Write a program which takes input a sorted array and positive number 
 * and updates the array so that if x appears m times in array 
 * then it appears exactly min(2,m) times in array. 
 * the update should be performed in one pass with no additional memory
 * if an array is {2,2,2,2,3} and the method is editArray(arr[],m)
	if m=4
	then after the method array should be {2,2,3,0,0}
 */

public class EditArray {

	public static void editArray1(int[] arr, int m) {
		int prevEle = 0, prevIndex = 0, count = 0;
		for (int i = 0; i < arr.length; i++) {
			//System.out.println("curElm=" + prevEle + " index= " + i + " arr[i]" + arr[i]);
			if (prevEle == arr[i]) {
				count++;
			} else
				count = 1;
			//System.out.println("	count=" + count);
			if (count <= Math.min(2, m)) {
				//System.out.println("	count " + count + " < (2," + m);
				//System.out.println("	Shifting " + arr[prevIndex] + " = " + arr[i]);
				arr[prevIndex] = arr[i];
				prevEle = arr[i];
				prevIndex++;
			}
		}
		while (prevIndex < arr.length) {
			arr[prevIndex] = 0;
			prevIndex++;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 2, 2, 2, 3 };
		int m = 4;
		editArray1(arr, m);
	}
}
