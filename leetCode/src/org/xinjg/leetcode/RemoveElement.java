package org.xinjg.leetcode;

/**
 * Solution to Remove Element Accepted 
 * Given an array and a value, remove all
 * instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length. 
 * 
 * @author xinjg
 * 
 */
public class RemoveElement {

	public int removeElement(int[] a, int ele) {
		int len = a.length;
		int i = len;
		while (i > 0) {
			if (a[--i] == ele) {
				swap(a, i, --len);
			}
		}
		return len;
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void main(String[] args) {
		int[] a = { 3 };
		System.out.println(new RemoveElement().removeElement(a, 3));
	}
}
