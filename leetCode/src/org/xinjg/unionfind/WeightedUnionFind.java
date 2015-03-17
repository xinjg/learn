package org.xinjg.unionfind;

public class WeightedUnionFind {
	private int[] tag;
	private int[] cnt;
	public WeightedUnionFind(int n){
		tag = new int[n];
		cnt = new int[n];
		for( int i=0;i<n;i++ ){
			tag[i]=i;
			cnt[i]=1;
		}
	}
	
	private int root(int p){
		while( p!=tag[p] ){
			//Path compression(  tag[p]=tag[ tag[p] ] )
			p=tag[p];
		}
		return p;
	}
	
	public void union( int p,int q ){
		int rP=root(p);
		int rQ=root(q);
		if( cnt[rP] >=cnt[rQ]){
			tag[rQ] = rP;
			cnt[rP] =cnt[rQ]+cnt[rP];
		}else{
			tag[rP] = rQ;
			cnt[rQ] =cnt[rP]+cnt[rQ];
		}
	}
	
	public boolean isConnected( int p,int q ){
		return root(p)==root(q);
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder("[");
		for( int i=0;i<tag.length;i++ ){
			if(i==(tag.length-1) )
				sb.append(tag[i]);
			else
				sb.append(tag[i]).append(",");
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		WeightedUnionFind wuf = new WeightedUnionFind(10);
		wuf.union(0, 1);
		wuf.union(1, 2);
		wuf.union(2, 3);
		wuf.union(8, 9);
		System.out.println( wuf.toString() );
		wuf.union(3, 9);
		System.out.println(wuf.toString());
		System.out.println( wuf.isConnected(0, 9) );
	}
}
