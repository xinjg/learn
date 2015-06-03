package org.xinjg.string;

public class SubStringSearch {
	public static int bruteForce(String txt,String pattern){
		int n=txt.length();
		int m=pattern.length();
		for (int i = 0; i < n; i++) {
			int j=0;
			for ( ; j < m; j++) {
				if (txt.charAt(i+j)!=pattern.charAt(j)) {
					break;
				}
			}
			if (j==m) {
				return i;
			}
		}
		return n;
	}
	
	public static void main(String[] args) {
		System.out.println( bruteForce("ABCABABA","CA") );
	}
}
