package com.timepass.graphtheory.revised;

public class Edge implements Comparable<Edge>{
	private int V;
	private int W;
	private double weight;
	
	public Edge(int v, int w, double weight){
		if(v < 0) throw new IndexOutOfBoundsException();
		if(w < 0) throw new IndexOutOfBoundsException();
		if(Double.isNaN(weight)) throw new IllegalArgumentException();
		
		V = v;
		W = w;
		this.weight = weight;
	}
	
	public double weight(){
		return weight;
	}
	
	public int either(){
		return V;
	}
	
	public int other(int x){
		if(x == V) return W;
		else if(x == W) return V;
		else throw new IllegalArgumentException();
	}
	
	@Override
	public int compareTo(Edge that) {
        if(this.weight < that.weight) return -1;
        else if(this.weight > that.weight) return +1;
        
		return 0;
	}
	
	@Override
	public String toString() {	
		return String.format("%d-%d %.5f", V, W, weight);
	}
	
    public static void main(String[] args) {
        Edge e = new Edge(12, 23, 3.14);
        System.out.println(e);
    }
}
