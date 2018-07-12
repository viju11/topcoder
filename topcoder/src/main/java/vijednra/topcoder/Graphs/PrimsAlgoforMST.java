package vijednra.topcoder.Graphs;

import java.util.Arrays;

public class PrimsAlgoforMST {

	static int N = 5;
	static int[][] g = new int[N][N];
	static boolean[] selected = new boolean[N];
	static int parent[] = new int[N];
	static int key[] = new int[N];

	public static void main(String [] args){
		g = new int [][]{{0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0},
           };
           
		Arrays.fill(key, Integer.MAX_VALUE);
		
		key[0]=0 ;
		parent[0] =-1;
		
		for (int i=0;i<N-1;i++){
			int v = getMinVextex();
			selected[v] = true ;
			
			for (int j = 0 ;j<g[v].length ;j++){
				if(g[v][j]>0 && !selected[j] && g[v][j]<key[j]){
					parent[j] = v ; 
					key[j] = g[v][j];
				}
			}
			
		}
		printMST();
		
	}

	private static void printMST() {
		for (int i=1;i<N;i++){
			System.out.println( parent[i]+ "  "+i);
		}
		// TODO Auto-generated method stub
		
	}

	private static int getMinVextex() {
		int index =-1 ; int min = Integer.MAX_VALUE ;
		for (int i=0;i<N;i++){
			if(!selected[i] && key[i]<min){
				min = key[i];
				index = i ;
			}
		}
		return index;
	}

}
