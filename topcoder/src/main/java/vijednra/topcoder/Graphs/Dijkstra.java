package vijednra.topcoder.Graphs;

import java.util.Arrays;

public class Dijkstra {
	static int N = 9;
	static int[] dist = new int[N];
	static int[][] g = null;
	static boolean[] visited = new boolean[N];

	public static void main(String[] args) {

		Arrays.fill(dist, Integer.MAX_VALUE);
		int src = 0;
		
		g = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
				{ 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

				dijkstra(src);
		for (int i = 0; i < N; i++) {
			System.out.println(i +"  " +dist[i] );
		}
	}

	private static void dijkstra(int src) {
		dist[src] = 0;
		for (int i = 0; i < N; i++) {

			int u = findMin();
			visited[u] = true;

			for (int j = 0; j < g[u].length; j++) {
				if (g[u][j] == 0)
					continue;
				if (!visited[j] && dist[j] == Integer.MAX_VALUE) {
					dist[j] = dist[u] + g[u][j];
				} else if (!visited[j] && dist[j] > dist[u] + g[u][j]) {
					dist[j] = dist[u] + g[u][j];
				}
			}

		}

	}

	private static int findMin() {
		int min = Integer.MAX_VALUE;
		int u = 0;
		for (int i = 0; i < N; i++) {
			if (dist[i] < min && !visited[i]) {
				min = dist[i];
				u = i;
			}
		}
		return u;
	}

}
