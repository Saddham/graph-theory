package com.timepass.graphtheory.mst.prim;

import java.util.Map;
import java.util.Properties;

import com.timepass.graphtheory.Digraph;

public class PrimApp {

	public static void main(String[] args) {
		Digraph theGraph = new Digraph();
		theGraph.addVertex('A'); // 0 (start for dfs)
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4
		theGraph.addEdge(0, 1, 2); // AB
		theGraph.addEdge(1, 2, 4); // BC
		theGraph.addEdge(0, 3, 3); // AD
		theGraph.addEdge(3, 4, 1); // DE
		theGraph.addEdge(3, 1, 6); // DB
		theGraph.addEdge(4, 0, 7); // EA
		System.out.print("Visits: ");
	
		Prim prim = new Prim();
		Map properties = prim.mst(theGraph);
		
		System.out.println("MST: " + properties.get("mst"));
		System.out.println("Travelling cost: " + properties.get("cost"));

	}

}
