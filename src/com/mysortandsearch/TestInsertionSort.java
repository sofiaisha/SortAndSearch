package com.mysortandsearch;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestInsertionSort {

	private static ListGenerator lg;
	private ArrayList<Integer> list;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		TestInsertionSort.lg = new ListGenerator();
	}

	@Test
	public void testInsertion() {
		list = TestInsertionSort.lg.build(10000, 100000);
		InsertionSort.insertionSort(list);
		Assert.assertTrue(Sort.isSorted(list));
		list = null;
	}
}
