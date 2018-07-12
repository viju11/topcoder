package vijednra.topcoder.Graphs;

import java.util.ArrayList;
import java.util.Collections;

public class KrushalAlgowithDSU {

	class Edge implements Comparable<Edge>
    {
        int src, dest, weight;
        Edge(int s,int d,int w){
        	this.src=s;
        	this.dest=d;
        	this.weight = w ;
        }
        public int compareTo(Edge compareEdge)
        {
            return Integer.compare(this.weight,compareEdge.weight);
        }
    }
	static int V =5 ;
	static int []parent = new int [V];
	static int []rank = new int [V];
	
	public static void main(String [] args){
		ArrayList<Edge> edges = new ArrayList<Edge>() ;
		ArrayList<Edge> result = new ArrayList<Edge>() ;
		KrushalAlgowithDSU k = new KrushalAlgowithDSU() ;
		
		edges.add(k.new Edge(0,1,10));
		edges.add(k.new Edge(0,2,6));
		edges.add(k.new Edge(0,3,5));
		edges.add(k.new Edge(3,1,15));
		edges.add(k.new Edge(2,3,4));
		for (int i=0;i<V;i++){
			make_set(i);
		}
		Collections.sort(edges);
		for (Edge e : edges){
			
			if(find_set(e.src)!=find_set(e.dest)){
				result.add(e);
				union_sets(e.src, e.dest);
			}
			
		}
		for (Edge e : result){
			System.out.println( e.src +" "+e.dest);
		}
		
	}
	
	static void make_set (int v) {
		parent[v] = v;
		rank[v] = 0;
	}
	 
	static int find_set (int v) {
		if (v == parent[v])
			return v;
		return parent[v] = find_set (parent[v]);
	}
	 
	static void union_sets (int a, int b) {
		a = find_set (a);
		b = find_set (b);
		if (a != b) {
			if (rank[a] < rank[b]){
				int t = a ;
				a = b ;
				b = t ; 
			}
				
			parent[b] = a;
			if (rank[a] == rank[b])
				++rank[a];
		}
	}
	
}
