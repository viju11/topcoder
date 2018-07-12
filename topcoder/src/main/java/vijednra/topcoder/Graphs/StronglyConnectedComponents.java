package vijednra.topcoder.Graphs;

import java.util.Arrays;

public class StronglyConnectedComponents {
	static int k = 0;
	static int N = 0;
	static int[][] g;
	static int[][] gr;
	static int[] order;
	static int[] component;
	static boolean[] visited;

	public static void main(String[] args) {
	
		N = 5;
		g = new int[N][N];
		gr = new int[N][N];
		order = new int[N];
		component = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(g[i], 100000);
			Arrays.fill(gr[i], 100000);
		}
		for (int j = 0; j < N; j++) {
			component[j] = -1;
		}
		g[1][0] = 1;
		g[0][2] = 1;
		g[2][1] = 1;
		g[0][3] = 1;
		g[3][4] = 1;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (g[i][j] == 1)
					gr[j][i] = 1;

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				dfs1(i);
			}
		}
		k = 0;
		Arrays.fill(visited, false);
		for (int i = 0; i < N; i++) {
			int u = order[N - i - 1];
			if (!visited[u]) {
				k=0;
				dfs2(u);
				for (int a : component) {
					System.out.print(a + " ");
				}
				for (int j = 0; j < N; j++) {
					component[j] = -1;
				}
				System.out.println();
			}
		}

	}

	private static void dfs2(int u) {
		visited[u] = true;
		component[k++] = u;
		for (int i = 0; i < gr[u].length; i++) {
			if (gr[u][i] == 1) {
				int to = i;
				if (!visited[to]) {
					dfs2(to);

				}
			}
		}
		// TODO Auto-generated method stub

	}

	private static void dfs1(int u) {
		visited[u] = true;

		for (int i = 0; i < g[u].length; i++) {
			if (g[u][i] == 1) {

				int to = i;

				if (!visited[to]) {
					dfs1(to);
				}
			}
		}
		order[k++] = u;

		// TODO Auto-generated method stub

	}

}
