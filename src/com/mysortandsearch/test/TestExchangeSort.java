package com.mysortandsearch.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysortandsearch.sort.ExchangeSort;
import com.mysortandsearch.sort.utils.Sort;
import com.mysortandsearch.utils.ListGenerator;

public class TestExchangeSort {

	private static ListGenerator lg;
	private ArrayList<Integer> list;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		TestExchangeSort.lg = new ListGenerator();
	}

	@Test
	public void testBubble() {
		list = TestExchangeSort.lg.build(10000, 100000);
		ExchangeSort.bubbleSort(list);
		Assert.assertTrue(Sort.isSorted(list));
		list = null;
	}

	@Test
	public void testQuick() {
		list = TestExchangeSort.lg.build(10000, 100000);
		ExchangeSort.quickSort(list);
		Assert.assertTrue(Sort.isSorted(list));
		list = null;
	}
}
