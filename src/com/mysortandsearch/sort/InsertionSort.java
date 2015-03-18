package com.mysortandsearch.sort;

import java.util.List;

public class InsertionSort<T> {

	//
	// Insertion sort
	// Best case o(n), median case o(n^2), worst case o(n^2)
	//

	public static <T> void insertionSort(List<T> list) {
		for (int i = 1; i < list.size(); i++) {
			InsertionSort.insert(list, i, list.get(i));
		}
	}

	private static <T> void insert(List<T> list, int index, T element) {
		int position = index - 1;
		// For each element, start from its original position, move larger
		// neighbors to the right
		@SuppressWarnings("unchecked")
		Comparable<T> comparable = (Comparable<T>) list.get(position);
		while ((position >= 0) && (comparable.compareTo(element) > 0)) {
			list.set(position + 1, list.get(position));
			position--;
		}
		// Put the element to the right of its first smaller neighbor
		list.set(position + 1, element);
	}

}
