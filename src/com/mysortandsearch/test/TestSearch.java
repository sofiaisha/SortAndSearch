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
		list = lg.build(10000, 100000);
		
		assertFalse(LinearSearch.linearSearch(null, 100));
		assertFalse(LinearSearch.linearSearch(list, null));

		for (int i = 0; i < list.size(); i++) {
			int j = list.get(i);
			assertTrue(LinearSearch.linearSearch(list, j));
		}
		assertFalse(LinearSearch.linearSearch(list, 999999));
	}

	@Test
	public void testLinearSearchNoMode() {
		list = lg.build(10000, 100000);
		
		assertEquals(LinearSearchModeFactory.build(4), null);

		assertFalse(LinearSearch.linearSearch(null, 100, null));
		assertFalse(LinearSearch.linearSearch(list, null, null));

		for (int i = 0; i < list.size(); i++) {
			int j = list.get(i);
			assertTrue(LinearSearch.linearSearch(list, j, null));
		}
		assertFalse(LinearSearch.linearSearch(list, 999999, null));
	}

	@Test
	public void testLinearSearchMoveFirst() {
		list = lg.buildUnique(10000, 100000);
		LinearSearchMode<Integer> mode = LinearSearchModeFactory
				.build(LinearSearchModeFactory.modeMoveFirst);

		assertFalse(LinearSearch.linearSearch(null, 100, null));
		assertFalse(LinearSearch.linearSearch(list, null, null));

		assertFalse(LinearSearch.linearSearchMoveFirst(null, 100));
		assertFalse(LinearSearch.linearSearchMoveFirst(list, null));
		
		int size = list.size();

		for (int i = 0; i < list.size(); i++) {
			int j = list.get(i);
			assertTrue(LinearSearch.linearSearch(list, j, mode));
			assertTrue(LinearSearch.linearSearchMoveFirst(list, j));

		} 
		// Test first element
		int element = list.get(0);
		assertTrue(LinearSearch.linearSearch(list, element, mode));
		assertTrue(LinearSearch.linearSearchMoveFirst(list, element));
		assertEquals(list.get(0), (Integer) element);
		assertEquals(list.size(), size);
		// Test element in the middle of the list
		element = list.get(list.size() / 2);
		assertTrue(LinearSearch.linearSearch(list, element, mode));
		assertTrue(LinearSearch.linearSearchMoveFirst(list, element));
		assertEquals(list.get(0), (Integer) element);
		assertEquals(list.size(), size);
		// Test last element
		element = list.get(list.size() - 1);
		assertTrue(LinearSearch.linearSearch(list, element, mode));
		assertTrue(LinearSearch.linearSearchMoveFirst(list, element));
		assertEquals(list.get(0), (Integer) element);
		assertEquals(list.size(), size);
		// Test missing element
		assertFalse(LinearSearch.linearSearch(list, 999999, mode));
		assertFalse(LinearSearch.linearSearchMoveFirst(list, 999999));
	}
	
	@Test
	public void testLinearSearchMoveLast() {
		list = lg.buildUnique(10000, 100000);
		LinearSearchMode<Integer> mode = LinearSearchModeFactory
				.build(LinearSearchModeFactory.modeMoveLast);

		assertFalse(LinearSearch.linearSearch(null, 100, null));
		assertFalse(LinearSearch.linearSearch(list, null, null));
		
		assertFalse(LinearSearch.linearSearchMoveLast(null, 100));
		assertFalse(LinearSearch.linearSearchMoveLast(list, null));

		int size = list.size();

		for (int i = 0; i < list.size(); i++) {
			int j = list.get(i);
			assertTrue(LinearSearch.linearSearch(list, j, mode));
			assertTrue(LinearSearch.linearSearchMoveLast(list, j));
		}

		// Test first element
		int element = list.get(0);
		assertTrue(LinearSearch.linearSearch(list, element, mode));
		assertTrue(LinearSearch.linearSearchMoveLast(list, element));
		assertEquals(list.get(list.size() - 1), (Integer) element);
		assertEquals(list.size(), size);
		// Test element in the middle of the list
		element = list.get(list.size() / 2);
		assertTrue(LinearSearch.linearSearch(list, element, mode));
		assertTrue(LinearSearch.linearSearchMoveLast(list, element));
		assertEquals(list.get(list.size() - 1), (Integer) element);
		assertEquals(list.size(), size);
		// Test last element
		element = list.get(list.size() - 1);
		assertTrue(LinearSearch.linearSearch(list, element, mode));
		assertTrue(LinearSearch.linearSearchMoveLast(list, element));
		assertEquals(list.get(list.size() - 1), (Integer) element);
		assertEquals(list.size(), size);
		// Test missing element
		assertFalse(LinearSearch.linearSearch(list, 999999, mode));
		assertFalse(LinearSearch.linearSearchMoveLast(list, 999999));
	}

	@Test
	public void testLinearSearchMoveUp() {
		list = lg.buildUnique(10000, 100000);
		LinearSearchMode<Integer> mode = LinearSearchModeFactory
				.build(LinearSearchModeFactory.modeMoveUp);

		assertFalse(LinearSearch.linearSearch(null, 100, null));
		assertFalse(LinearSearch.linearSearch(list, null, null));
		assertFalse(LinearSearch.linearSearchMoveUp(null, 100));
		assertFalse(LinearSearch.linearSearchMoveUp(list, null));

		int size = list.size();

		for (int i = 0; i < list.size(); i++) {
			int j = list.get(i);
			assertTrue(LinearSearch.linearSearch(list, j, mode));
			assertTrue(LinearSearch.linearSearchMoveUp(list, j));
		}

		// Test first element
		int index = list.size() / 2;
		int element = list.get(0);
		int next = list.get(1);
		assertTrue(LinearSearch.linearSearch(list, element, mode));
		assertTrue(LinearSearch.linearSearchMoveUp(list, element));
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
		
		previous = list.get(index-2);
		assertTrue(LinearSearch.linearSearchMoveUp(list, element));
		assertEquals(list.get(index - 2), (Integer) element);
		assertEquals(list.get(index - 1), (Integer) previous);
		
		assertEquals(list.size(), size);

		// Test last element
		size = list.size();
		element = list.get(size-1);
		previous = list.get(size-2);
		LinearSearch.linearSearch(list, element, mode);
		assertEquals(list.get(size - 1), (Integer)previous);
		assertEquals(list.get(size - 2), (Integer)element);
		
		element = list.get(size-1);
		previous = list.get(size-2);		
		LinearSearch.linearSearchMoveUp(list, element);
		assertEquals(list.get(size - 1), (Integer)previous);
		assertEquals(list.get(size - 2), (Integer)element);

		assertEquals(list.size(), size);

		assertFalse(LinearSearch.linearSearch(list, 999999, mode));
		assertFalse(LinearSearch.linearSearchMoveUp(list, 999999));
	}

	@Test
	public void testLinearSearchRecursive() {
		list = lg.buildUnique(10000, 100000);

		assertFalse(LinearSearch.linearSearchRecursive(null, 100));
		assertFalse(LinearSearch.linearSearchRecursive(list, null));

		for (int i = 0; i < list.size(); i++) {
			int j = list.get(i);
			assertTrue(LinearSearch.linearSearchRecursive(list, j));
		}
		assertFalse(LinearSearch.linearSearch(list, 999999));
	}

	@Test
	public void testBinarySearch() {
		list = lg.buildUnique(10000, 100000);
		ExchangeSort.quickSort(list);

		assertFalse(BinarySearch.binarySearch(null, 100));
		assertFalse(BinarySearch.binarySearch(list, null));

		for (int i = 0; i < list.size(); i++) {
			int j = list.get(i);
			assertTrue(BinarySearch.binarySearch(list, j));
		}
		assertFalse(BinarySearch.binarySearch(list, 999999));
	}

	@Test
	public void testBinarySearchRecursive() {
		list = lg.buildUnique(10000, 100000);
		ExchangeSort.quickSort(list);

		assertFalse(BinarySearch.binarySearchRecursive(null, 100));
		assertFalse(BinarySearch.binarySearchRecursive(list, null));

		for (int i = 0; i < list.size(); i++) {
			int j = list.get(i);
			assertTrue(BinarySearch.binarySearchRecursive(list, j));
		}
		assertFalse(BinarySearch.binarySearchRecursive(list, 999999));
	}
}
