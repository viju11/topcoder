package vijednra.topcoder.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BellmanFord {

	public class edge {
		int a, b;
		int cost;

		edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

	}

	static int V = 5;
	static int INF = 10000000;
	static int dist[] = new int[V];
	static int parent[] = new int[V];
	static ArrayList<edge> edges = new ArrayList<edge>();

	public static void main(String[] args) {
		BellmanFord b = new BellmanFord();
		Arrays.fill(dist, INF);
		Arrays.fill(parent, -1);
		int src = 0;
		dist[src] = 0;
		edges.add(b.new edge(0, 1, -1));
		edges.add(b.new edge(0, 2, 4));
		edges.add(b.new edge(1, 2, -2));
		edges.add(b.new edge(2, 0, -3));
		edges.add(b.new edge(1, 3, 2));
		edges.add(b.new edge(1, 4, 2));
		edges.add(b.new edge(3, 2, 5));
		edges.add(b.new edge(3, 1, 1));
		edges.add(b.new edge(4, 3, -3));

		int t = 4;
		bellmenfordNegativeCycle();
		//printPath(t);

	}

	private static void printPath(int t) {

		if (dist[t] == INF) {
			System.out.println("NO path from  to " + t);
		}

		else {
			ArrayList<Integer> path = new ArrayList<Integer>();
			for (int curr = t; curr != -1; curr = parent[curr]) {
				path.add(curr);
			}
			Collections.reverse(path);
			System.out.println("the path is");
			for (int a : path) {
				System.out.print(a + " -> ");
			}
		}
	}

	private static void bellmenford() {

		for (int i = 0; i < V - 1; i++) {
			boolean any = false;
			for (int j = 0; j < edges.size(); j++) {
				if (dist[edges.get(j).a] < INF) {
					if (dist[edges.get(j).b] > dist[edges.get(j).a] + edges.get(j).cost) {
						dist[edges.get(j).b] = dist[edges.get(j).a] + edges.get(j).cost;
						parent[edges.get(j).b] = edges.get(j).a;
						any = true;
					}
				}
			}
			if (!any) {
				break;
			}
		}

	}

	private static void bellmenfordNegativeCycle() {
		int x = -1;
		for (int i = 0; i < V; i++) {
			x = -1;
			for (int j = 0; j < edges.size(); j++) {
				if (dist[edges.get(j).a] < INF) {
					if (dist[edges.get(j).b] > dist[edges.get(j).a] + edges.get(j).cost) {
						dist[edges.get(j).b] = dist[edges.get(j).a] + edges.get(j).cost;
						parent[edges.get(j).b] = edges.get(j).a;
						x = edges.get(j).b;
					}
				}
			}
		}
		if (x == -1) {
			System.out.println("No negative Cycle ");
		} else {

			int y = x;
			for (int i = 0; i < V; ++i)
				y = parent[y];

			ArrayList<Integer> path = new ArrayList<Integer>();
			for (int cur = y;; cur = parent[cur]) {
				path.add(cur);
				if (cur == y && path.size() > 1)
					break;
			}
			Collections.reverse(path);
			System.out.println("Negative cycle: ");

			for (int i = 0; i < path.size(); ++i)
				System.out.print(path.get(i)+"->");

		}

	}

}
