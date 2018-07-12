package vijendra.topcoder.Geometry;

public class AreaOfTriangleAndSign {

	// given three points and, p1, p2, p3. find the area of the triangle formed
	// by
	// and is it clockewise or counterclockwise (+).

	public static void main(String[] args) {
		int A[] = new int[] { 0, 0 };
		int B[] = new int[] { 1, 2 };
		int C[] = new int[] { 2, 1 };
		double area_of_triangle = area_of_triangle(A, B, C);
		System.out.println(area_of_triangle);

	}

	private static double area_of_triangle(int[] A, int[] B, int[] C) {
		int[] AB = new int[] { B[0] - A[0], B[1] - A[1] };
		int[] AC = new int[] { C[0] - A[0], C[1] - A[1] };
		return (AB[0] * AC[1] - AB[1] * AC[0]) / 2.0;

	}

	boolean clockwise(int[] A, int[] B, int[] C) {
		int[] AB = new int[] { B[0] - A[0], B[1] - A[1] };
		int[] AC = new int[] { C[0] - A[0], C[1] - A[1] };
		return (AB[0] * AC[1] - AB[1] * AC[0]) < 0;
	}

	boolean counter_clockwise(int[] A, int[] B, int[] C) {
		int[] AB = new int[] { B[0] - A[0], B[1] - A[1] };
		int[] AC = new int[] { C[0] - A[0], C[1] - A[1] };
		return (AB[0] * AC[1] - AB[1] * AC[0]) > 0;
	}
}
