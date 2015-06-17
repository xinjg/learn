package org.xinjg.sort;

import org.xinjg.util.StdRandom;
import org.xinjg.util.Stopwatch;

public class SortCompare {
	public static <T> double sortTime(String algs,Comparable<T>[] array){
		Stopwatch stopwatch=new Stopwatch();
		if ("Insertion".equals(algs)) {
			Insertion.sort(array);
		}else if("Better Insertion".equals(algs)){
			Insertion.betterSort(array);
		}else if("Selection".equals(algs)){
			
		}else if ("Shell".equals(algs)) {
			
		}else if("Merge".equals(algs)){
			
		}else if ("Quick".equals(algs)) {
			
		}else {
			System.out.println("Unknow sort algorithms!");
		}
		return stopwatch.elapsedTimeInSeconds();
	}
	
	/**
	 *	@param algs1  Algorithm 1
	 *	@param algs2  Algorithm 2
	 *	@param compara  Compare times
	 *	@param length  Length of array to be sorted
	 *	@return 
	 */
	public static double compare(String algs1,String algs2,int compare,int length ){
		double cost1 = 0,cost2=0;
		for(int i=0;i<compare;i++){
			Double[] array=new Double[length];
			for (int j = 0; j < array.length; j++) {
				array[j]=StdRandom.uniform();
			}
			cost1=sortTime(algs1,array)+cost1;
		}
		for(int i=0;i<compare;i++){
			Double[] array=new Double[length];
			for (int j = 0; j < array.length; j++) {
				array[j]=StdRandom.uniform();
			}
			cost2=sortTime(algs2,array)+cost2;
		}
		return cost1/cost2;
	} 
	
	public static void main(String[] args) {
		System.out.println( compare("Insertion","Better Insertion",10,40000) );
	}
}
