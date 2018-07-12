package vijednra.topcoder.Graphs;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {
static int [][] g = new int [10][10];
static boolean visited [] = new boolean [10];
static List<Integer> comp  = new ArrayList<Integer>();

	public static void main(String [] args){
		
		for (int i=0;i<10;i++){
			if(!visited[i]){
				
				dfs(i);
				for (int a:comp){
					System.out.print(a+" ");
				}
				
			}
			
		}
		
		
	}

	private static void dfs(int u) {
		visited[u] =true ;
		comp.add(u);
		for (int i=0;i<g[u].length;i++){
			int v = g[u][i];
			if(!visited[v]){
				dfs(v);
			}
		}
		
	}
}
