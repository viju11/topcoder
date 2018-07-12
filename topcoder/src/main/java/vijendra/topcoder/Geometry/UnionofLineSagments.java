package vijendra.topcoder.Geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UnionofLineSagments {
	class pair {
		int x;
		int y;

		pair(int a, int b) {
			x = a;
			y = b;
		}

	}
	class pair2 {
		int x;
		boolean flag; 

		pair2(int a, boolean f) {
			x = a;
			flag = f;
		}

	}
	static UnionofLineSagments u = new UnionofLineSagments() ;
	public static void main(String [] args){
		ArrayList<pair> segments = new ArrayList<pair>();
		segments.add(u.new pair(5,10));
		segments.add(u.new pair(4,8));
		segments.add(u.new pair(8,12));
		//find the lenght of union of segments 
		int result = lenght_union_of_segments(segments);
		System.out.println(result);
		
		
	}
	private static  int  lenght_union_of_segments(ArrayList<pair> segments) {
		int n = segments.size() ; 
		ArrayList<pair2> res = new ArrayList<pair2>(Collections.nCopies(2*n, u.new pair2(0,false)));
		
		for (int i=0;i<n;i++){
			res.set(2*i, u.new pair2(segments.get(i).x,false));
			res.set(2*i+1, u.new pair2(segments.get(i).y,true));
		}
		Collections.sort(res,(a,b)->Integer.compare(a.x, b.x) );
		
		
		int counter = 0;
		int result = 0; 
		for (int i=0;i<2*n;i++){
			if(counter>0) result += res.get(i).x-res.get(i-1).x;
			counter += res.get(i).flag ? -1 : 1 ;
			
		}
		
		return result;
	}
}
