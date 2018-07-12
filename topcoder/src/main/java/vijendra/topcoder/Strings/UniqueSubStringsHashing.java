package vijendra.topcoder.Strings;

import java.util.HashSet;

public class UniqueSubStringsHashing {
	static int N;
	static final int p = 31;
	static long[] p_pow;
	static long[] hashes;
	
	public static void main(String []args){
		String ss = "vvv";
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
		int result =0 ;
		for (int l=1;l<=N;l++){
			HashSet<Long> hs = new HashSet<>(); 
			for (int i=0;i<=N-l ; i++){
				long hash  = hashes[i+l-1];
				if(i!=0)
				hash -= hashes[i-1] ;
				// we bring all hashes to one degree
				hash *=p_pow[N-i-1];
				hs.add(hash);
			}
			result += hs.size() ;
		}
		
		System.out.println(result);
	}

}
