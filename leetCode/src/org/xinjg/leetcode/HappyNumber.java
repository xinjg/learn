package org.xinjg.leetcode;

import java.util.HashMap;
import java.util.Map;

import sun.print.resources.serviceui;

/*
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, 
replace the number by the sum of the squares of its digits, and repeat the process until the number
 equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. 
 Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

 */
public class HappyNumber {
	private Map<Integer,Integer> seen = new HashMap<Integer, Integer>();
	public boolean isHappy(int n) {
		return sum(n)==1;
	}
	
	private int sum(int n){
		String nStr = Integer.toString(n);
		int len = nStr.length();
		int sum =0;
		for (int i = 0; i < len; i++) {
			int val =  nStr.charAt(i)-'0';
			sum =sum +val*val;
		}
		if(seen.get(sum)!=null&& seen.get(sum)>1)
			return sum;
		seen.put(sum, seen.get(sum)==null?0:seen.get(sum)+1);
		return sum(sum);
	}
	
	public static void main(String[] args) {
		HappyNumber hp = new HappyNumber();
		System.out.println( hp.isHappy(1) );
	}
}
