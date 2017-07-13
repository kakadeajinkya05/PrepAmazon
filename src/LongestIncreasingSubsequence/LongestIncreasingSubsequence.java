package LongestIncreasingSubsequence;

public class LongestIncreasingSubsequence {
	
	public static void LIS(int arr[])
	{
		int parentIndex[]= new int[arr.length]; //Tracking the predecessors/parents of elements of each subsequence.
		int lisIndex[]= new int[arr.length + 1]; //Tracking ends of each increasing subsequence.
		int lisLength = 0; //Length of longest subsequence.
		for(int i=0; i<arr.length; i++)
		{
			//Binary search
			int start = 1;
			int end = lisLength;
			while(start <= end)
			{
				int mid = (int) Math.ceil((start + end)/2);
				
				if(arr[lisIndex[mid]] < arr[i])
					start = mid + 1;
				else
					end = mid - 1;
			}
			//update parent/previous element for LIS
			parentIndex[i] = lisIndex[start-1];
			//Replace or append
			lisIndex[start] =  i;
			
			//Update the length of the longest subsequence.
			if(start > lisLength)
				lisLength=start;
			
			System.out.print("lisIndex  ");
			for (int j = 0; j < lisIndex.length; j++) {
				System.out.print(lisIndex[j]+ " ");
			}
			System.out.println("");
			System.out.print("parentIndex ");
			for (int j = 0; j < parentIndex.length; j++) {
				System.out.print(parentIndex[j]+ " ");
			}
			System.out.println("");
			
		}
		//Generate LIS by traversing parent array
		int LIS[] = new int[lisLength];
		int k 	= lisIndex[lisLength];
		for(int j=lisLength-1; j>=0; j--)
		{
			LIS[j] =  arr[k];
			k = parentIndex[k];
		}
		for(int i=0; i<lisLength; i++)
		{
			System.out.println(LIS[i]);
		}
	}
	
	
	public static void findLISArray(int arr[]){
		int listIndex [] = new int [arr.length+1];
		int parentIndex [] = new int[arr.length];
		int lisLength = 0;
		for(int i=0;i<arr.length;i++){
			int start = 1;
			int end = lisLength;
			while(start <= end){
				//int mid 
			}
			listIndex[i]=start;
			parentIndex[i]=listIndex[start-1];
			if(lisLength < start){
				lisLength = start;
			}
		}
	}
	
	
	public static void main(String args[])
	{
		//int X[] = {50, 3, 10, 7, 40, 80 , 5};//{3,1,5,0,6,4,9};
		int X[] = {10,22,9,33,21,50,41,60,80};
		LIS(X);
	}
}