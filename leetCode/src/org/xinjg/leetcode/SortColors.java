/**
 * 
 */
package org.xinjg.leetcode;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this problem
 * 
 * @author xinjg
 * 
 */
public class SortColors {

    public void sortColors(int[] A) {
    	threeWayPartitionSort( A,0,A.length );
    }
    /*
     * partition the array in three part  a[lo~lt] is less than v ,a[lt~gt] equals with v ,and a[gt,hi] is greater than v;
     */
    private  void threeWayPartitionSort(int[] a,int lo,int hi){
		if( lo>=hi )
				return;
		int[] ret= threeWayPartition( a,lo,hi );
		if( ret[0]>lo )
			threeWayPartitionSort(a,lo,ret[0]);
		if( ret[1]<hi )
			threeWayPartitionSort(a,ret[1],hi);
	}
	
	/*
	 * a[i] less than v: exchange a[lt] with a[i] and increment both lt and i
	 * a[i] greater than v: exchange a[i] with a[gt] and decrement gt a[i] equal
	 * to v: increment i
	 */
	private  int[] threeWayPartition(int[] a, int lo, int hi) {
		int i = lo;
		int lt = lo;
		int gt = hi;
		int v = a[lo];
		while (i < gt) {
			if(a[i]<v){
				swap(a,lt++,i++);
			}else if( a[i]>v ){
				swap(a,i,--gt);
			}else
				i++;
		}
		int[] ret = new int[2];
		ret[0]=lt;
		ret[1]=gt;
		return ret;
	}
	private  void swap(int[] array, int p, int q) {
		int tmp = array[p];
		array[p] = array[q];
		array[q] = tmp;
	}
}
