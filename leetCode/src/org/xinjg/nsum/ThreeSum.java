package org.xinjg.nsum;

import java.util.ArrayList;
import java.util.List;

import org.xinjg.binarysearch.BinarySearch;
import org.xinjg.sort.SortUtil;
import org.xinjg.util.ArrayUtil;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * @author Administrator
 *
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
    	SortUtil.selectionSort(num);
    	System.out.println( "Sort Finished : " );
    	ArrayUtil.printArray(num);
    	List <List<Integer>> ret = new ArrayList<List<Integer>>();
    	int len = num.length;
    	int index = -1;
    	for( int i=0;i<len;i++ ){
    		for( int j=i+1;j<len;j++ ){
    			index = BinarySearch.searchArray(num, -( num[i]+num[j] ) );
    			if( index >=0 && index >j ) {
    				List<Integer> list = new ArrayList<Integer>(3);
    				list.add(num[i]);list.add(num[j]);list.add(num[index]);
    				ret.add(list);
    			}
    		}
    	}
        return ret;
    }
    
    public static void main(String[] args) {
		int[] a={  -1, 0 ,1, 2, -1 ,-4 };
		List<List<Integer>> ret = new ThreeSum().threeSum(a);
		for(List<Integer> list:ret ){
			System.out.println(list.get(0) +"    "   +  list.get(1) + "    " +list.get(2) );
		}
	}
}
