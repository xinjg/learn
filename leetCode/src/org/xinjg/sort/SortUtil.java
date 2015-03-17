package org.xinjg.sort;

import org.xinjg.util.ArrayUtil;

public class SortUtil {

	/**
	 * —°‘Ò≈≈–Ú
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
	
	public static void main(String[] args) {
		int[] a ={-1, 0 ,1, 2, -1 ,-4};
		selectionSort(a );
		ArrayUtil.printArray(a);
	}
}
