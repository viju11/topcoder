package vijednra.topcoder.Maths;


public class FractionClass {

	class Fraction {
		long a;
		long b;

		Fraction(long c, long d) {
			a = c;
			b = d;
		}

		void add(Fraction fr) {
			long aa = a * fr.b + b * fr.a;
			long bb = b * fr.b;
			a = aa;
			b = bb;
			Normalize();
		}

		void multiply(long m) {
			a *= m;
			Normalize();
		}

		void devide(long m) {
			b *= m;
			Normalize();
		}

		void Normalize() {
			long g = gcd(Math.abs(a), b);
			a /= g;
			b /= g;
		}

		private long gcd(long a, long b) {
			if (a % b == 0)
				return b;
			return gcd(b, a % b);
		}

		public String toString() {
			return String.valueOf(a) + "/" + String.valueOf(b);
		}
		
		public int[] multiplyComplex(int[] m, int[] n)
		{
		   int[] prod = {m[0]*n[0] - m[1]*n[1], m[0]*n[1] + m[1]*n[0]};
		   return prod;
		}
		public int[] addComplex(int[] m, int[] n)
		{
		   int[] add = {m[0]+n[0], m[1]+n[1]};
		   return add;
		}
		

	}

	public static void main(String[] args) {
		System.out.println("hellp");

	}

}
