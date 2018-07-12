package vijednra.topcoder.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CycleInGraph {
	static int N = 5;
	static int[] color = new int[N];
	static int[] parent = new int[N];
	static int[][] g = new int[N][N];
	static int cycle_st, cycle_en;

	public static void main(String[] args) {
		for (int i = 0; i < N; i++) {
			Arrays.fill(g[i], 1000000);
		}

		g[0][1] =1 ;
		g [0][2] =1 ;
		g [1][2] =1 ;
		g [2][0] =1 ;
		g [2][3] =1 ;
		g [3][3] =1 ;
		
		/*g[3][4] = 1;
		g[4][3] = 1;*/

		cycle_st = -1;
		Arrays.fill(color, 0);
		Arrays.fill(parent, -1);

		for (int i = 0; i<N; i++) {
			if (dfs(i))
				break;
		}
		if (cycle_st == -1) {
			System.out.println("Acyclic");
		} else {
			
			if(cycle_en<cycle_st){
				int temp = cycle_en;
				cycle_en = cycle_st;
				cycle_st  = temp;
			}
			System.out.println("Cyclic");
			ArrayList<Integer> cycle = new ArrayList<Integer>();
			cycle.add(cycle_st);
			for (int v = cycle_en; v != cycle_st; v = parent[v]) {
				cycle.add(v);
			}
			cycle.add(cycle_st);
			Collections.reverse(cycle);
			for (int i = 0; i < cycle.size(); i++) {
				System.out.print(cycle.get(i) + " ");
			}
		}

	}

	private static boolean dfs(int u) {
		color[u] = 1;
		for (int i = 0; i < g[u].length; i++) {
			if (g[u][i] == 1 && i !=parent[u]) {
				int to = i;
				if (color[to] == 0) {
					parent[to] = u;
					if (dfs(to))
						return true;
				} else if (color[to] == 1) {
					cycle_st = u;
					cycle_en = to;
					return true;

				}
			}
		}
		color[u] = 2;
		return false;
	}

}
