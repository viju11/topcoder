package vijendra.topcoder.BasicAlgos;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FactorialPower {
	
	public static void main(String[] args) {
		int k = 10;
		int res = 10000;
		int n =15; 
		
		Map<Integer,Integer> pfac = findPrimeFactors(k);
		Set<Entry<Integer, Integer>> entrySet = pfac.entrySet();
		
		for (Map.Entry<Integer, Integer> m : entrySet){
			int a = m.getKey();
			int c = m.getValue();
			res = Math.min(res, fact_pow(n,a)/c);
		}
		System.out.println(res);
	}
	
	private static Map<Integer,Integer> findPrimeFactors(int k) {
		Map<Integer,Integer> pfac= new HashMap<Integer, Integer>();
		for (int i = 2; i * i <= k; i++) {

			if (k % i == 0) {
				int c = 0; 
				while (k % i == 0) {
					k /= i;
					c++;
				}
				pfac.put(i, c);
			}

		}
		if (k > 1)
			pfac.put(k,1);
		return pfac;
	}

	public static int fact_pow(int n, int k) {
		int res = 0;
		while (n > 0) {
			n /= k;
			res += n;
		}
		return res;
	}

}
