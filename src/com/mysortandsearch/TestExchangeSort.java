package com.mysortandsearch;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
	
public class TestExchangeSort {

		private static ListGenerator lg;
		private ArrayList<Integer> list;
		
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			lg = new ListGenerator();
		}
		
		@Test
		public void testBubble() {
			list = lg.build(10, 100);
			ExchangeSort.bubbleSort(list);
			assertTrue(Sort.isSorted(list));
			list = null;
		}
}

