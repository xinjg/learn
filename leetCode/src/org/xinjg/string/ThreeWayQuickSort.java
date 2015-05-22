package org.xinjg.string;

import java.util.Arrays;

public class ThreeWayQuickSort {
	
	public static void sort(String[] array) {
		sort(array,0,array.length,0);
	}
	
	private static void sort(String[] array,int lo,int hi,int d){
		if (lo>=hi) {
			return;
		}
		//partition item 
		int v=charAt(array[lo], d);
		int lt=lo;
		int gt=hi-1;
		for (int i = lo; i <hi-1&&i<gt;) {
			int c=charAt(array[i], d);
			if (c<v) {
				swap(array, i, lt++);
			}else if (c>v) {
				swap(array, i,gt--);
			}else {
				i++;
			}
		}
		if (charAt(array[lt], d++)>0) {
			sort(array, lt, gt, d);
		}
		sort(array, lo, lt-1, d);
		sort(array, gt+1, hi, d);
	}
	
	private static void swap(String[] array,int i,int j){
		String tmp = array[i];
		array[i]=array[j];
		array[j]=tmp;
	}
	
	private  static int charAt(String string,int pos ){
		if (pos>=string.length()) {
			return -1;
		}
		return string.charAt(pos);
	}
	
	public static void main(String[] args) {
		String[] array ={"0","1","0","1","02","01"};
		sort(array);
		System.out.println(Arrays.toString(array));
	}
}
