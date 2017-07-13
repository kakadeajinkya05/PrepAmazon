package TravellingSalesMenProblem;

import TopologicalSort.Graph;

public class GraphBuilder <T> {

	private Graph<Character> graph;
	
	public GraphBuilder(Graph<Character> graph1){
		this.graph = graph1;
	}
	
	public void build(){
		graph = new Graph<>();
		graph.isDirected = true;
		graph.addEdge('A','B');
	}
}
