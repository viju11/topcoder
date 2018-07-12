package vijednra.topcoder.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TopologicalSorting {
	static int n = 6;
	static int[][] g = new int[n][n];
	static boolean[] visited = new boolean[n];
	static int[] time_in = new int[n];
	static int[] time_out = new int[n];
	static int counter = 0 ; 
	static ArrayList<Integer> ans = new ArrayList<Integer>();
	public static void main(String[] args){
		for (int i=0;i<n;i++){
			Arrays.fill(g[i],1000000);
		}
		g[5][2]=1 ;
		g[5][0]=1 ;
		g[4][0]=1 ;
		g[4][1]=1 ;
		g[2][3]=1 ;
		g[3][1]=1 ;
		
		for (int i=0;i<n;i++){
			if(!visited[i])
				simple_dfs(i);
		}
		
		Collections.reverse(ans);
		for (int i=0;i<n;i++){
			System.out.print(ans.get(i)+" ");
		}
		visited = new boolean[n];
		
		for (int i=0;i<n;i++){
			if(!visited[i])
				dfs(i);
		}
		System.out.println();
		for (int i=0;i<n;i++){
			System.out.println(i+"  "+time_out[i]);
		}
		
	}
	private static void simple_dfs(int s) {
		visited[s]=true ;
		for (int i=0;i<g[s].length;i++){
			if(!visited[i] && g[s][i]==1){
				simple_dfs(i);
			}
		}
		ans.add(s);
		
	}
	public static void dfs(int s){
		visited[s]=true ;
		time_in[s] = counter ++;
		for (int i=0;i<g[s].length;i++){
			if(!visited[i] && g[s][i]==1){
				dfs(i);
			}
		}
		time_out[s] = counter++;
	}
}
