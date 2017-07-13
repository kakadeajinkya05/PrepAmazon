package TopologicalSort;

import java.util.Arrays;
import java.util.List;

public class CharacterOrdering_TopologicalSort {
	public static void main(String[] args) {
		
		List<String> words = Arrays.asList("baa", "abbde", "abca", "cab", "ded"); 
		Graph<Character> graph = new Graph<Character>();
		Scanner sc = new Scanner(graph);
		
		sc.scan(words);
		List<Character> res = new TopologicalSort<>(graph).sort();
		System.out.println(res);
	}
	
	
	
}
