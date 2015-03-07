package com.mysortandsearch;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestSort {

	private static ListGenerator lg;
	private ArrayList<Integer> list;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		lg = new ListGenerator();
	}

	@Test
	public void testInsertion() {
		list = lg.build(10, 100);
		Sort.insertionSort(list);
		for (int i=0;i<list.size()-1;i++) {
			assertTrue(list.get(i) <= list.get(i+1));
		}
		list = null;
	}
}
