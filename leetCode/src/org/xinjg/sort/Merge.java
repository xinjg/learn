package org.xinjg.sort;


public class Merge {
	private static final int SMALL_ARRAY_BONDS=15;
	private Merge(){}
	
	@SuppressWarnings("rawtypes")
	public static  void sort(Comparable[] array) {
		int lo=0;
		int hi=array.length;
		Comparable[] aux= new Comparable[array.length];
		for (int i = 0; i < array.length; i++) {
			aux[i]=array[i];
		}
		sort(array, aux, lo, hi);
	}
	
	@SuppressWarnings("rawtypes")
	private static void sort(Comparable[] array,Comparable[] aux,int lo,int hi){
		//turn insertion sort for small sub arrays
		if(hi-lo<=SMALL_ARRAY_BONDS){
			insertionSort(array, lo, hi);
			return;
		}
			
		int mid=lo+(hi-lo)/2;
		sort(array,aux, lo, mid);
		sort(array, aux,mid, hi);
		// stop merge for sorted
		if (!less(array[mid], array[mid-1])) {
			return;
		}
		merge(array, aux, lo, mid, hi);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static  void merge(Comparable[] array,Comparable[] aux,int lo,int mid,int hi){
		// array[lo...mid] and array[mid+1...hi ] are sorted
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
	
	@SuppressWarnings({ "rawtypes" })
	private static void insertionSort(Comparable[] array,int lo,int hi){
		for (int i = lo+1; i < hi; i++) {
			int j=i;
			Comparable element = array[j];
			while(j>lo&&less(element, array[j-1])){
				array[j]=array[j-1];
				j--;
			}
			array[j]=element;
		}
	}
	
	/*
	 * Is a less than b ?
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static  boolean less(Comparable a,Comparable b){
		return a.compareTo(b)<0;
	}
}
