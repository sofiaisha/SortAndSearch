package com.mysortandsearch.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mysortandsearch.Search;
import com.mysortandsearch.utils.ListGenerator;

public class TestSearch {

	ListGenerator lg = new ListGenerator();
	ArrayList<Integer> list;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testLinearSearch() {
		assertFalse(Search.linearSearch(null, 100));

		list = lg.build(10000, 1000);
		for (int i = 0; i < list.size(); i++) {
			int j = list.get(i);
			assertTrue(Search.linearSearch(list, j));
		}
		assertFalse(Search.linearSearch(list, 1001));
	}

	@Test
	public void testLinearSearchRecursive() {
		assertFalse(Search.linearSearchRecursive(null, 100));

		list = lg.build(10000, 1000);
		for (int i = 0; i < list.size(); i++) {
			int j = list.get(i);
			assertTrue(Search.linearSearchRecursive(list, j));
		}
		assertFalse(Search.linearSearch(list, 1001));
	}
}
