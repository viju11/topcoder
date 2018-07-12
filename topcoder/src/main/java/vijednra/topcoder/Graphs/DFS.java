package vijednra.topcoder.Graphs;

import java.util.Arrays;

public class DFS {
	static int n = 10;
	static int[][] g = new int[n][n];
	static boolean[] visited = new boolean[n];
	static int time_in[] = new int[n];
	static	int time_out[] = new int[n];
	static int color[] = new int[n];
	static int time_counter=0 ;

	public static void main(String[] args) {
		int startingVertex = 0;
		Arrays.fill(color, 0); // color will have value 0,1,2
		dfs(startingVertex);
		simple_dfs(startingVertex);

	}

	private static void simple_dfs(int s) {
		visited[s]=true ;
		for (int i=0;i<g[s].length;i++){
			if(!visited[i]){
				simple_dfs(i);
			}
		}
		
	}

	private static void dfs( int v) {
		color[v] =1;
		time_in[v] = time_counter++;
		for (int i=0;i<g[v].length;i++){
			if(color[i]==0){
				dfs(i);
			}
		}
		color[v]=2;
		time_out[v]=time_counter++;
	}
}
