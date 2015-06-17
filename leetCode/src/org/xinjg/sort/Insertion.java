package org.xinjg.sort;

import java.util.Arrays;

import org.xinjg.util.StdRandom;

public class Insertion {
	/*
	 * cannot be instanced
	 */
	private Insertion(){}
	
	/**
	 *	Better Insertion sort algorithms without exchange element,Just move the bigger one right
	 *	@param array, Array of Comparable to be Sorted
	 */
	public static <T>void betterSort(Comparable<T>[] array){
		for (int i = 1; i < array.length; i++) {
			Comparable<T> element=array[i];
			int j=i;
			while( j>0&&less(element, array[j-1]) ){
				array[j]=array[j-1];
				j--;
			}
			array[j]=element;
		}
	}
	
	/**
	 *  Insertion sort based on exchange 		
	 *	@param array, Array of Comparable to be Sorted
	 */
	public static <T> void sort( Comparable<T>[] array ){
		for (int i = 1; i < array.length; i++) {
			for(int j=i;j>0&&less(array[j],array[j-1]);j--){
				exch(array, j, j-1);
			}
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
		betterSort(array);
		System.out.println("IS THE ARRAY SORTED ?  "+ SortUtil.isSorted(array)); 
//		System.out.println(Arrays.toString(array));
	}
}
