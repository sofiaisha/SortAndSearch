package com.mysortandsearch.sort.utils;

import java.util.List;

public class Sort {

	//
	// Utility method to check if a list is sorted
	//
	@SuppressWarnings("unchecked")
	public static <T> boolean isSorted(List<T> list) {
		for (int i = 0; i < (list.size() - 1); i++) {
			T left = list.get(i);
			T right = list.get(i + 1);
			if (((Comparable<T>) left).compareTo(right) > 0) {
				return false;
			}
		}
		return true;
	}

}
