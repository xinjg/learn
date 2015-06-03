package org.xinjg.string;

public class KMPSearch {
	private static final int R = 256;
	private int[][] dfa;
	
	public KMPSearch(String pattern){
		int m=pattern.length();
		dfa = new int[R][m];
		dfa[pattern.charAt(0)][0]=1;
		for (int j = 1,x=0; j < m;j++) {
			for (int i = 0; i < R; i++) {//Mismatch
				dfa[i][j]=dfa[i][x];
			}
			dfa[pattern.charAt(j)][j]=j+1;//match
			x=dfa[pattern.charAt(j)][x];//set restart state
		}
	}
	
	public int search(String txt){
		return 0;
	}
}
