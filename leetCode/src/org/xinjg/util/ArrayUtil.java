package org.xinjg.util;

public class ArrayUtil<T> {
	public static<T> void printArray(int[] num){
		System.out.print( "  [  ");
		for( int i=0;i<num.length;i++ ){
			if( i==num.length-1 )
				System.out.print( num[i] +"  ]  ");
			else
				System.out.print( num[i] +"  ,  ");
		}
	}
}
