package org.xinjg.leetcode;

import java.util.Arrays;

public class SortedTable {

	public SortedTable(int capacity) {
		this.capacity = capacity;
		this.keys = new int[capacity];
		this.values = new int[capacity];
	}

	public void put(int key, int value) {
        
		int pos=findPos( keys,key,0,cnt-1 ) ;
		// check equal
		if( keys[pos]==key ){
			values[pos]=value;
			return;
		}
		
		int idx = cnt - 1;
		//remove all element greater than key
		while (idx >= pos) {
			swap(keys, idx, idx + 1);
			swap(values, idx, idx + 1);
			idx--;
		}
		keys[pos] = key;
		values[pos] = value;
		cnt++;
	}

	public static int findPos( int[] a,int key,int lo,int hi ){
		while( hi>=lo ){
			int mid = lo +(hi-lo)/2;
			if( key < a[mid]  ){
				hi =mid-1;
			}else if( key >a[mid] )
				lo =mid+1;
			else return mid;
		}
		return lo;
	}
	
	public int get(int key) {
		int lo=0 ,hi=cnt-1;
		while(hi>=lo){
			int mid = lo+(hi-lo)/2;
			if( key < keys[mid]  )
				hi = mid -1;
			else if( key > keys[mid] )
				lo =mid+1;
			else
				return values[mid];
		}
		return -1;
	}

	private void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	private int[] keys;
	private int[] values;
	private int cnt = 0;
	private int capacity;

	@Override
	public String toString() {
		return "SortedTable [keys=" + Arrays.toString(keys) + ", values="
				+ Arrays.toString(values) + ", cnt=" + cnt + ", capacity="
				+ capacity + "]";
	}

	public static void main(String[] args) {
	   int[] a = {1,2,4,5,6,7,8,9};
	   //Test findPos
	   System.out.println (findPos  ( a, -1,0, 7));
	   //Test put
	   SortedTable st = new SortedTable(10);
	   st.put(2, 2);
	   st.put(5, 5);
	   st.put(11, 11);
	   st.put(1, 1);
	   System.out.println( st.toString() );
	   System.out.println( "get 0   " + st.get(0) );
	   System.out.println( "get 11  " + st.get(11) );
	   System.out.println( "get 12  " + st.get(12) );
	}
}
