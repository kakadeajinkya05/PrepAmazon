package TopologicalSort;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph<T> {
	public boolean isDirected;
	public Map<T, Vertex> allVertex = new HashMap<>();
	public void addEdge(T id1, T id2){
		Vertex v1 =  allVertex.computeIfAbsent(id1, Vertex::new);
		Vertex v2 =  allVertex.computeIfAbsent(id2, Vertex::new);
		Edge e = new Edge(v1,v2,0,true);
		v1.adVertexDetails(v2, e);
	}
	
	public void addEdge(T id1, T id2, int weight){
		Vertex v1 =  allVertex.computeIfAbsent(id1, Vertex::new);
		Vertex v2 =  allVertex.computeIfAbsent(id2, Vertex::new);
		Edge e = new Edge(v1,v2,weight,true);
		v1.adVertexDetails(v2, e);
	}
	
	public void addVertex(T id){
		allVertex.computeIfAbsent(id, Vertex::new);
	}
	
	
	@Override
	public String toString() {
		return "Graph [isDirected=" + isDirected + ", allVertex=" + allVertex + "]";
	}


	public class Vertex{
		T id;
		List<Vertex> adjList = new LinkedList<>();
		List<Edge> edges = new LinkedList<>();
		public Vertex(T id1){
			id = id1;
		}
		public void adVertexDetails(Vertex v, Edge e){
			adjList.add(v);
			edges.add(e);
		}
		@Override
		public String toString() {
			return "Vertex [id=" + id + ", adjList=" + adjList + ", edges=" + edges + "]";
		}
		
	}

	public class Edge{
		boolean isDirected;
		Vertex v1,v2;
		int weight;
		
		public Edge(Vertex v11, Vertex v22, int weight1, boolean isDirecred1){
			v1 = v11;
			v2 = v22;
			weight= weight1;
			isDirected = isDirecred1;
		}

		@Override
		public String toString() {
			return "Edge [isDirected=" + isDirected + ", v1=" + v1 + ", v2=" + v2 + ", weight=" + weight + "]";
		}
		
	}

	public Collection<Graph<T>.Vertex> getAllVertex() {
		return allVertex.values();
	}
}
