package com.mysortandsearch.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mysortandsearch.search.BinarySearch;
import com.mysortandsearch.search.LinearSearch;
import com.mysortandsearch.search.utils.LinearSearchMode;
import com.mysortandsearch.search.utils.LinearSearchModeFactory;
import com.mysortandsearch.sort.ExchangeSort;
import com.mysortandsearch.utils.ListGenerator;

public class TestSearch {

	ListGenerator lg = new ListGenerator();
	ArrayList<Integer> list;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testLinearSearch() {
		list = lg.build(1000, 1000);
		
		assertFalse(LinearSearch.linearSearch(null, 100));
		assertFalse(LinearSearch.linearSearch(list, null));

		for (int i = 0; i < list.size(); i++) {
			int j = list.get(i);
			assertTrue(LinearSearch.linearSearch(list, j));
		}
		assertFalse(LinearSearch.linearSearch(list, 1001));
	}

	@Test
	public void testLinearSearchNoMode() {
		list = lg.build(1000, 1000);

		assertFalse(LinearSearch.linearSearch(null, 100, null));
		assertFalse(LinearSearch.linearSearch(list, null, null));

		for (int i = 0; i < list.size(); i++) {
			int j = list.get(i);
			assertTrue(LinearSearch.linearSearch(list, j, null));
		}
		assertFalse(LinearSearch.linearSearch(list, 1001, null));
	}

	@Test
	public void testLinearSearchMoveFirst() {
		list = lg.build(1000, 1000);
		LinearSearchMode<Integer> mode = LinearSearchModeFactory
				.build(LinearSearchModeFactory.modeMoveFirst);

		assertFalse(LinearSearch.linearSearch(null, 100, null));
		assertFalse(LinearSearch.linearSearch(list, null, null));

		int size = list.size();

		for (int i = 0; i < list.size(); i++) {
			int j = list.get(i);
			assertTrue(LinearSearch.linearSearch(list, j, mode));
		}
		// Test first element
		int element = list.get(0);
		assertTrue(LinearSearch.linearSearch(list, element, mode));
		assertEquals(list.get(0), (Integer) element);
		assertEquals(list.size(), size);
		// Test element in the middle of the list
		element = list.get(list.size() / 2);
		assertTrue(LinearSearch.linearSearch(list, element, mode));
		assertEquals(list.get(0), (Integer) element);
		assertEquals(list.size(), size);
		// Test last element
		element = list.get(list.size() - 1);
		assertTrue(LinearSearch.linearSearch(list, element, mode));
		assertEquals(list.get(0), (Integer) element);
		assertEquals(list.size(), size);
		// Test missing element
		assertFalse(LinearSearch.linearSearch(list, 1001, mode));
	}

	@Test
	public void testLinearSearchMoveLast() {
		list = lg.build(1000, 1000);
		LinearSearchMode<Integer> mode = LinearSearchModeFactory
				.build(LinearSearchModeFactory.modeMoveLast);

		assertFalse(LinearSearch.linearSearch(null, 100, null));
		assertFalse(LinearSearch.linearSearch(list, null, null));

		int size = list.size();

		for (int i = 0; i < list.size(); i++) {
			int j = list.get(i);
			assertTrue(LinearSearch.linearSearch(list, j, mode));
		}

		// Test first element
		int element = list.get(0);
		assertTrue(LinearSearch.linearSearch(list, element, mode));
		assertEquals(list.get(list.size() - 1), (Integer) element);
		assertEquals(list.size(), size);
		// Test element in the middle of the list
		element = list.get(list.size() / 2);
		assertTrue(LinearSearch.linearSearch(list, element, mode));
		assertEquals(list.get(list.size() - 1), (Integer) element);
		assertEquals(list.size(), size);
		// Test last element
		element = list.get(list.size() - 1);
		assertTrue(LinearSearch.linearSearch(list, element, mode));
		assertEquals(list.get(list.size() - 1), (Integer) element);
		assertEquals(list.size(), size);
		// Test missing element
		assertFalse(LinearSearch.linearSearch(list, 1001, mode));
	}

	@Test
	public void testLinearSearchMoveUp() {
		list = lg.build(10, 100);
		LinearSearchMode<Integer> mode = LinearSearchModeFactory
				.build(LinearSearchModeFactory.modeMoveUp);

		assertFalse(LinearSearch.linearSearch(null, 100, null));
		assertFalse(LinearSearch.linearSearch(list, null, null));

		int size = list.size();

		for (int i = 0; i < list.size(); i++) {
			int j = list.get(i);
			assertTrue(LinearSearch.linearSearch(list, j, mode));
		}

		// Test first element
		int index = list.size() / 2;
		int element = list.get(0);
		int next = list.get(1);
		assertTrue(LinearSearch.linearSearch(list, element, mode));
		assertEquals(list.get(0), (Integer) element);
		assertEquals(list.get(1), (Integer) next);
		assertEquals(list.size(), size);

		// Test element in the middle of the list
		index = list.size() / 2;
		element = list.get(index);
		int previous = list.get(index - 1);
		assertTrue(LinearSearch.linearSearch(list, element, mode));
		assertEquals(list.get(index - 1), (Integer) element);
		assertEquals(list.get(index), (Integer) previous);
		assertEquals(list.size(), size);

		// Test last element
		index = list.size() - 1;
		element = list.get(index);
		previous = list.get(index - 1);
		LinearSearch.linearSearch(list, element, mode);

		assertEquals(list.get(index - 1), (Integer) element);
		assertEquals(list.get(index), (Integer) previous);
		assertEquals(list.size(), size);

		assertFalse(LinearSearch.linearSearch(list, 1001, mode));
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
		list = lg.build(1000, 1000);
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
