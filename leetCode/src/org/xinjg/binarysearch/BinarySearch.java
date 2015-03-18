package org.xinjg.binarysearch;

public class BinarySearch {
	
	/**
	 * ���ַ�����val������ֵ,������ʱ����-1
	 * @param a
	 * @param val
	 * @return
	 */
	public static  int searchArray(int[] a,int val){
		int beginIndex =0;
		int endIndex = a.length-1;
		int index = -1;
		while( beginIndex <= endIndex   ){
			index = beginIndex + (endIndex-beginIndex)/2;
			if(val >  a[index]  ){
				beginIndex = index+1;
			}else if(val<a[index]){
				endIndex =index-1 ;
			}else
				return index;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {-4  ,  -1  ,  -1  ,  0  ,  1  ,  2  };
		System.out.println( BinarySearch.searchArray (a,2));
	}
}
