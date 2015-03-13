package com.mysortandsearch.sort;

import java.util.List;

public class ExchangeSort<T> {

	//
	// Bubble sort
	// Best case o(n), median case o(n^2), worst case o(n^2)
	//
	public static <T> void bubbleSort(List<T> list) {
		boolean swap;

		do {
			swap = false;
			for (int i = 0; i < (list.size() - 1); i++) {
				T left = list.get(i);
				T right = list.get(i + 1);
				try {
					@SuppressWarnings("unchecked")
					Comparable<T> leftComp = (Comparable<T>) left;
					if (leftComp.compareTo(right) > 0) {
						list.set(i, right);
						list.set(i + 1, left);
						swap = true;
					}
				} catch (ClassCastException e) {
					e.printStackTrace();
				}
			}
		} while (swap);

	}

	//
	// Quicksort
	// Best case o(n log n), median case o(n log n), worst case o(n^2)
	//
	public static <T> void quickSort(List<T> list) {
		try {
			ExchangeSort.quickSortInternal(list, 0, list.size() - 1);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
	}

	private static <T> void quickSortInternal(List<T> list, int left, int right) {
		if (left < right) {
			int index = ExchangeSort.partition(list, left, right);
			ExchangeSort.quickSortInternal(list, left, index - 1);
			ExchangeSort.quickSortInternal(list, index + 1, right);
		}
	}

	private static <T> int partition(List<T> list, int left, int right) {
		int pivot = left;
		ExchangeSort.swap(list, pivot, right);

		int store = left;
		for (int i = left; i <= (right - 1); i++) {
			T currentElem = list.get(i);
			T rightElem = list.get(right);
			@SuppressWarnings("unchecked")
			Comparable<T> currentElemComp = (Comparable<T>) currentElem;
			if (currentElemComp.compareTo(rightElem) <= 0) {
				ExchangeSort.swap(list, i, store);
				store++;
			}
		}
		ExchangeSort.swap(list, store, right);
		return store;
	}

	private static <T> void swap(List<T> list, int i, int j) {
		T tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
	}

}
