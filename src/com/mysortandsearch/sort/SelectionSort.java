package com.mysortandsearch.sort;

import java.util.List;

public class SelectionSort {
	//
	// Selection sort
	// Best case o(n^2), median case o(n^2), worst case o(n^2)
	//

	public static <T> void selectionSort(List<T> list) {
		// For each element,
		for (int i = 0; i < (list.size() - 1); i++) {
			T i_element = list.get(i);
			T min_element = i_element;
			int min_index = i;
			// Look right for the smallest element
			for (int j = i + 1; j < list.size(); j++) {
				T current_element = list.get(j);
				@SuppressWarnings("unchecked")
				Comparable<T> comparable = (Comparable<T>) current_element;
				if (comparable.compareTo(min_element) < 0) {
					min_element = current_element;
					min_index = j;
				}
			}
			// If it has been found, swap
			if (min_index != i) {
				list.set(min_index, i_element);
				list.set(i, min_element);
			}
		}
	}
}
