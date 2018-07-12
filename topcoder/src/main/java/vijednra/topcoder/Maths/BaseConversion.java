package vijednra.topcoder.Maths;

public class BaseConversion {

	static int toDecimal(int n, int b) {

		int res = 0;
		int multiplyer = 1;
		while (n > 0) {

			res += (n % 10) * multiplyer;
			multiplyer *= b;
			n /= 10;
		}
		return res;

	}
	static String fromDecimal(int n, int b){
		int result=0;
		String res="";
		int multiplyer=1;
		while(n>0){
			res = (char)('0'+(n%b)) +res;
			result +=(n%b)*multiplyer;
			multiplyer *=10;
			n/=b;
			
		}
		return res;
		
	}
	public static String fromDecimal2(int n, int b)
	{
	   String chars="0123456789ABCDEFGHIJ";
	   String result="";
	      
	   while(n>0)
	   {
	      result=chars.charAt(n%b) + result;
	      n/=b;
	   }
	      
	   return result;
	}

	public static void main(String[] args) {
		
	}
}