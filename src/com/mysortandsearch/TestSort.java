package com.mysortandsearch;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestSort {

	private static ListGenerator lg;
	private ArrayList<Integer> list;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		lg = new ListGenerator();
	}

	@Test
	public void testInsertion() {
		list = lg.build(10, 100);
		Sort.insertionSort(list);
		assertTrue(Sort.isSorted(list));
		list = null;
	}
	
	@Test
	public void testBubble() {
		list = lg.build(10, 100);
		Sort.bubbleSort(list);
		assertTrue(Sort.isSorted(list));
		list = null;
	}
	
	@Test
	public void testSelection() {
		list = lg.build(10, 100);
		Sort.selectionSort(list);
		assertTrue(Sort.isSorted(list));
		list = null;
	}
}
