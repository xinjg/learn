package org.xinjg.sort;

import org.xinjg.util.StdRandom;

public class Shell {
	private Shell(){}
	
	public static <T> void sort(Comparable<T>[] array) {
		int h=1;
		while (h<array.length/3) {
			h=3*h+1;
		}
		while (h>=1) {
			for (int i = h; i < array.length; ) {
				for (int j = i; j>=h&&less(array[j], array[j-h]); ) {
					exch(array,j,j-h);
					j=j-h;
				}
				i=i+h;
			}
			h=h/3;
		}
	}
	
	/*
	 * Exchange elements in array
	 */
	private static void exch(Object[] array,int i,int j){
		Object tmp=array[i];
		array[i]=array[j];
		array[j]=tmp;
	}
	
	/*
	 * Is a less than b ?
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static  boolean less(Comparable a,Comparable b){
		return a.compareTo(b)<0;
	}
	
	public static void main(String[] args) {
		Double[] array=new Double[1000];
		for (int i = 0; i < array.length; i++) {
			array[i]=StdRandom.uniform();
		}
		sort(array);
		System.out.println("IS THE ARRAY SORTED ?  "+ SortUtil.isSorted(array)); 
//		System.out.println(Arrays.toString(array));
	}
}
