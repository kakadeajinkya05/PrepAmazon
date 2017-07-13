package TopologicalSort;

import java.util.List;

public class Scanner {
	Graph<Character> graph;
	public Scanner(Graph<Character> g){
		graph = g;
	}
	
	public void scan(List<String> words){
		if(words.size() > 1){
			for(int i =1 ;i<words.size();++i){
				String first = words.get(i-1);
				String second = words.get(i);
				int minLength  = Math.min(first.length(), second.length());
				int j=0;
				for(j=0;j<minLength;j++){
					if(first.charAt(j) != second.charAt(j)){
						graph.addEdge(first.charAt(j), second.charAt(j));
						j++;
						break;
					} else {
						graph.addVertex(first.charAt(j));
					}
				}
				int count = j;
				while(count < first.length()){
					graph.addVertex(first.charAt(count++));
				}
				count = j;
				while(count < second.length()){
					graph.addVertex(second.charAt(count++));
				} 
			}
		}
	}
}
