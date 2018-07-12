package vijendra.topcoder.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringHashing {
	
	class pair {
		long hash;
		int index ;
		pair(long h,int i){
			this.hash = h;
			this.index = i ;
		}
		
	}
	public static void main(String [] args){
		StringHashing s = new StringHashing() ;
		
		String [] string = new String [] {
			"this","is","a","test","this","has","no","has","this","is","a","demo"	
		};
		ArrayList<pair> p = new ArrayList<pair>();
		for (int i=0;i<string.length ;i++){
			p.add(s.new pair(computeHash(string[i]), i));
		}
		
		Collections.sort(p,new Comparator<pair>() {

			public int compare(pair o1, pair o2) {
				if(o1.hash!=o2.hash){
					return Long.compare(o1.hash, o2.hash);
				}else {
					return Integer.compare(o1.index, o2.index);
				}
			}
		});
		
		List<String> group = new ArrayList<String>();
		String str ="";
		for (int i=1;i<string.length;i++){
			if(p.get(i).hash==p.get(i-1).hash){
				str+=(p.get(i-1).index)+" ";
			}
			else {
				str +=""+(p.get(i-1).index);
				group.add(str);
				str="";
			}
			
			
		}
		for (int i=0;i<group.size();i++){
			String[] split = group.get(i).split(" ");
			System.out.println(string[Integer.valueOf(split[0])]+"  "+split.length);
		}
		
		
		
	}

	private static long computeHash(String s) {
		final int p = 31 ;
		final int m = (int) (1e9+9) ;
		long hashvalue = 0 ;
		long p_pow = 1 ;
		for (int i=0;i<s.length();i++){
			char ch = s.charAt(i) ; 
			hashvalue = (hashvalue + (ch-'a'+1)*p_pow)%m ;  
			p_pow = (p_pow*p)%m ;
		}
		return hashvalue ;
		
	}

}
