package com.mysortandsearch;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import com.mysortandsearch.MyInteger;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestDistributionSort {
	
	private static ListGenerator lg;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		lg = new ListGenerator();
	}
	
	@Test
	public void testCount() {
		ArrayList<com.mysortandsearch.MyInteger> listMyInts = lg.buildMyIntegerList(1000, 100);
		List<MyInteger> newlistMyInts = DistributionSort.countSort(listMyInts, 100);
		assertTrue(Sort.isSorted(newlistMyInts));
	}

}
