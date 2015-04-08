package org.xinjg.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Queue;
import java.util.Random;

import junit.framework.Assert;

import org.junit.Test;
import org.xinjg.search.BinarySearchTrees;
import org.xinjg.sort.SortUtil;

public class BinarySearchTreesTest {

	@Test
	public void testPut() {
		BinarySearchTrees<Integer, String> bst = new BinarySearchTrees<Integer, String>();
		Assert.assertNull(bst.get(1));
		bst.put(1,"One");
		Assert.assertNotNull(bst.get(1));
		bst.put(2,"Two");
		bst.put(10,"Ten");
		Assert.assertEquals("One", bst.get(1));
		Assert.assertEquals("Ten", bst.get(10));
	}
	
	@Test
	public void testIsEmpty(){
		BinarySearchTrees<Integer, String> bst = new BinarySearchTrees<Integer, String>();
		Assert.assertTrue( bst.isEmpty() );
		bst.put(100, "100");
		bst.put(200, "200");
		bst.put(90, "90");
		Assert.assertTrue( !bst.isEmpty() );
		Assert.assertEquals("200", bst.get(200));
	}
	
	@Test
	public void testGet(){
		BinarySearchTrees<Integer, String> bst = new BinarySearchTrees<Integer, String>();
		for( int i=1000;i<=2000;i++ ){
			bst.put(i, String.valueOf(i));
		}
		for( int j=2000;j>=1000;j-- ){
			Assert.assertEquals(String.valueOf(j), bst.get(j));
		}
	}
	
	@Test
	public void testMax(){
		BinarySearchTrees<Integer,String> bst = randomBST();
		Assert.assertEquals(Integer.valueOf(100), bst.getMax());
	}
	
	@Test
	public void testMin(){
		BinarySearchTrees<Integer,String> bst = randomBST();
		Assert.assertEquals(Integer.valueOf(0), bst.getMin());
	}
	@Test
	public void testFloor() {
		BinarySearchTrees<Integer, String> shuffledBST = shuffledBST();
		Assert.assertEquals(Integer.valueOf(6), shuffledBST.getFloor(7));
	}
	
	@Test
	public void testCeil(){
		BinarySearchTrees<Integer, String> shuffledBST = shuffledBST();
		Assert.assertEquals(Integer.valueOf(8), shuffledBST().getCeil(7));
	}
	
	@Test
	public void testSize(){
		BinarySearchTrees<Integer,String> bst = new BinarySearchTrees<Integer,String>();
		Assert.assertEquals(0, bst.size());
		BinarySearchTrees<Integer, String> shuffledBST = shuffledBST();
		Assert.assertEquals(10, shuffledBST.size());
	}
	
	@Test
	public void testRank() {
		BinarySearchTrees<Integer,String> bst = new BinarySearchTrees<Integer,String>();
		Assert.assertEquals(0, bst.rank(0));
		bst.put(0, "the value is zero");
		Assert.assertEquals(1, bst.rank(1));
		Assert.assertEquals(0, bst.rank(0));
	}
	
	@Test
	public void testDeleteMin() {
		BinarySearchTrees<Integer, String> shuffledBST = shuffledBST();
		for (int i = 9; i >=0; ) {
			shuffledBST.deleteMin();
			Assert.assertEquals(i--, shuffledBST.size());
		} 
	}
	
	@Test
	public void testDelete() {
		BinarySearchTrees<Integer, String> shuffledBST = shuffledBST();
		int size = shuffledBST.size();
		Assert.assertEquals(10, shuffledBST.size());
		//Random deletion
		int[] array =new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i]=2*i;
		}
		SortUtil.shuffle(array);
		for (int j = 0; j < array.length; j++) {
			Assert.assertEquals(true, shuffledBST.get(array[j])!=null);
			shuffledBST.delete(array[j]);
			Assert.assertEquals(false, shuffledBST.get(array[j])!=null);
			Assert.assertEquals(--size, shuffledBST.size());
		}
	}
	
	@Test
	public void testKeys() {
		BinarySearchTrees<Integer, String> shuffledBST = this.shuffledBST();
		Iterable<Integer> iterable = shuffledBST.keys();
		Iterator<Integer> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			System.out.println( iterator.next() );
		}
	}
	
	private BinarySearchTrees<Integer,String>shuffledBST(){
		int[] array =new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i]=2*i;
		}
		SortUtil.shuffle(array);
		Assert.assertNotNull(array);
		BinarySearchTrees<Integer,String> bst = new BinarySearchTrees<Integer,String>();
		for (int j = 0; j < array.length; j++) {
			bst.put(array[j], String.valueOf(array[j]));
		}
		return bst;
	}
	
	private  BinarySearchTrees<Integer,String> randomBST(){
		BinarySearchTrees<Integer, String> bst = new BinarySearchTrees<Integer, String>();
		for( int i=0;i<100;i++ ){
			Integer val=null;
			Random random = new Random();
			val = random.nextInt(100);
			bst.put(val, val.toString());
		}
		bst.put(0, "min");
		bst.put(100, "max");
		return bst;
	}
}
