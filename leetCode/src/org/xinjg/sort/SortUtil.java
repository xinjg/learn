package org.xinjg.sort;

import org.xinjg.util.ArrayUtil;

public class SortUtil {

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
		int[] a ={-1, 0 ,1, 2, -1 ,-4};
		insertionSort(a );
		ArrayUtil.printArray(a);
	}
	
}
