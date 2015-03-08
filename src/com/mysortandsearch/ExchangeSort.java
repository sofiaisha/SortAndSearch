package com.mysortandsearch;

import java.util.List;

public class ExchangeSort {
	
	//
	// Bubble sort
	// Best case o(n), median case o(n^2), worst case o(n^2)
	//
	@SuppressWarnings("unchecked")
	public static <T> void bubbleSort(List<T> list) {
		boolean swap;
		do {
			swap = false;
			for (int i=0;i<list.size()-1;i++) {
				T left = list.get(i);
				T right = list.get(i+1);
				if ( ((Comparable<T>)left).compareTo(right) > 0 ) {
					list.set(i, right);
					list.set(i+1,  left);
					swap = true;
				}
			}
		} while (swap);
	}

}
