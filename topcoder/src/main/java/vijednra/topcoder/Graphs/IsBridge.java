package vijednra.topcoder.Graphs;

import java.util.Arrays;

public class IsBridge {
	static int N = 0;
	static int[][] g;
	static boolean[] visited;
	static int [] time_in ; 
	static int [] fup ; 
	static int timer = 1 ;
	public static void main(String [] args){
		N=7;
		
		g = new int [N][N];
		for (int i=0;i<N;i++){
			Arrays.fill(g[i], -1);
		}
		addedge(0,1);
		addedge(0,2);
		addedge(2,1);
		addedge(6,1);
		addedge(4,1);
		addedge(3,1);
		addedge(3,5);
		addedge(4,5);
		int parent =-1;
		visited = new boolean [N];
		time_in = new int [N];
		fup = new int [N];
		
		for (int i=0;i<N;i++){
			if(!visited[i]){
				dfs(i, parent);
			}
		}
		
		
	}
	private static void addedge(int i, int j) {
		g[i][j]=1;
		g[j][i] =1 ;
		// TODO Auto-generated method stub
		
	}
	private static void dfs(int u, int parent) {
		visited[u] = true ;
		time_in[u] = timer++;
		fup[u] = timer-1 ;
		for (int i=0;i<g[u].length;i++){
			int to = g[u][i] ;
			if(i==parent || to==-1) continue ;
			to = i ;
			if(visited[to]){
				fup[u] = Math.min(fup[u], time_in[to]);
			}else {
				dfs(to,u);
				fup[u] = Math.min(fup[u], fup[to]);
				if(fup[to]>time_in[u]){
					System.out.println(u +" to "+to +" is a bridge");
				}
				
			}
			
			
		}
		
	}

}
