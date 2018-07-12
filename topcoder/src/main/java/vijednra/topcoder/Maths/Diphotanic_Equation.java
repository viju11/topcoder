package vijednra.topcoder.Maths;

public class Diphotanic_Equation {
	
	static int extended_gcd(int a,int b, int[] xandy){
		//base case 
		if(a==0){
			xandy[0] = 0;
			xandy[1] = 1;
			return b ;
			}
		int [] x1andy1 = {1,1};
		int gcd = extended_gcd(b%a,a,x1andy1);
		xandy[0] = x1andy1[1] -(b/a)*x1andy1[0];
		xandy[1] =  x1andy1[0];
		return gcd;
		
		
		
	}
	
	public static void main (String []args){
		//ax + by = c 
		int x_and_y[] = new int [2];
		findSolution(2, 4, 16, x_and_y, 0);
		
		
	}
	public static boolean  findSolution(int a,int b,int c ,int [] x_and_y,int g){
		g = extended_gcd(Math.abs(a), Math.abs(b), x_and_y);
		if(c%g!=0) return false ;
		x_and_y[0] *= c/g;
		x_and_y[1] *= c/g;
		if(a<0) x_and_y[0] *=-1;
		if(b<0) x_and_y[1] *=-1;
		return true ;
		
	}
}
