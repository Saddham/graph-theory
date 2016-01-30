package com.timepass.graphtheory.revised;

import java.util.ArrayList;

public class EdgeWeightedGraph {
	private int V;
	private int E;
	private ArrayList<ArrayList<Edge>> adj;
	
	public EdgeWeightedGraph(int numberOfVertices){
		V = numberOfVertices;
		E = 0;
		adj = new ArrayList<ArrayList<Edge>>();
		for(int i=V-1; i>=0; i--){
			adj.add(new ArrayList<Edge>());
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
	
	public void addEdge(Edge edge){
		int v = edge.either();
		int w = edge.other(v); 
		validateVertex(v);
		validateVertex(w);
		E++;
		
		adj.get(v).add(edge);
		adj.get(w).add(edge);
	}
	
	public Iterable<Edge> adj(int vertex){
		return adj.get(vertex);
	}
	
	public int degree(int vertex){
		return adj.get(vertex).size();
	}
	    
   public Iterable<Edge> edges() {
       ArrayList<Edge> list = new ArrayList<Edge>();
       for (int v = 0; v < V; v++) {
           int selfLoops = 0;
           for (Edge e : adj(v)) {
               if (e.other(v) > v) {
                   list.add(e);
               }
               // only add one copy of each self loop (self loops will be consecutive)
               else if (e.other(v) == v) {
                   if (selfLoops % 2 == 0) list.add(e);
                   selfLoops++;
               }
           }
       }
       return list;
   }
	
	
    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (Edge e : adj.get(v)) {
                s.append(e + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
    
    public static void main(String[] args) {
    	EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(10);
        
        edgeWeightedGraph.addEdge(new Edge(0, 9, 65.787665));
        edgeWeightedGraph.addEdge(new Edge(7, 3, 3.65));
        edgeWeightedGraph.addEdge(new Edge(4, 6, 20));
        edgeWeightedGraph.addEdge(new Edge(1, 2, 10));
        
        System.out.println(edgeWeightedGraph);
    }
}
