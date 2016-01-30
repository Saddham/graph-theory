package com.timepass.graphtheory.revised;

import java.util.LinkedList;
import java.util.Queue;

public class PrimMST {
	private Edge [] edgeTo;
	private double [] distTo;
	private boolean [] marked;	
	private IndexMinPQ<Double> pq;
	
	public PrimMST(EdgeWeightedGraph graph, int source){
		edgeTo = new Edge[graph.V()];		
		pq = new IndexMinPQ<>(graph.V());
		distTo = new double[graph.V()];
		for (int i = 0; i < graph.V(); i++) {
			distTo[i] = Double.POSITIVE_INFINITY;
		}
		marked = new boolean[graph.V()];
		prim(graph, source);
/*		for(int i=0; i<graph.V(); i++){
			if(!marked[i])
				prime(graph, i);
		}*/
	}
	
	private void prim(EdgeWeightedGraph graph, int source){
		distTo[source] = 0.0;
		pq.insert(source, distTo[source]);
		while(!pq.isEmpty()){
			int v = pq.delMin();
			scan(graph, v);
		}
	}
	
	private void scan(EdgeWeightedGraph graph, int v) {
		marked[v] = true;
		for(Edge edge : graph.adj(v)){
			int w = edge.other(v);
			if(marked[w]) continue;
			if(edge.weight() < distTo[w]){
				edgeTo[w] = edge;
				distTo[w] = edge.weight();
				if(pq.contains(w))
					pq.decreaseKey(w, distTo[w]);
				else
					pq.insert(w, distTo[w]);
				
			}
				
		}
		
	}

	public Iterable<Edge> edges(){
		Queue<Edge> queue = new LinkedList<Edge>();
		for (int i = 0; i < edgeTo.length; i++) {
			if(edgeTo[i] != null)
				queue.add(edgeTo[i]);
		}
		
		return queue;
		
	}
	
    public double weight() {
        double weight = 0.0;
        for (Edge e : edges())
            weight += e.weight();
        return weight;
    }
	
    public static void main(String[] args) {
    	EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(10);
        
        edgeWeightedGraph.addEdge(new Edge(0, 9, 65.787665));
        edgeWeightedGraph.addEdge(new Edge(7, 9, 3.65));
        edgeWeightedGraph.addEdge(new Edge(0, 9, 20));
        edgeWeightedGraph.addEdge(new Edge(9, 2, 10));
        
        PrimMST mst = new PrimMST(edgeWeightedGraph, 0);
        for (Edge e : mst.edges()) {
            System.out.println(e);
        }
        System.out.printf("%.5f\n", mst.weight());
    }

}
