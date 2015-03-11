package com.mysortandsearch;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDistributionSort {

	private static ListGenerator lg;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		TestDistributionSort.lg = new ListGenerator();
	}

	@Test
	public void testCount() {
		ArrayList<com.mysortandsearch.MyInteger> listMyInts = TestDistributionSort.lg
				.buildMyIntegerList(100000, 100);
		List<MyInteger> newlistMyInts = DistributionSort.countSort(listMyInts,
				100);
		Assert.assertTrue(Sort.isSorted(newlistMyInts));
	}

}
