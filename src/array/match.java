package array;
import java.util.*;
import java.lang.*;
import java.io.*;
class match
 {
     
     public static int[] updateProcArr(int [] procArr,int startIndex){
         String match="100";
         for(int i=0;i<match.length();i++){
             if(procArr[startIndex]==1){
                 while( startIndex<procArr.length){
                     if(procArr[startIndex]==0)break; 
                     startIndex++;
                 }
             }
             procArr[startIndex]=1;
             startIndex++;
         }
         return procArr;
     }
     public static boolean checkMatchExist(char []arr,int startIndex,int [] procArr){
         String match="100";
         int j=0;
         
         for(int i=0;i<match.length();i++){
             if(startIndex==arr.length) return false;
        	 System.out.println("   proc status="+procArr[startIndex]);
             if(procArr[startIndex]==1){
                 while( startIndex<arr.length){
                     if(procArr[startIndex]==0)break; 
                     System.out.println("       incrementing startindex="+startIndex);
                     startIndex++;
                 }
             }
             if(startIndex==arr.length){
                 System.out.println("   reached the end of arr");
                 return false;
             }
             System.out.println("   comparing "+startIndex + " character ="+ arr[startIndex] + " with "+match.charAt(j) );
             if(arr[startIndex]!=match.charAt(j)){
                 return false;
             }
             startIndex++;j++;
         }
         return true;
     }
	public static void main (String[] args)
	 {
    	 Scanner sc = new Scanner(System.in);
    	 int times = sc.nextInt();
    	 String match="100";
    	 while(times>0){
    	     String str = sc.next();
    	     //System.out.println(str);
    	     times --;
    	     char[] arr = str.toCharArray();
    	     int []procArr = new int [arr.length];
    	     for(int i=0;i<arr.length;i++){
    	         procArr[i] = 0;
    	     }
    	     boolean isChanged= true;
    	     boolean isExist = false;
    	     while(isChanged){
    	         isChanged =false;
    	         for(int i=0;i<arr.length-match.length()+1;i++){
    	             isExist = false;
    	             System.out.println("Checking "+arr[i]);
    	             if(procArr[i]==0){
    	                System.out.println("Checking "+i+ "character ="+ arr[i]);
    	                isExist = checkMatchExist(arr,i,procArr);
    	             }
    	             if(isExist){
    	                 procArr = updateProcArr(procArr,i);
    	                 isChanged =true;
    	             }
    	         }
    	         for(int i=0;i<arr.length;i++){
    	             System.out.print(arr[i]+" ");
    	         }
    	         System.out.println("");
    	         for(int i=0;i<arr.length;i++){
    	             System.out.print(procArr[i]+" ");
    	         }
    	         System.out.println("");
    	     }
    	    int maxSubArr=0;
    	     int count =0;
    	    for(int i=0;i<procArr.length;i++){
    	        if(procArr[i]==1){
    	            count =0;
    	            while(i<procArr.length){
    	                if(procArr[i]==0){
    	                    break;
    	                }
    	                count++;
    	                i++;
    	            } 
    	            if(count>maxSubArr){
    	                maxSubArr= count;
    	            }
    	        }
    	    }
    	    System.out.println(maxSubArr);
    	 }
	 }
}