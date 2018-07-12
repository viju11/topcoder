package vijednra.topcoder.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BFS {
static int N =9 ;
	static int[] parent = new int[N];
	static int[] distance = new int[N];
	static boolean[] used = new boolean[N];
	static int[][] g = new int[N][N];
	
	public static void main(String[] args) {
for (int i=0;i<N;i++){
	Arrays.fill(g[i], 10000);
}
		addEdge(0, 1, 0);
	    addEdge(0, 7, 1);
	    addEdge(1, 7, 1);
	    addEdge(1, 2, 1);
	    addEdge(2, 3, 0);
	    addEdge(2, 5, 0);
	    addEdge(2, 8, 1);
	    addEdge(3, 4, 1);
	    addEdge(3, 5, 1);
	    addEdge(4, 5, 1);
	    addEdge(5, 6, 1);
	    addEdge(6, 7, 1);
	    addEdge(7, 8, 1);
		
		
		int s = 0;
		/*SimpleBFS(g, s);
		int to =5;  // for path from start s to some vertex to 
		PrintPath(to);*/
		BFSfor01Gaph(s);
		

		
		

		/*
		 * Applications 
		 * 1.Search for the shortest path in an unweighted graph.
		 * 2. for connected componets 
		 * 3.Finding the solution of a problem (game)
		 * with the least number of moves if each state of the system can be
		 * represented by a vertex of the graph, and transitions from one state
		 * to another are called edges of the graph.
		 *  4. for an edge lying on shortest path (u,v)  
		 *  5. for a vertex lying on shortest path 
		 * 
		 */
	}

	private static void addEdge(int i, int j, int k) {
		g[i][j] = k ;
		g[j][i]  = k ; 
		// TODO Auto-generated method stub
		
	}

	private static void BFSfor01Gaph( int s) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i=0; i<distance.length; i++)
	        distance[i] = Integer.MAX_VALUE;
		
		distance[s] = 0;
		parent[s] = -1;
		queue.add(s);
		while(!queue.isEmpty()){
			int from = queue.remove();
			
			for (int i=0;i<g[from].length;i++){
				if((g[from][i]==0 ||g[from][i]==1) && distance[i] > distance[from]+g[from][i]){
					distance[i] = distance[from]+g[from][i];
					if(g[from][i]==0){
						queue.addFirst(i);
					}else {
						queue.add(i);
					}
				}
			}
		}
		for (int i=0;i<distance.length;i++){
			System.out.print(distance[i]+" ");
		}

	}

	private static void PrintPath(int to) {
		if (!used[to]) {
			System.out.println("NO PATH");
		} else {
			ArrayList<Integer> path = new ArrayList<Integer>();
			for (int v = to; v != -1; v = parent[v]) {
				path.add(v);
			}
			Collections.reverse(path);
			for (int i = 0; i < path.size(); i++) {
				System.out.println(path.get(i));
			}

		}
		
		
	}

	private static void SimpleBFS(int[][] g, int s) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		distance[s] = 0;
		parent[s] = -1;
		used[s] = true ;
		queue.add(s);
		while (!queue.isEmpty()) {
			int from = queue.remove();

			for (int i = 0; i < g[from].length; i++) {

				int to = g[from][i];
				if (used[to]) {
					used[to] = true;
					queue.add(to);
					parent[to] = from;
					distance[to] = distance[from] + 1;
				}

			}

		}

	}
}
