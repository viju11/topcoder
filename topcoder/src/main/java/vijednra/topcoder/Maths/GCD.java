package vijednra.topcoder.Maths;

public class GCD {
	static int gcd_for_large_numbers(int a, int b) {
		if (a == 0)
			return b;
		if (b == 0)
			return a;
		if (a % 2 == 0 && b % 2 == 0)
			return gcd_for_large_numbers(a / 2, b / 2) * 2;
		else if (a % 2 == 0)
			return gcd_for_large_numbers(a / 2, b);
		else if (b % 2 == 0)
			return gcd_for_large_numbers(a, b / 2);
		else
			return (a >= b ? gcd_for_large_numbers(b, a % b) : gcd_for_large_numbers(a, b % a));
	}

	static int gcd(int a, int b) {
		return (b > 0 ? gcd(b, a % b) : Math.abs(a));
	}

	static int extended_gcd(int a, int b, int[] xandy) {
		// base case
		if (a == 0) {
			xandy[0] = 0;
			xandy[1] = 1;
			return b;
		}
		int[] x1andy1 = { 1, 1 };
		int gcd = extended_gcd(b % a, a, x1andy1);
		xandy[0] = x1andy1[1] - (b / a) * x1andy1[0];
		xandy[1] = x1andy1[0];
		return gcd;

	}

	static int lcm(int a, int b) {
		return a / gcd(a, b) * b;
	}

	public static void main(String[] args) {
		int a = 12;
		int b = 8;
		for (int i = a; i > 0; i--) {
			if (a % i == 0 && b % i == 0) {
				System.out.println(i);
				System.out.println(gcd(a, b));
				System.out.println(gcd_for_large_numbers(a, b));
				int[] xandy = new int[2];
				xandy[0] = 1;
				xandy[1] = 1;
				extended_gcd(a, b, xandy);
				System.out.println(xandy[0] + "*" + a + " + " + xandy[1] + "*" + b);
				break;

			}
		}

	}

}
