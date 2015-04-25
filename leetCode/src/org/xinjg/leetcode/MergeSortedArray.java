package org.xinjg.leetcode;

import java.util.Arrays;

import sun.security.util.Length;

/*
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 Note:
 You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 The number of elements initialized in A and B are m and n respectively.
 */
public class MergeSortedArray {
	public void merge(int a[], int m, int b[], int n) {
		if (n == 0) {
			return;
		}
		if (m == 0) {
			while (m < n) {
				a[m] = b[m];
				m++;
			}
			return;
		}
		if (a[m - 1] < b[0]) {
			for (int i = 0; i < n; i++) {
				a[m++] = b[i];
			}
		} else if (a[0] > b[n - 1]) {
			for (int i = m - 1; i >= 0; i--) {
				swap(a, i, i + n);
			}
			for (int i = 0; i < n; i++) {
				a[i] = b[i];
			}
		} else {
			for (int i = 0; i < n; i++) {
				insertSorted(a, m, b[i]);
				m++;
			}
		}
		return;
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	// insert val to a sorted array
	public static void insertSorted(int[] sorted, int cnt, int val) {
		int lo = 0, hi = cnt, mid = 0;
		if (val <= sorted[0]) {
			mid = 0;
		} else if (val >= sorted[cnt - 1]) {
			mid = cnt;
		} else {
			while (hi >= lo) {
				mid = lo + (hi - lo) / 2;
				if (mid == 0 || mid == sorted.length - 1) {
					break;
				}else if (val>=sorted[mid-1]&&val<=sorted[mid]) {
					break;
				}else if (val>=sorted[mid]&& val<=sorted[mid+1]) {
					mid = mid+1;break;
				}else if (val >sorted[mid]) {
					lo = mid ;
				} else if (val < sorted[mid]) {
					hi = mid ;
				}
			}
		}
		// insert val at position mid;
		for (int i = cnt - 1; i >= mid; i--) {
			swap(sorted, i, i + 1);
		}
		sorted[mid] = val;
	}

	public static void main(String[] args) {
		int[] a = {1, 4, 0, 0,0,0};
		int[] b = { 1, 2, 3, 5, 6 };
		// MergeSortedArray mergeSortedArray = new MergeSortedArray();
		// mergeSortedArray.merge(a, 1, b, 5);

		insertSorted(a, 2, 0);
		System.out.println(Arrays.toString(a));
	}

}
