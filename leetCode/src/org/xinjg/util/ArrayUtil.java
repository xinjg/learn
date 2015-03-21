package org.xinjg.util;

public class ArrayUtil<T> {
	private ArrayUtil(){
		
	}
	public static<T> void printArray(int[] num){
		System.out.print( "  [  ");
		for( int i=0;i<num.length;i++ ){
			if( i==num.length-1 )
				System.out.print( num[i] +"  ]  ");
			else
				System.out.print( num[i] +"  ,  ");
		}
	}
	
	public static void printAsChar(int[] num){
		System.out.print( "  [  ");
		for( int i=0;i<num.length;i++ ){
			if( i==num.length-1 )
				System.out.print( (char)num[i] +"  ]  ");
			else
				System.out.print( (char)num[i] +"  ,  ");
		}
	}
}
