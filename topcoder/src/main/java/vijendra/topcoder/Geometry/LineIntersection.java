package vijendra.topcoder.Geometry;

public class LineIntersection {
	static double[] resPoint = new double[2];
	static double EPS = 1e-9;

	public static void main(String[] args) {
		double[] p1 = new double[] {0,0};
		double[] p2 = new double[] {1,0};
		double[] p3 = new double[] {2,0};
		double[] p4 = new double[] {3,0};
		boolean result = linetoLineIntersection(p1, p2, p3, p4);

	}

	private static boolean linetoLineIntersection(double[] p1, double[] p2, double[] p3, double[] p4) {
		// A is y2-y1
		// B is x1-x2 ;
		// C is Ax1+By1;
		// that makes the eq Ax+By=C

		double A1 = p2[1] - p1[1];
		double B1 = p1[0] - p2[0];
		double C1 = A1 * p1[0] + B1 * p1[1];

		double A2 = p4[1] - p3[1];
		double B2 = p3[0] - p4[0];
		double C2 = A2 * p3[0] + B2 * p3[1];
		
		//A1 = 4; B1 = -3 ;C1 = 11;
		//A2 = 6 ;B2 = 5 ; C2 = 7 ;
		double det = determinent(A1, B1, A2, B2);
		if (Math.abs(det) > EPS) {
			resPoint[0] = determinent(C1, C2, B1, B2) / det;
			resPoint[1] = determinent(A1, A2, C1, C2) / det;
			
			//for segment 
			return between (p1[0], p2[0],resPoint[0] ) && between (p1[1], p2[1],resPoint[1] )
					&& between (p3[0], p4[0],resPoint[0] ) && between (p3[1], p4[1],resPoint[1]);
			//return true;
		} else{
		
			double detAC = determinent(A1, A2, C1, C2) ;
			double detBC = determinent(B1, B2, C1, C2);
			/*// for segments 
			 * 
			 * if( Math.abs(detAC)<EPS && Math.abs(detBC)<EPS && intersect_1 (p1[0],p2[0],p3[0],p4[0]) &&
			 intersect_1 (p1[1],p2[1],p3[1],p4[1])){
				
				System.out.println("sagments intersect and have infinite many soutions");
			}*/
				
			if(Math.abs(det)<EPS && Math.abs(detAC)<EPS && Math.abs(detBC)<EPS){
				System.out.println("one on another");
			}
			else if (Math.abs(det)<EPS){
				System.out.println("paralle lines");
			}
			return false ;
		}

	}

	private static boolean between(double i, double j, double d) {
		return Math.min(i, j)<=d+EPS && Math.max(i, j)+EPS >=d;
		
	}

	private static double determinent(double a1, double b1, double a2, double b2) {
		return a1 * b2 - a2 * b1;
	}
public static boolean intersect_1(double a, double b, double c, double d) {
	if (a > b) {
		double t = a ;
		 a = b ;
		b = t ;
	}
	if (c > d)  {
		double t = c ;
	  c= d ;
	d = t ;
	}
	return Math.max(a,c) <= Math.min(b,d);
}
}
