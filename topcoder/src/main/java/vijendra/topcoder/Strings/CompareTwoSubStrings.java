package vijendra.topcoder.Strings;

public class CompareTwoSubStrings {
	static int N;
	static final int p = 31;
	static long[] p_pow;
	static long[] hashes;

	public static void main(String[] args) {
		String ss = "vijendrajitendra";
		int i1 = 3;
		int i2 = 11;
		int len = 5;

		N = ss.length();
		p_pow = new long[N];
		hashes = new long[N];
		p_pow[0] = 1;
		// compute all powers of p
		for (int i = 1; i < N; i++) {
			p_pow[i] = p_pow[i - 1] * p;
		}

		// compute hashes of all perfixes
		for (int i = 0; i < N; i++) {
			hashes[i] = (ss.charAt(i) - 'a' + 1) * p_pow[i];
			if (i != 0)
				hashes[i] += hashes[i - 1];
		}
		long h1 = hashes[i1 + len - 1];
		if (i1 > 0)
			h1 -= hashes[i1 - 1];

		long h2 = hashes[i2 + len - 1];
		if (i2 > 0)
			h2 -= hashes[i2 - 1];
		
		if((i1<i2 && h1*p_pow[i2-i1]==h2) || i1>i2 && h1 == h2*p_pow[i1-i2]){
			System.out.println("Equal");
		}

	}

}
