package org.xinjg.string;

public class KMP {
	private static final int R = 256;
	private int[][] dfa;
	private int m;
	public KMP(String pattern){
		m=pattern.length();
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
	/**
	 * 
	 *  author : xinjg
	 *	TODO	:	search pattern in txt, return txt.length() if not exists; 
	 *	@param txt
	 *	@return
	 */
	public int search(String txt){
		int n= txt.length();
		int i = 0,j=0;
		for (; i < n&&j<m; i++) {
			j=dfa[txt.charAt(i)][j];
		}
		if (j==m) {
			return i-m;
		}else
			return n;
	}
	
	public static void main(String[] args) {
		String pat = "Xx";
		KMP kmp=new KMP(pat);
		System.out.println( kmp.search("xxxxXxxx") );
	}
}
