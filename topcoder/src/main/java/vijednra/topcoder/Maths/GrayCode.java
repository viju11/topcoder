package vijednra.topcoder.Maths;

import java.util.Scanner;

public class GrayCode {

	// [module] gray
		public static int[] getGray(int n) {
			int[] ret = new int[1 << n];
			
			for (int i = 0; i < ret.length; i++) {
				ret[i] = i^(i>>1);
			}
			return ret;
		}

		public static void main(String[] args) {
			
			//Scanner in = new Scanner(System.in);
			int n = 3;
			int m = 1;
			int[] r = getGray(n);
			for (int i=0;i<9;i++){
				System.out.print(rev_g(r[i])+" ");	
			}
			System.out.println();
			int[] c = getGray(m);
			StringBuilder buf = new StringBuilder();
			for (int a : r) {
				for (int b : c) {
					buf.append((a << m) ^ b);
					buf.append(' ');
				}
				buf.setCharAt(buf.length() - 1, '\n');
			}
			//System.out.print(buf);
		}
		
		static int rev_g (int g) {
			int n = 0;
			for (; g>0; g>>=1)
				n ^= g;
			return n;
		}
}
