package vijednra.topcoder.Maths;

import java.util.ArrayList;
import java.util.Collections;

public class LongArithmatic {
	static ArrayList<Integer> lnum = null;
	static int base = 10;

	public static void main(String[] args) {
		lnum = new ArrayList<Integer>();
		String aa = "10000";
		String bb = "9999";
		ArrayList<Integer> a = parseString(aa);
		ArrayList<Integer> b = parseString(bb);
		
		ArrayList<Integer> c = multiplication(a, b);
		RemoveLeadingZeros(c);
		PrintNum(c);

	}
	
	private static void multiplication_with_a_shortNum(ArrayList<Integer> a, int  b) {
		
		int carry = 0;
		for(int i=0;i<a.size()||carry>0;i++){
			if(i==a.size())
				a.add(0);
			a.set(i, a.get(i)*b+carry);
			carry = a.get(i)/base ;
			a.set(i, a.get(i)%base);
		}
		
	}
	public static ArrayList<Integer> multiplication(ArrayList<Integer> a, ArrayList<Integer> b){
		ArrayList<Integer> c = new ArrayList<Integer>(Collections.nCopies(a.size()+b.size(), 0));
		int carry =0;
		for (int i=0;i<a.size();i++){
			carry =0 ;
			for (int j=0;j<b.size()||carry>0; j++){
				int curr = c.get(i+j)+carry + a.get(i)*(j<b.size()?b.get(j):0);
				c.set(i+j, curr%base);
				carry = curr/base ;
			}
		}
		return c ;
	}

	private static void addition(ArrayList<Integer> a, ArrayList<Integer> b) {
		int carry = 0;
		for (int i = 0; i < Math.max(a.size(), b.size()) || carry > 0; i++) {
			if (i == a.size())
				a.add(0);
			a.set(i, a.get(i) + carry + (i < b.size() ? b.get(i) : 0));
			carry = a.get(i) / base;
			if (carry > 0)
				a.set(i, a.get(i) % base);

		}

	}

	private static void subtraction(ArrayList<Integer> a, ArrayList<Integer> b) {
		int carry = 0;
		for (int i = 0; i < b.size() || carry > 0; i++) {
			a.set(i, a.get(i) - (i < b.size() ? b.get(i) : 0) - carry);
			if (a.get(i) < 0)
				carry = 1;
			else
				carry = 0;
			if (carry > 0) {
				a.set(i, a.get(i) + base);
			}

		}

	}

	private static ArrayList<Integer> parseString(String aa) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = aa.length() - 1; i >= 0; i--) {
			a.add(Integer.valueOf(aa.charAt(i) - '0'));
		}
		return a;

	}

	private static void RemoveLeadingZeros(ArrayList<Integer> lnum) {
		int i = lnum.size() - 1;
		while (lnum.size() > 0 && !lnum.isEmpty() && lnum.get(i) == 0) {
			lnum.remove(i);
			i--;
		}

	}

	public static void PrintNum(ArrayList<Integer> lnum) {
		System.out.print(lnum.isEmpty() ? 0 : lnum.get(lnum.size() - 1) + "");
		for (int i = lnum.size() - 2; i >= 0; i--) {
			System.out.print(lnum.get(i) + "");
		}
	}

}
