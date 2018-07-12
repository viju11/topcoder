package vijednra.topcoder.Maths;

public class PowerOfANumber {
	public static void main(String [] args){
	int a=5,n=8;
	
	System.out.println(power(a, n));
}

	private static int power(int a, int n) {
		if(n==0) return 1;
		int b = power(a,n/2);
		if(n%2!=0){
			return b*b*a;
		}else 
		return b*b ;		
	}
	
	

}
