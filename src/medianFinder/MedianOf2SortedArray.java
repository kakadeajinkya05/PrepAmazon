package medianFinder;

public class MedianOf2SortedArray {

	public static void main(String[] args) {
		// int A[] = { 1, 12, 15, 26, 38 };
		// int B[] = { 2, 13, 17, 30, 45 };

		int[] A = { 1, 2, 3, 4, 15, 16 };
		int B[] = { 5, 10, 12, 18, 20, 35, 76, 110 };

		System.out.println(findMedian(A, B));
		// findMedian(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1);
	}

	private static double findMedian(int[] num1, int[] num2) {
		int total = num1.length + num2.length;
		if(total%2 == 0 ){
			return (findKth(total/2+1, num1, num2, 0, 0)+findKth(total/2, num1, num2, 0, 0))/2.0;
		}
		return findKth(total/2, num1, num2, 0,0); 
	}

	private static int findKth(int k, int[] num1, int[] num2, int s1, int s2) {
		if(s1 > num1.length){
			return num2[s2+k];
		}
		if(s2 > num2.length){
			return num1[s1+k];
		}
		if(k==1){
			return Math.min(num1[s1-1], num2[s2-1]);
		}
		int m1 = s1 + k/2 ;
		int m2 = s2 + k/2 ;
		int mid1 = m1 < num1.length ? num1[m1] : Integer.MAX_VALUE;
		int mid2 = m2 < num2.length ? num2[m2] : Integer.MAX_VALUE;
		if(mid1 < mid2){
			return findKth(k - k/2, num1, num2, m1+1, s2);
		}
		return  findKth(k - k/2, num1, num2, s1, m2+1);
	}
	
}









