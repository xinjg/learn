package org.xinjg.string;

import java.util.Arrays;

/**
 * Least significant-digit First string sort 
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public class LSD {
	public static void sort( String[] array,int width ) {
		// count frueqency
		//convert f to index
		// move array items
		//copy back;
		for (int d = width-1; d >=0; d--) {
			int R=256;
			int[] count=new int[R+1];
			for (int i = 0; i < array.length; i++) {
				count[ array[i].charAt(d)+1 ]++;
			}
			for (int r = 1; r <= R;r++) {
				count[r]=count[r-1]+count[r];
			}
			String[] aux=new String[array.length];
			for (int i = 0; i < aux.length; i++) {
				aux[count[ array[i].charAt(d) ]++]=array[i];
			}
			for (int i = 0; i < aux.length; i++) {
				array[i]=aux[i];
			}
		}
	}
	
	public static void main(String[] args) {
		String[] array={"1","2","1","2"};
		sort(array, 1);
		System.out.println(Arrays.toString(array));
	}
}
