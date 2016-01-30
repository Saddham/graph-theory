package com.timepass.graphtheory.revised;

import java.util.ArrayList;

public class Graph {
	private int V;
	private int E;
	private ArrayList<ArrayList<Integer>> adj;
	
	public Graph(int numberOfVertices){
		V = numberOfVertices;
		E = 0;
		adj = new ArrayList<ArrayList<Integer>>();
		for(int i=V-1; i>=0; i--){
			adj.add(new ArrayList<Integer>());
		}
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	
	private boolean validateVertex(int vertex){
		if(vertex>=V || vertex<0 ){
			throw new IndexOutOfBoundsException("Vertex should be between "+0+" and "+V);
		}
		return true;
	}
	
	public void addEdge(int v, int w){
		validateVertex(v);
		validateVertex(w);
		E++;
		adj.get(v).add(w);
		adj.get(w).add(v);
	}
	
	public Iterable<Integer> adj(int vertex){
		return adj.get(vertex);
	}
	
	public int degree(int vertex){
		return adj.get(vertex).size();
	}
	
    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj.get(v)) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
    
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        
        graph.addEdge(0, 9);
        graph.addEdge(7, 3);
        graph.addEdge(4, 6);
        graph.addEdge(1, 2);
        
        System.out.println(graph);
    }
}
