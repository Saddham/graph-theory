package com.timepass.graphtheory.revised;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DepthFirstPaths {
	private boolean [] marked;
	private int [] edgeTo;
	private final int source;
	
	public DepthFirstPaths(Graph graph, int source){
		this.source = source;
		marked = new boolean[graph.V()];
		edgeTo = new int[graph.V()];
		dfs(graph, source);
	}
	
	
	private void dfs(Graph graph, int v) {
		marked[v] = true;
		
		for (int w : graph.adj(v)) {
			if(!marked[w]){
				edgeTo[w] = v;
				dfs(graph, w);
			}
		}		
	}

	private boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		
		List<Integer> queue = new LinkedList<Integer>();
		for (int i = v; i != source; i = edgeTo[i]) {
			queue.add(i);
		}
		
		queue.add(source);
		Collections.reverse(queue);
		return queue;
	}
	

	public static void main(String[] args) {		
        Graph graph = new Graph(10);
        
        graph.addEdge(0, 9);
        graph.addEdge(9, 3);
        graph.addEdge(3, 6);
        graph.addEdge(6, 2);
        
        int source = 0;
        
		DepthFirstPaths dfs = new DepthFirstPaths(graph, source);

        for (int v = 0; v < graph.V(); v++) {
            if (dfs.hasPathTo(v)) {
                System.out.printf("%d to %d:  ", source, v);
                for (int x : dfs.pathTo(v)) {
                    if (x == source) System.out.print(x);
                    else        System.out.print("-" + x);
                }
                System.out.println();
            }

            else {
                System.out.printf("%d to %d:  not connected\n", source, v);
            }

        }
	}
}
