package vijednra.topcoder.Maths;

public class InverseInringModulo {

	
	public static void main(String [] args ){
		int a=7,m=5;
		int x_and_y [] = new int [2];
		
	 int g = extendedgcd(a,m,x_and_y);
	 if(g!=1){
		 System.out.println("No solution");
		 
	 }else {
		int  res = ((x_and_y[0]%m)+m)%m ;
		 System.out.println(res);
	 }
						//a*x =1 (mod m) ;
		
		
		
	}

	private static int extendedgcd(int a, int m, int[] x_and_y) {
		if(a==0){
			x_and_y[0] = 0;
			x_and_y[1] = 1;
			return m ;
		}
		int [] x1_and_y1 = new int [2];
		int g =  extendedgcd(m%a, a, x1_and_y1);
		x_and_y[0] = x1_and_y1[1] - (m/a)*x1_and_y1[0];
		x_and_y[1] = x1_and_y1[0];
		
		return g ;
	}
}
