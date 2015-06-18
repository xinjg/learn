package org.xinjg.sort;


/**
 * 
 * Bottom up merge sort
 */
public class MergeBU {
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] array) {
		Comparable[] aux=new Comparable[array.length];
		for (int i = 0; i < aux.length; i++) {
			aux[i]=array[i];
		}
		sort(array,aux,0,array.length);
	}
	
	@SuppressWarnings("rawtypes")
	private static void sort(Comparable[] array,Comparable[] aux ,int lo,int hi){
		for (int k = 1; k < hi; k+=k) {
			for (int i = lo; i < hi-k;) {
				merge(array, aux, i,i+k, min(i+k+k,hi));
				i=i+2*k;
			}
		}
	}
	
	private static int min(int a,int b){
		return a<b?a:b;
	}
	
	/*
	 * merge sorted sub array; array[lo...mid) ,array[mid...hi)  to make array[lo,hi) sorted
	 * array[lo...mid) ,array[mid...hi) are sorted  
	 */
	@SuppressWarnings({ "rawtypes" })
	private static void merge(Comparable[] array,Comparable[] aux,int lo,int mid,int hi){
		int left=lo;
		int right=mid;
		for (int i = lo; i < hi; i++) {
			if (left>=mid) {
				aux[i]=array[right++];
			}else if (right>=hi) {
				aux[i]=array[left++];
			}else{
				int compare = array[left].compareTo(array[right]);
				if (compare>0) {
					aux[i]=array[right++];
				}else {
					aux[i]=array[left++];
				}
			}
		}
		//Copy back to array;
		for (int i = lo; i < hi; i++) {
			array[i]=aux[i];
		}
	}
}
