package array;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
class MidIndex
 {
	public static void main (String[] args)
	 {
    	 Scanner sc = new Scanner(System.in);
    	 int times = sc.nextInt();
    	 while(times>0){
    	     int size = sc.nextInt();
    	     Set<Integer> arr = new LinkedHashSet<>();
    	     Map<Integer,Integer> hm = new HashMap<>();
    	     for(int i=0;i<size;i++){
    	         int element = sc.nextInt();
    	         if(null == hm.get(element)){
    	             hm.put(element,i);
    	         }
    	         arr.add(element);
    	     }
    	     //System.out.println("Array Size= "+arr.size());
                	     
    	     if(arr.size()%2 == 1 ){
    	         int middleIndex = (arr.size()/2)+1;
    	         System.out.println(middleIndex);
    	        // System.out.println("This is an odd array middleIndex="+middleIndex);
    	        // int i=0;
    	        // for(Integer ele : arr){
    	        //     System.out.print(ele+",");
    	        //     if(i == middleIndex){
    	        //         System.out.println(hm.get(ele));
    	        //     }
    	        //     i++;
    	        // }
    	         
    	     }
    	     else{
    	         System.out.println("-1");
    	     }
    	     times--;
    	 }
	 }
}