package vijednra.topcoder.Maths;

public class PrimeNumberGenerator {
	static int N;

	public static void main(String[] args) {
		N = 1000;
		boolean[] prime = new boolean[N];
		for (int i = 0; i < N; i++) {
			prime[i] = true;
		}
		prime[1] = false;
		prime[0] = false;
		for (int i = 2; (i << 1) <= N;) {
			if (prime[i]) {
				int j = (i << 1);
				while (j < N) {
					prime[j] = false;
					j += i;
				}
			}
			if (i == 2)
				i++;
			else
				i += 2;
		}

		for (int i = 0; i < N; i++) {
			if (prime[i]) {
				System.out.println(i + " ");
			}
		}

	}

	private static String isPrime(int n) {
		if (n <= 1)
			return "NO";
		if (n == 2)
			return "YES";

		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return "NO";
			}
		}
		return "YES";
	}
}
