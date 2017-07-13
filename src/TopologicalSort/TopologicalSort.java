package TopologicalSort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort <T> {
	Graph<T> graph;
	public TopologicalSort(Graph<T> g){
		graph = g;
	}
	
	public List<T> sort(){
		Stack<Graph<T>.Vertex> stack = new Stack<Graph<T>.Vertex>();
		Set<Graph<T>.Vertex> visited = new HashSet<Graph<T>.Vertex>();
		List<T> sequence = new ArrayList<T>();
		Collection<Graph<T>.Vertex> allVertex =  graph.getAllVertex();
		
		for (Graph<T>.Vertex vertex : allVertex) {
			if(!visited.contains(vertex)){
				visit(vertex, visited,stack);
			}
		}
		while(!stack.isEmpty()){
			sequence.add(stack.pop().id);
		}
		return sequence;
	}

	private void visit(Graph<T>.Vertex vertex, Set<Graph<T>.Vertex> visited, Stack<Graph<T>.Vertex> stack) {
		visited.add(vertex);
		List<Graph<T>.Vertex> adjList = vertex.adjList;
		for (Graph<T>.Vertex v : adjList) {
			if(!visited.contains(v)){
				visit(v, visited,stack);
			}
		}
		stack.push(vertex);
	}
	
}
