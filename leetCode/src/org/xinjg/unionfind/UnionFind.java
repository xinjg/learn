package org.xinjg.unionfind;

public class UnionFind {
	private int[] a;
	public UnionFind(int n){
		a=new int[n];
		for(int i=0 ;i<n;i++ ){
			a[i]=i;
		}
	}
	
	public void union(int p,int q){
		int tagQ =a[q];
		int tagP = a[p];
		for( int i=0;i<a.length;i++ ){
			if(a[i]==tagQ)
				a[i]=tagP;
		}
	}
	
	
	public boolean isConnected(int p,int q){
		return a[p] ==a[q];
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder("[");
		for( int i=0;i<a.length;i++ ){
			if(i==(a.length-1) )
				sb.append(a[i]);
			else
				sb.append(a[i]).append(",");
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		UnionFind uf = new UnionFind(10);
		uf.union(0, 1);
		uf.union(8, 9);
		uf.union(0, 8);
		System.out.println( uf.toString() );
		System.out.println( uf.isConnected(5, 9) );
	}
}
