package com.mysortandsearch.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mysortandsearch.BinarySearch;
import com.mysortandsearch.ExchangeSort;
import com.mysortandsearch.InsertionSort;
import com.mysortandsearch.LinearSearch;
import com.mysortandsearch.utils.ListGenerator;

public class TestSearch {

	ListGenerator lg = new ListGenerator();
	ArrayList<Integer> list;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testLinearSearch() {
		list = lg.build(10000, 100000);
		
		assertFalse(LinearSearch.linearSearch(null, 100));
		assertFalse(LinearSearch.linearSearch(list, null));

		for (int i = 0; i < list.size(); i++) {
			int j = list.get(i);
			assertTrue(LinearSearch.linearSearch(list, j));
		}
		assertFalse(LinearSearch.linearSearch(list, 1001));
	}

	@Test
	public void testLinearSearchRecursive() {
		list = lg.build(10000, 100000);
		
		assertFalse(LinearSearch.linearSearchRecursive(null, 100));
		assertFalse(LinearSearch.linearSearchRecursive(list, null));

		for (int i = 0; i < list.size(); i++) {
			int j = list.get(i);
			assertTrue(LinearSearch.linearSearchRecursive(list, j));
		}
		assertFalse(LinearSearch.linearSearch(list, 1001));
	}
	
	@Test
	public void testBinarySearch() {
		list = lg.build(10000, 100000);
		ExchangeSort.quickSort(list);
				
		assertFalse(BinarySearch.binarySearch(null, 100));
		assertFalse(BinarySearch.binarySearch(list, null));

		for (int i = 0; i < list.size(); i++) {
			int j = list.get(i);
			assertTrue(BinarySearch.binarySearch(list, j));
		}
		assertFalse(BinarySearch.binarySearch(list, 1001));
	}
	
	@Test
	public void testBinarySearchRecursive() {
		list = lg.build(10000, 100000);
		ExchangeSort.quickSort(list);
				
		assertFalse(BinarySearch.binarySearchRecursive(null, 100));
		assertFalse(BinarySearch.binarySearchRecursive(list, null));

		for (int i = 0; i < list.size(); i++) {
			int j = list.get(i);
			assertTrue(BinarySearch.binarySearchRecursive(list, j));
		}
		assertFalse(BinarySearch.binarySearchRecursive(list, 1001));
	}
}
