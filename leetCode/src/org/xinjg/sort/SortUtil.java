package org.xinjg.sort;

import org.xinjg.util.ArrayUtil;

public class SortUtil {
	
	/**
	 * Top down merge sort 
	 * @param a
	 */
	public static void mergeSort(int[] a){
		int[] aux = new int[a.length];
		sort(a,aux,0,a.length-1);
	}
	
	/**
	 * 
	 */
	public static void sort(int[] a ,int aux[],int lo,int hi) {
		if (lo>=hi)
			return;
		int mid = lo + (hi-lo)/2;
		sort( a,aux,lo,mid );
		sort( a,aux,mid+1,hi );
		merge( a,aux,lo,mid,hi );
	}
	
	/**
	 *  merge sorted arrays  a[lo]~a[mid]  and a[mid+1]~a[hi]
	 * @param a
	 * @param aux
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	public static void merge( int[] a,int[] aux,int lo,int mid,int hi ){
		for(int i=lo;i<=hi;i++){
			aux[i]=a[i];
		}
		for(int k=lo,i=lo,j=mid+1;i<=mid||j<=hi ;k++){
			if( i>mid )
				a[k]=aux[j++];
			else if(j>hi)
				a[k]=aux[i++];
			else if(aux[i] <aux[j])
				a[k]=aux[i++];
			else 
				a[k]=aux[j++];
		}
	}

	/**
	 * Simple Implementation of Selection Sort 
	 * @param array
	 */
	public static void selectionSort( int[] array ){
		int len=array.length;
		int min=0;
		for(int i=0;i<len;i++){
			min=i;
			for(int j=i;j<len;j++){
				if( array[j]<array[min] )
					min=j;
			}
			swap(array,i,min);
		}
		
	}
	
	public static void swap(int[] array,int p,int q  ){
		int tmp = array[p];
		array[p]=array[q];
		array[q]=tmp;
	}
	
	/**
	 * Simple Implementation of Insertion Sort 
	 * @param a
	 */
	public static void insertionSort(int[] a){
		int len = a.length;
		for( int i=1;i<len;i++ ){
			int j=i;
			while( j>0&& a[j]<=a[--j] ){
				swap(a,j,j+1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a ={4, 5 ,6, 1, 2 ,3};
		mergeSort(a);
		ArrayUtil.printArray(a);
	}
	
}
