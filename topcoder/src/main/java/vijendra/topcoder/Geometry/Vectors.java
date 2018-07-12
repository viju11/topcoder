package vijendra.topcoder.Geometry;

public class Vectors {

	/*
	 * //If you have two vectors (x1, y1) and (x2, y2), //then the sum of the
	 * two vectors is simply (x1+x2, y1+y2)
	 * 
	 * 
	 * 
	 * // the dot product of (x1, y1) and (x2, y2) is x1*x2 + y1*y2.
	 * //|A|.|B|cos(0) = x1*x2 + y1*y2 //Cos(90) = 0 two perpendicular lines
	 * //Cos(90) = 1 two parallel lines
	 * 
	 * 
	 * 
	 * //cross product of two 2-D vectors is x1*y2 - y1*x2 // A x B =
	 * |A||B|Sin(θ).
	 */

	// Compute the dot product AB ⋅ BC
	int dot(int[] A, int[] B, int[] C) {
		int[] AB = new int[2];
		int[] BC = new int[2];
		AB[0] = B[0] - A[0];
		AB[1] = B[1] - A[1];
		BC[0] = C[0] - B[0];
		BC[1] = C[1] - B[1];
		int dot = AB[0] * BC[0] + AB[1] * BC[1];
		return dot;
	}

	// Compute the cross product AB x AC
	int cross(int[] A, int[] B, int[] C) {
		int[] AB = new int[2];
		int[] AC = new int[2];
		AB[0] = B[0] - A[0];
		AB[1] = B[1] - A[1];
		AC[0] = C[0] - A[0];
		AC[1] = C[1] - A[1];
		int cross = AB[0] * AC[1] - AB[1] * AC[0];
		return cross;
	}

	// Compute the distance from A to B
	double distance(int[] A, int[] B) {
		int d1 = A[0] - B[0];
		int d2 = A[1] - B[1];
		return Math.sqrt(d1 * d1 + d2 * d2);
	}

	// Compute the distance from AB to C
	// if isSegment is true, AB is a segment, not a line.
	double linePointDist(int[] A, int[] B, int[] C, boolean isSegment) {
		double dist = cross(A, B, C) / distance(A, B);
		if (isSegment) {
			int dot1 = dot(A, B, C);
			if (dot1 > 0)
				return distance(B, C);
			int dot2 = dot(B, A, C);
			if (dot2 > 0)
				return distance(A, C);
		}
		return Math.abs(dist);
	}

	static double AreaOfPolygon(int[][] p) {

		int area = 0;
		int N = p.length;
		// We will triangulate the polygon
		// into triangles with points p[0],p[i],p[i+1]

		for (int i = 1; i  < N-1; i++) {
			int x1 = p[i][0] - p[0][0];
			int y1 = p[i][1] - p[0][1];
			int x2 = p[i + 1][0] - p[0][0];
			int y2 = p[i + 1][1] - p[0][1];
			int cross = x1 * y2 - x2 * y1;
			area += cross;
		}
		return Math.abs(area / 2.0);
	}
	
	
	double lineToLineIntersection(int[] p1, int[] p2, int[] p3, int[] p4) {

		/*
		 * A = y2-y1 
		 * B = x1-x2 
		 * C = A*x1+B*y1 
		 * making Ax+By=C //line equation from
		 * points
		 * 
		 * A1x + B1y = C1
		   A2x + B2y = C2

		 */
		int A1 = p2[1] - p1[1];
		int B1 = p1[0] - p2[0];
		int C1 = A1 * p1[0] + B1 * p1[1];

		int A2 = p4[1] - p3[1];
		int B2 = p3[0] - p4[0];
		int C2 = A1 * p3[0] + B1 * p3[1];
		
		double det = A1*B2 - A2*B1;
			    if(det == 0){
			        //Lines are parallel
			    }else{
			        double x = (B2*C1 - B1*C2)/det;
			        double y = (A1*C2 - A2*C1)/det;
			    }
			 /*   
			    //if this is a segment make sure x and y lies on the line segment
			    //min(x1,x2) ≤ x ≤ max(x1,x2) check this condition for both the linesegments
			    */
return 0.0;
	}

	public static void main(String [] args){
		int [][] p = new int [][] {{0,0},{4,0},{2,4}};
		 
		
		System.out.println(AreaOfPolygon(p));
		
	}
}
