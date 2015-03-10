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
	
	//
	// Quicksort
	// Best case o(n log n), median case o(n log n), worst case o(n^2)
	//
	public static <T> void quickSort(List<T> list) {
		quickSortInternal(list, 0, list.size()-1);
	}
	
	private static <T> void quickSortInternal(List<T> list, int left, int right) {
		if (left < right) {
			int index = partition(list, left, right);
			quickSortInternal(list, left, index-1);
			quickSortInternal(list, index+1, right);
		}
	}
	
	@SuppressWarnings("unchecked")
	private static <T> int partition(List<T> list, int left, int right) {
		int pivot = left;
		swap(list, pivot, right);
		
		int store = left;
		for (int i=left;i<=right-1;i++) {
			T currentElem = list.get(i);
			T rightElem = list.get(right);
			if ( ((Comparable<T>)currentElem).compareTo(rightElem) <= 0 ) {
				swap(list, i, store);
				store++;
			}
		}
		swap(list, store, right);
		return store;
	}
	
	private static <T> void swap(List<T> list, int i, int j) {
		T tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
	}
	
	
	
}
