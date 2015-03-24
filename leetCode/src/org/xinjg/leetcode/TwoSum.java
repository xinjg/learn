package org.xinjg.leetcode;

/**
 * 
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution
 * 
 * @author xinjg
 * 
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = null;
        int len = numbers.length;
        for(int i=0;i<len;i++ ){
        	for( int j =i+1;j<len;j++ ){
        		if( numbers[i]+numbers[j] == 9 ){
        			ret = new int[2];ret[0]=i;ret[1]=j;
        			return ret;
        		}
        	}
        }
        return ret;
    }
}
