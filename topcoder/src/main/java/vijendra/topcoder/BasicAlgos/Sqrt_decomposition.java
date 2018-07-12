package vijendra.topcoder.BasicAlgos;

public class Sqrt_decomposition {

	public static void main(String [] args){
		
		int [] arr = new int [] {1,2,2,32,45,3,4,5,2,1,4,5,6,7,2};
		int n = arr.length ;
		int len = (int)Math.sqrt(n+.0)+1;
		int [] b = new int[len];
		for (int i=0;i<n;i++){
			b[i/len] +=arr[i];
		}
		int l=4, r =7 ;
		int sum=0;
		for (int i=l;i<=r;){
			if(i%len==0 && i+len-1<=r){
				sum += b[i/len];
				i += len ;
			}else {
				sum += arr[i];
				i++;
			}
			
		}
	System.out.println(sum);	
		
		
	}
	
}
