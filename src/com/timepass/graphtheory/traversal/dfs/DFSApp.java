package com.timepass.graphtheory.traversal.dfs;

import com.timepass.graphtheory.Graph;

class DFSApp
{
	public static void main(String[] args)
	{
		Graph theGraph = new Graph();
		theGraph.addVertex('A'); // 0 (start for dfs)
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4
		theGraph.addEdge(0, 1, 1); // AB
		theGraph.addEdge(1, 2, 1); // BC
		theGraph.addEdge(0, 3, 1); // AD
		theGraph.addEdge(3, 4, 1); // DE
		
		System.out.print("Visits: ");
		theGraph.dfs(); // depth-first search
		System.out.println();
	} // end main()
} // end class DFSApp
