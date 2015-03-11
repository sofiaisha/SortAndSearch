package com.mysortandsearch.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysortandsearch.DistributionSort;
import com.mysortandsearch.utils.ListGenerator;
import com.mysortandsearch.utils.MyInteger;
import com.mysortandsearch.utils.Sort;

public class TestDistributionSort {

	private static ListGenerator lg;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		TestDistributionSort.lg = new ListGenerator();
	}

	@Test
	public void testCount() {
		ArrayList<MyInteger> listMyInts = TestDistributionSort.lg
				.buildMyIntegerList(100000, 100);
		List<MyInteger> newlistMyInts = DistributionSort.countSort(listMyInts,
				100);
		Assert.assertTrue(Sort.isSorted(newlistMyInts));
	}

	@Test
	public void testBucket() {
		ArrayList<MyInteger> listMyInts = TestDistributionSort.lg
				.buildMyIntegerList(50, 10);
		DistributionSort.bucketSort(listMyInts, 100000, 100);
		Assert.assertTrue(Sort.isSorted(listMyInts));

	}

}
