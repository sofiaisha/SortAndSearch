package com.mysortandsearch;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.Test;
	
public class TestSelectionSort {

		private static ListGenerator lg;
		private ArrayList<Integer> list;
		
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			lg = new ListGenerator();
		}
		
		@Test
		public void testSelection() {
			list = lg.build(10000, 100000);
			SelectionSort.selectionSort(list);
			assertTrue(Sort.isSorted(list));
			list = null;
		}
}

