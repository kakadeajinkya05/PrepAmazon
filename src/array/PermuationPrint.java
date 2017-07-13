package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermuationPrint {

	public static void main(String[] args) {
		//List<Integer> arr = new LinkedList<>();
		//arr.add(1);arr.add(2);arr.add(3);arr.add(4);
		//List<Integer> prefixList = new LinkedList<>();
		//permutation(prefixList,arr);
		int[] arr={1,2,3,4};
		System.out.println(permute(arr));
		
	}
	public static List<List<Integer>> permute(int[] nums) {
	    List<List<Integer>> results = new ArrayList<List<Integer>>();
	    if (nums == null || nums.length == 0) {
	        return results;
	    }
	    List<Integer> result = new ArrayList<>();
	    dfs(nums, results, result);
	    return results;
	}

	public static  void dfs(int[] nums, List<List<Integer>> results, List<Integer> result) {
	    if (3 == result.size()) {
	        List<Integer> temp = new ArrayList<>(result);
	        results.add(temp);
	    }        
	    for (int i=0; i<nums.length; i++) {
	        if (!result.contains(nums[i])) {
	            result.add(nums[i]);
	            dfs(nums, results, result);
	            result.remove(result.size() - 1);
	        }
	    }
	}
	private static void permutation(List<Integer> prefixList, List<Integer> arr) {
		System.out.print("Printing the PrefixList : ");
		System.out.println(prefixList);
		System.out.print("Printing the arrList : ");
		System.out.println(arr);
		
		if(prefixList.size()==4){
			System.out.println(prefixList);
		}else{
			List<Integer> tempArr = new LinkedList<>();
			for (Integer ele : arr) {
				tempArr.add(ele);
			}
			System.out.println("Arr size="+arr.size() +" tempArr size="+ tempArr.size());
			for(int i=0;i<arr.size();i++){
				System.out.println("taking care of="+arr.get(i));
				prefixList.add(arr.get(i));
				tempArr.remove(i);
				permutation(prefixList, tempArr);
			}
		}
		
	}

}
