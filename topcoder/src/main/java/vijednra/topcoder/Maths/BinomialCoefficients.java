package vijednra.topcoder.Maths;

public class BinomialCoefficients {

	static int N=10;
	static long C[][] = new long [N][N] ;
	public static void main(String args []){
		calculate_coffs();
		for (int n=0;n<N;n++){
			
			for (int k=0;k<=n;k++){
				System.out.print(C[n][k]+" ");
			}
		System.out.println();
	}
}

	
	public static void calculate_coffs(){
		for (int n=0;n<N;n++){
		C[n][0]=C[n][n] =1 ;
		for (int k=1;k<n;k++){
			C[n][k] = C[n-1][k-1]+C[n-1][k] ;
		}
			
		}
		
		
	}
	
	
	public static long  b_coff(int n , int k){
		
	if(k > (n-k)) k = n-k ;
	
	double res = 1 ;
	for (int i=1;i<=k;i++){
		res  = res*(n-i+1)/i;
	}
	return (long) (res+0.01);
	}
}
