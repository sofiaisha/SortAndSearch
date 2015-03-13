package com.mysortandsearch.search;

import java.util.List;

import com.mysortandsearch.search.utils.LinearSearchMode;

public class LinearSearch<T> {

	//
	// Linear search
	// Best case o(1), median case o(n), worst case o(n)
	//
	
	// Iterative version
	public static <T> boolean linearSearch(List<T> list, T t) {
		return linearSearch(list, t, null);
	}
	
	// Iterative version with mode (move to front, move to back, move up)
	public static <T> boolean linearSearch(List<T> list, T t, LinearSearchMode<T> mode) {
		if ((list == null) || (t == null) ) {
			return false;
		}
		for (int i=0;i<list.size();i++) {
			T current = list.get(i);
			if (current.equals(t)) {
				if (mode != null) {
					mode.moveElement(list, i);
				}
				return true;
			}
		}
		return false;
	}

	// Recursive version
	public static <T> boolean linearSearchRecursive(List<T> list, T t) {
		if ((list == null) || (t == null)) {
			return false;
		}
		return linearSearchRecursive_internal(list, t, 0);
	}

	private static <T> boolean linearSearchRecursive_internal(List<T> list,
			T t, int index) {
		if (index >= list.size()) {
			return false;
		}
		if (list.get(index).equals(t)) {
			return true;
		}
		return linearSearchRecursive_internal(list, t, index + 1);
	}
}
