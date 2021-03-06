package array;

class SpecialFindMaximum
{
    /* Utility Functions to get max and minimum of two integers */
    int max(int x, int y) 
    {
        return x > y ? x : y;
    }
 
    int min(int x, int y) 
    {
        return x < y ? x : y;
    }
 
    /* For a given array arr[], returns the maximum j-i such that
       arr[j] > arr[i] */
    int maxIndexDiff(int arr[], int n) 
    {
        int maxDiff;
        int i, j;
 
        int RMax[] = new int[n];
        int LMin[] = new int[n];
 
        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = arr[0];
        for (i = 1; i < n; ++i)
            LMin[i] = min(arr[i], LMin[i - 1]);
 
        for(int x=0;x<n;x++){
        	System.out.print(LMin[x] + " ");
        }
        System.out.println("");
        
        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j)
            RMax[j] = max(arr[j], RMax[j + 1]);
 
        for(int x=0;x<n;x++){
        	System.out.print(RMax[x] + " ");
        }
        System.out.println("");
        /* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
        i = 0; j = 0; maxDiff = -1;
        while (j < n && i < n) 
        {
        	System.out.println("i="+i+ " j="+j +" LMin[i]="+LMin[i] +  " RMax[j]="+RMax[j]);
            if (LMin[i] < RMax[j]) 
            {
            	System.out.println("	LMin[i] < RMax[j] ");
            	System.out.println("	comapring maxDiff="+maxDiff + "j-i="+ (j-i));
                maxDiff = max(maxDiff, j - i);
                j = j + 1;
                System.out.println("	Incrementing j");
            } 
            else{
                i = i + 1;
            	System.out.println("	Incrementing i >>>>>>>>>>>>>>>>");
            }
        }
 
        return maxDiff;
    }
 
    /* Driver program to test the above functions */
    public static void main(String[] args) 
    {
        SpecialFindMaximum max = new SpecialFindMaximum();
        //int arr[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
        int arr[] = {6, 5, 4, 2, 7, 8, 1, 2, 6,1};
        
        int n = arr.length;
        int maxDiff = max.maxIndexDiff(arr, n);
        System.out.println(maxDiff);
    }
}
