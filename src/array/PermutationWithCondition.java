package array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class PermutationWithCondition
 {
	static int maxSize = 0;
    static int maxDiff= 0;
	public static void main (String[] args)
	 {
		Collections.reverse(new ArrayList<>());
    	 Scanner sc = new Scanner(System.in);
    	 int times = sc.nextInt();
    	 while(times>0){
    	     int size = sc.nextInt();
    	     int num[] = new int[size];
    	      maxSize = sc.nextInt();
    	      maxDiff= sc.nextInt();
    	     for(int i=0;i<size;i++){
    	         num[i] = sc.nextInt();
    	     }
    	     List<Integer> result = new ArrayList<>();
    	     List<List<Integer>> results = new ArrayList<>();
    	     findAllPerm(num,results,result);
    	     System.out.println(results.size());
    	     
    	     times--;
    	 }
    	 sc.close();
	 }

	private static int getResultSDiff(List<Integer> result,int num){
		int diff=0;
		diff = num - result.get(0);
		return diff;
	}
	private static void findAllPerm(int[] num, List<List<Integer>> results, List<Integer> result) {
		if(result.size() == maxSize){
				ArrayList<Integer> temp = new ArrayList<Integer>(result);
				results.add(temp);
				System.out.println(temp);
		}else{
			for(int i=0;i<num.length;i++){
				if(!result.contains(num[i]) ){
					if(result.size()>0 && 
							(num[i]-result.get(0) >maxDiff || 
							result.get(result.size()-1)>num[i])){
						//System.out.println("Ignoring  "+num[i] +" to "+ result);
						
					}else{
					//System.out.println("Adding  "+num[i] +" to "+ result);
						result.add(num[i]);
						findAllPerm(num, results, result);
						result.remove(result.size()-1);}
				}
			}
		}
	}
}