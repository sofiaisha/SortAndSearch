package com.mysortandsearch.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysortandsearch.InsertionSort;
import com.mysortandsearch.utils.ListGenerator;
import com.mysortandsearch.utils.Sort;

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
