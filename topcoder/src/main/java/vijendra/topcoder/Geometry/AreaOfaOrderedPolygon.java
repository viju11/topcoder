package vijendra.topcoder.Geometry;

public class AreaOfaOrderedPolygon {

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
	
	public static void main(String[] args){
		int [][] p = new int [][] {{0,0},{4,0},{2,4}};
		 
		//Peak's theorem. Finding the area of ​​a lattice polygon
		// S = I +B/2 -1 
		
		System.out.println(AreaOfPolygon(p));
	}
}
