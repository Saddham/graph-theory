package com.timepass.graphtheory.mst.prim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.timepass.graphtheory.*;

public class Prim {
	List<Character> mstSet = new ArrayList<Character>(); 
	int travellingCost;
	
	public Map mst(Digraph graph){
		Map properties = new HashMap();
		Stack<Integer> theStack = new Stack<Integer>();
		
		// begin at vertex 0
		graph.getVertexList()[0].wasVisited = true; // mark it
		mstSet.add(graph.getVertexList()[0].label);
		theStack.push(0); // push it
		
		while( !theStack.isEmpty() ) // until stack empty,
		{
			// get an unvisited vertex adjacent to stack top
			int v = getAdjUnvisitedVertex(graph, theStack.peek() );
			if(v == -1) // if no such vertex,
				theStack.pop(); // pop a new one
			else // if it exists,
			{
				graph.getVertexList()[v].wasVisited = true; // mark it
				mstSet.add(graph.getVertexList()[v].label);
				travellingCost = travellingCost + graph.getAdjMat()[theStack.peek()][v];
				System.out.println(graph.getVertexList()[theStack.peek()].label);
				theStack.push(v); // push it
			}
		} // end while
		
		
		System.out.println(travellingCost);
		properties.put("mst", mstSet);
		properties.put("cost", travellingCost);
		
		return properties;
	}
	
	// returns an unvisited vertex adjacent to v
	public int getAdjUnvisitedVertex(Digraph digraph, int v)
	{
		int closest = -1;
		int lowestCost = Integer.MAX_VALUE;
		
		for(int j=0; j<digraph.getnVerts(); j++){
			int curCost = digraph.getAdjMat()[v][j];
			if((curCost > 0) && (digraph.getVertexList()[j].wasVisited==false)){
				if(curCost < lowestCost){
					/*System.out.println(graph.getVertexList()[j].label);
					System.out.println(j);*/
					lowestCost = curCost;
					closest = j;
					System.out.println(lowestCost);
				}
			}			
		}	
		
		if(v == 1)
		System.out.println(closest);
		return closest; // no such vertices
	} // end getAdjUnvisitedVert()
}
