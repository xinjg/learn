package org.xinjg.leetcode;

import java.util.Arrays;

public class PlusOne {
	public int[] plusOne(int[] digits) {
        int len = digits.length;
        int plus=1;
        int pos=len-1;
        while (pos>=0&&plus>0) {
			plus=digits[pos]+plus;
			if (plus>=10) {//
				digits[pos]=plus%10;
				plus=1;
				pos--;
			}else {
				digits[pos]=plus;
				return digits;
			}
		}
        
        if (plus >0) {
			int[] res = new int[len+1];
			res[0]=plus;
			for (int i = 0; i < digits.length; i++) {
				res[i+1]=digits[i];
			}
			return res;
		}
        return digits;
    }
	
	public static void main(String[] args) {
		PlusOne plusOne = new PlusOne();
		 int[] digits={9,9,1};
		int[] res =plusOne.plusOne(digits);
		System.out.println( Arrays.toString(res) );
	}
}
