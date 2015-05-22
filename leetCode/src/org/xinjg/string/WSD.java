package org.xinjg.string;

import java.util.Arrays;

public class WSD {
	public static int charAt(String string ,int pos) {
		if (pos>=string.length()) {
			return  -1;
		}else {
			return string.charAt(pos);
		}
	}
	
	public static void sort(String[] array){
		sort(array,0,array.length-1,0);
	}
	
	private static void sort(String[] array,int lo,int hi,int d){
		if (lo>=hi) {
			return;
		}
		int R=256;
		int[] count=new int[R+2];
		for (int i = 0; i < array.length; i++) {
			count[ charAt(array[i], d)+2 ]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i]=count[i-1]+count[i];
		}
		String[] aux =new String[array.length];
		for (int i = 0; i < array.length; i++) {
			aux[ count[charAt(array[i], d)+1] ++]=array[i];
		}
		for (int i = 0; i < aux.length; i++) {
			array[i]=aux[i];
		}
		d++;
		for (int i = 0; i < count.length-1; i++) {
			sort(array,count[i],count[i+1],d);
		}
		
	}
	public static void main(String[] args) {
		String[] array={"1","12","123","0"};
		sort(array);
		System.out.println( Arrays.toString(array) );
//		System.out.println( charAt("A",0) );
	}
}
