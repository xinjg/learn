package org.xinjg.unionfind;

public class QuickUnionFind {

	private int tag[];
	public QuickUnionFind(int n) {
		tag=new int[n];
		for(int i=0 ;i<n;i++ ){
			tag[i]=i;
		}
	}

	private int root(int p){
		while( p!= tag[p] ){
			p =  tag[p] ;
		}
		return p;
	}
	
	public void union(int p,int q){
		tag[root(p)]=root(q);
	}
	
	public boolean isConnected(int p,int q){
		return root(p)==root(q);
	}
}
