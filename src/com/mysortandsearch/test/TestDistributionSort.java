package com.mysortandsearch.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysortandsearch.sort.DistributionSort;
import com.mysortandsearch.sort.utils.Sort;
import com.mysortandsearch.utils.HasAnIntegerKey;
import com.mysortandsearch.utils.ListGenerator;
import com.mysortandsearch.utils.MyInteger;


class Dummy extends MyInteger implements HasAnIntegerKey {
	private String s;

	Dummy(int i, String s) {
		super(i);
		this.s = s;
	}
}

public class TestDistributionSort {

	private static ListGenerator lg;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		TestDistributionSort.lg = new ListGenerator();
	}

	@Test
	public void testCount() {
		List<HasAnIntegerKey> listMyInts = TestDistributionSort.lg
				.buildMyIntegerList2(100000, 100);
		List<HasAnIntegerKey> newlistMyInts = DistributionSort.countSort(listMyInts,
				100);
		Assert.assertTrue(Sort.isSorted(newlistMyInts));
	}
	
	@Test
	public void testCountDummy() {
		List<Dummy> listDummies = new ArrayList<Dummy>();
		listDummies.add(new Dummy(5, "Five"));
		listDummies.add(new Dummy(1, "One"));
		listDummies.add(new Dummy(3, "Three"));
		listDummies.add(new Dummy(4, "Four"));
		listDummies.add(new Dummy(2, "Two"));
		List<Dummy> newlistDummies = DistributionSort.countSort(listDummies,100);
		Assert.assertTrue(Sort.isSorted(newlistDummies));
	}

	@Test
	public void testBucket() {
		ArrayList<MyInteger> listMyInts = TestDistributionSort.lg
				.buildMyIntegerList(50, 10);
		DistributionSort.bucketSort(listMyInts, 100000, 100);
		Assert.assertTrue(Sort.isSorted(listMyInts));

	}
}
