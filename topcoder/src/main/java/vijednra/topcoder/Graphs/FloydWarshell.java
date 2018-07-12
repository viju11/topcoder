package vijednra.topcoder.Graphs;

public class FloydWarshell {
	static int n = 4 ;
	static int INF=10000000;
	static int d[][] = new int [n][n];
	static int [][] g = new int [n][n];
	static int p[][] = new int [n][n];
	public static void main(String [] args ){
		
		g = new int[][] { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
                };
                int a=0 ,b=3 ;
                
          floydWarshell();
          if(d[a][b]==INF) System.out.println("NO path");
          printpath(a,b);
        
		
		
	}
	private static void printpath(int a, int b) {
		
		
		// TODO Auto-generated method stub
		
	}
	private static void floydWarshell() {
		 for (int i=0;i<n;i++)
        	 for (int j =0;j<n;j++){
        		 d[i][j] = g[i][j];
        	 }
         
		for (int k=0; k<n-1; ++k)
			for (int i=0; i<n; ++i)
				for (int j=0; j<n; ++j)
					if (d[i][k] < INF && d[k][j] < INF){
						p[i][j] = k ;
						d[i][j] = Math.min (d[i][j], d[i][k] + d[k][j]);
					}
		
	}

}
