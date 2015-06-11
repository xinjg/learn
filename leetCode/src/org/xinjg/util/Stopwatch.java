package org.xinjg.util;


public class Stopwatch {
	private final long start;
	public Stopwatch(){
		this.start=System.currentTimeMillis();
	}
	/**
	 *  author : xinjg
	 *	@return Elapsed Time In Millisecond
	 */
	public long elapsedTimeInMillis() {
		long now=System.currentTimeMillis();
		return now-start;
	}
	
	/**
	 *  author : xinjg
	 *	@return Elapsed Time In Seconds
	 */
	public double elapsedTimeInSeconds(){
		long now=System.currentTimeMillis();
		return (now-start)/1000.0;
	}
}
