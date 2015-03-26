package org.xinjg.sort;

import java.util.Random;

import org.xinjg.util.ArrayUtil;

public class SortUtil {

	private SortUtil() {
	}

	public static void threeWayQuickSort(int[] a){
		threeWayPartitionSort(a,0,a.length);
	}
	
	public static void threeWayPartitionSort(int[] a,int lo,int hi){
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
	public static int[] threeWayPartition(int[] a, int lo, int hi) {
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

	/**
	 * Quick Sort Finished
	 * 
	 * @param a
	 */
	public static void quickSort(int[] a) {
		shuffle(a);
		partiotionSort(a, 0, a.length - 1);
	}

	public static void partiotionSort(int[] a, int lo, int hi) {
		if (lo == hi)
			return;
		int j = partition(a, lo, hi);
		partiotionSort(a, lo, j);
		partiotionSort(a, j + 1, hi);
	}

	public static int partition(int[] a, int lo, int hi) {
		int v = a[lo];
		int i = lo;
		int j = hi + 1;
		while (true) {
			while (a[++i] <= v)
				if (i == hi)
					break;
			while (a[--j] >= v)
				if (j == lo)
					break;
			if (i >= j) {
				break;
			}
			swap(a, i, j);
		}
		swap(a, lo, j);
		return j;
	}

	public static void shuffle(int[] a) {
		int len = a.length;
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		int r = 0;
		for (int i = 0; i < len; i++) {
			r = random.nextInt(i + 1);
			swap(a, i, r);
		}
	}

	/**
	 * Top down merge sort
	 * 
	 * @param a
	 */
	public static void mergeSort(int[] a) {
		int[] aux = new int[a.length];
		sort(a, aux, 0, a.length - 1);
	}

	/**
	 * 
	 */
	public static void sort(int[] a, int aux[], int lo, int hi) {
		if (lo >= hi)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}

	/**
	 * merge sorted arrays a[lo]~a[mid] and a[mid+1]~a[hi]
	 * 
	 * @param a
	 * @param aux
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; i++) {
			aux[i] = a[i];
		}
		for (int k = lo, i = lo, j = mid + 1; i <= mid || j <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (aux[i] < aux[j])
				a[k] = aux[i++];
			else
				a[k] = aux[j++];
		}
	}

	/**
	 * Simple Implementation of Selection Sort
	 * 
	 * @param array
	 */
	public static void selectionSort(int[] array) {
		int len = array.length;
		int min = 0;
		for (int i = 0; i < len; i++) {
			min = i;
			for (int j = i; j < len; j++) {
				if (array[j] < array[min])
					min = j;
			}
			swap(array, i, min);
		}

	}

	public static void swap(int[] array, int p, int q) {
		int tmp = array[p];
		array[p] = array[q];
		array[q] = tmp;
	}

	/**
	 * Simple Implementation of Insertion Sort
	 * 
	 * @param a
	 */
	public static void insertionSort(int[] a) {
		int len = a.length;
		for (int i = 1; i < len; i++) {
			int j = i;
			while (j > 0 && a[j] <= a[--j]) {
				swap(a, j, j + 1);
			}
		}
	}

	public static void main(String[] args) {
//		int[] a = { 'K', 'R', 'A', 'T', 'E', 'L', 'E', 'P', 'U', 'I', 'M', 'Q',
//				'C', 'X', 'O', 'S' };
//		quickSort(a);
//		ArrayUtil.printAsChar(a);
//		ArrayUtil.printArray(a);

		int[] b = {'E', 'C', 'B', 'C', 'A', 'B', 'C', 'A', 'B', 'C', 'A', 'B', 'C' };
		threeWayQuickSort(b) ;
		ArrayUtil.printAsChar(b);
	}

	
}
