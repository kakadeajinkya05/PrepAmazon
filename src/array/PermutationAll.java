package array;

import java.util.ArrayList;
import java.util.List;

public class PermutationAll {

	static int arraySize = 2;

	public static void main(String[] args) {
		int[] num = { 1, 2 };
		System.out.println(permutation(num));
	}

	private static List<List<Integer>> permutation(int[] num) {
		List<List<Integer>> results = new ArrayList<>();
		if (num.length == 0) {
			return results;
		}
		List<Integer> result = new ArrayList<>();
		dfsNoRepeat(num, results, result);
		return results;
	}

	private static void dfsNoRepeat(int[] num, List<List<Integer>> results, List<Integer> result) {
		if (result.size() == arraySize) {
			ArrayList<Integer> temp = new ArrayList<Integer>(result);
			results.add(temp);
		}else{
		for (int i = 0; i < num.length; i++) {
			if (!result.contains(num[i])) {
				result.add(num[i]);
				dfsNoRepeat(num, results, result);
				result.remove(result.size() - 1);
			}
		}}
	}

	private static void dfsRepeat(int[] num, List<List<Integer>> results, List<Integer> result) {
		if (result.size() == arraySize) {
			ArrayList<Integer> temp = new ArrayList<Integer>(result);
			results.add(temp);
		} else {
			for (int i = 0; i < num.length; i++) {
				result.add(num[i]);
				dfsRepeat(num, results, result);
				result.remove(result.size() - 1);

			}
		}
	}

}
