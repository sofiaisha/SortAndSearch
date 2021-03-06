package com.mysortandsearch.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysortandsearch.sort.SelectionSort;
import com.mysortandsearch.sort.utils.Sort;
import com.mysortandsearch.utils.ListGenerator;

public class TestSelectionSort {

	private static ListGenerator lg;
	private ArrayList<Integer> list;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		TestSelectionSort.lg = new ListGenerator();
	}

	@Test
	public void testSelection() {
		list = TestSelectionSort.lg.build(10000, 100000);
		SelectionSort.selectionSort(list);
		Assert.assertTrue(Sort.isSorted(list));
		list = null;
	}
}
