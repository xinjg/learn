package org.xinjg.string;
/**
 * Intuition:
 * 1.	Scan character in pattern from right to left;
 * 2. Can skip as many as m chars when finding one not in the pattern;
 * @author Administrator
 *
 */
public class BoyerMoore {
	private static final int R=256;
	private int m;
	private String pattern;
	private int[] right;
	
	public BoyerMoore(String pattern) {
		this.pattern=pattern;
		this.m=pattern.length();
		right=new int[R]; 
		for (int i = 0; i < right.length; i++) {
			right[i]=-1;
		}
		for (int i = 0; i < m; i++) {
			right[pattern.charAt(i)]=i;
		}
	}
	
	public int search(String txt){
		//Scan character in pattern from right to left
		// 1.  mismatch character 'T' not in pattern: increment i one character beyond 'T'	
		// 2.  mismatch character 'N' in pattern: align text 'N' with rightmost pattern 'N'
		// 3.  mismatch character 'E' in pattern: increment i by 1
		int n=txt.length();
		if (n<m)	return n;
		int skip;
		for (int i = 0; i <= n-m;i=i+skip) {
			skip=0;
			for (int j = m-1; j >-1;j-- ) {
				if (txt.charAt(i+j)!=pattern.charAt(j)) {		
						skip=max(1, j-right[txt.charAt(i+j)] );
					break;
				}
			}
			if (skip==0) return i;			
		}
		return n;
	}
	
	private int max(int a,int b){
		return a>b?a:b;
	}
	
	public static void main(String[] args) {
		String pattern ="XxXbb";
		BoyerMoore boyerMoore=new BoyerMoore(pattern);
		System.out.println(boyerMoore.search("aaXxxXxXbb"));
	}
}
