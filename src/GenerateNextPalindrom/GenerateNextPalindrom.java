package GenerateNextPalindrom;

import java.util.ArrayList;
import java.util.List;

public class GenerateNextPalindrom {

	public static void main(String[] args) {
		int num = 88995;
		// num = 89088;
		//num = 9424;
		int[] res = findNextPalin(num);
	}

	private static int[] findNextPalin(int num) {
		System.out.println("Num = "+ num);
		if(isPalindrom(num)){
			num = num+1;
			System.out.println("NUm changed tp : "+ num);
		}
		int arr[] = getNumberArray(num);
		int start = 0;
		int end = arr.length-1;
		int carry = 0 ;
		while(start<end){
			carry = makePalindrom(arr,start++,end--,carry);
		}
		boolean reWriting = false;
		if(carry == 1 ){
			arr[end]++;
			if(arr.length%2 == 0){
				reWriting = true;
			}
			while(arr[end] == 10 && end>0){
				arr[end] = 0;
				arr[end-1] = arr[end-1] + 1;
				end --;
			}
		}
		System.out.println("First Pass");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		if(reWriting){
			start = 0;
			end = arr.length-1;
			carry = 0 ;
			while(start<end){
				carry = makePalindrom(arr,start++,end--,carry);
			}
			System.out.println("");
			System.out.println("Second Pass");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}	
		}
				
		return arr;
	}



	private static int makePalindrom(int[] arr, int start, int end, int carry) {
		int leftNum = arr[start];
		int rightNum = arr[end];
		if(carry == 1){
			System.out.println("    num "+ rightNum + " changed to " + (rightNum+1));
			rightNum++;
		}
		carry = 0;
		if(rightNum == 10){
			carry = 1;
		}
		arr[end] = arr[start];
		if(rightNum == leftNum){
			return carry;
		}
		if(rightNum > leftNum){
			carry =1;
		}
		return carry;
	}

	private static boolean isPalindrom(int num) {
		int arr [] = getNumberArray(num);
		int end = arr.length-1;
		int start =0;
		while(start<end){
			if(arr[start++] != arr[end--]){
				return false;
			}
		}
		return true;
	}

	private static int[] getNumberArray(int num) {
		List<Integer> arrList = new ArrayList<Integer>();
		while(num != 0){
			arrList.add(num%10);
			num = num /10;
		}
		int arr[] = new int[arrList.size()];
		int arrlistCounter = arrList.size()-1;
		for(int i=0;i<arr.length;i++){
			arr[i] = arrList.get(arrlistCounter--);
		}
		return arr;
	}

}
