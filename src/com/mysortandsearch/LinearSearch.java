package com.mysortandsearch;

import java.util.List;

public class LinearSearch<T> {

	//
	// Linear search
	// Best case o(1), median case o(n), worst case o(n)
	//

	// TODO: add modes : move to front, move to back, move up
	
	// Iterative version
	public static <T> boolean linearSearch(List<T> list, T t) {
		if ((list == null) || (t == null)) {
			return false;
		}
		for (T element : list) {
			if (element.equals(t)) {
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
