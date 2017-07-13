package TopologicalSort;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class basic {

	static class Graph{
		int v; // # of vertices
		List<Integer> adj[]; // adjecancy list
		
		Graph(int vertices){
			v = vertices;
			adj = new LinkedList[v];
			for(int i=0;i<v;i++){
				adj[i] = new LinkedList<>();
			}
		}
		
		public void addEdge(int v, int c){
			adj[v].add(c);
		}
		
		private void topologicalSort(int v, Stack<Integer> s, boolean []visited){
			visited[v] =  true;
			List<Integer> adjList = adj[v];
			for(Integer verex : adjList){
				if(visited[verex]  == false){
					topologicalSort(verex, s, visited); 
				}
			}
			s.push(v);
		}
		
		public void topologicalSort(){
			Stack<Integer> s = new Stack<>();
			boolean visited[] = new boolean[v];
			for(int i=0;i<v;i++){
				visited[i] = false;
			}
			for(int i=0;i<v;i++){
				if(visited[i] == false){
					topologicalSort(i,s,visited);
				}
			}
			while(!s.isEmpty()){
				System.out.print(s.pop() + " ");
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.topologicalSort();
	}

}
