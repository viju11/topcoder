package vijednra.topcoder.Maths;

public class EularFunction {

	public static void main(String[] args) {
		int n = 10;
		System.out.println(phi(n));
	}

	private static int phi(int n) {
		int result = n;

		for (int i = 2; i * i < n; i++) {
			if (n % i == 0) {
				while (n % i == 0) {
					n /= i;
					result -= result / i;
				}
			}
		}
		if (n > 1)
			result -= result / n;
		return result;
	}

}
