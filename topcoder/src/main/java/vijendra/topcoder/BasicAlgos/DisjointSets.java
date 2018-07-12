package vijendra.topcoder.BasicAlgos;

public class DisjointSets {

	static int []parent = new int [10];
	static int []rank = new int [10];
	public static void main(String [] args){
		for(int i=0;i<10;i++){
			make_set(i);
		}
		union_sets(0, 1);
		union_sets(2, 3);
		union_sets(4, 5);
		union_sets(3, 5);
		System.out.println(find_set(3));
		
	}
	static void make_set (int v) {
		parent[v] = v;
		rank[v] = 0;
	}
	 
	static int find_set (int v) {
		if (v == parent[v])
			return v;
		return parent[v] = find_set (parent[v]);
	}
	 
	static void union_sets (int a, int b) {
		a = find_set (a);
		b = find_set (b);
		if (a != b) {
			if (rank[a] < rank[b]){
				int t = a ;
				a = b ;
				b = t ; 
			}
				
			parent[b] = a;
			if (rank[a] == rank[b])
				++rank[a];
		}
	}
	
}
