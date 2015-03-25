package org.xinjg.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

	//Simple Sorted Table 
	private class SortedTable {
		// Constructor
		SortedTable(int capacity) {
			this.capacity = capacity;
			this.keys = new int[capacity];
			this.values = new int[capacity];
		}

		public void put(int key, int value) {

			int pos = findPos(keys, key, 0, cnt - 1);
			// check equal
			if (keys[pos] == key) {
				values[pos] = value;
				return;
			}

			int idx = cnt - 1;
			// remove all element greater than key
			while (idx >= pos) {
				swap(keys, idx, idx + 1);
				swap(values, idx, idx + 1);
				idx--;
			}
			keys[pos] = key;
			values[pos] = value;
			cnt++;
		}

		int findPos(int[] a, int key, int lo, int hi) {
			while (hi >= lo) {
				int mid = lo + (hi - lo) / 2;
				if (key < a[mid]) {
					hi = mid - 1;
				} else if (key > a[mid])
					lo = mid + 1;
				else
					return mid;
			}
			return lo;
		}

		int get(int key) {
			int lo = 0, hi = cnt - 1;
			while (hi >= lo) {
				int mid = lo + (hi - lo) / 2;
				if (key < keys[mid])
					hi = mid - 1;
				else if (key > keys[mid])
					lo = mid + 1;
				else
					return values[mid];
			}
			return -1;
		}

		void swap(int[] a, int i, int j) {
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}

		int[] keys;
		int[] values;
		int cnt = 0;
		int capacity;
	}

	public int[] twoSum(int[] numbers, int target) {
		int[] ret = null;
		int len = numbers.length;
		Map<Integer, Integer> st = new HashMap<Integer, Integer>();
		for( int i=0;i<len;i++ ){
			st.put(numbers[i], i+1);
		}
		for( int j=0;j<len;j++ ){
			Integer idx =  st.get(target-numbers[j]);
			if( idx!=null&& idx>++j  ){
				ret = new int[2];ret[0]=j;ret[1]=idx;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] a = {0,4,3,0};
		System.out.println( Arrays.toString( new TwoSum().twoSum(a, 0)  ) );
	}
}
