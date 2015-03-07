package com.mysortandsearch;

import java.util.List;

public class Sort<T> {

	//
	// Bubble sort
	// Best case o(n), median case o(n^2), worst case o(n^2)
	//
	public static <T> void bubbleSort(List<T> list) {
		boolean swap;
		do {
			swap = false;
			for (int i=0;i<list.size()-1;i++) {
				T left = list.get(i);
				T right = list.get(i+1);
				if ( ((Comparable)left).compareTo(right) > 0 ) {
					list.set(i, right);
					list.set(i+1,  left);
					swap = true;
				}
			}
		} while (swap);
	}
	
	//
	// Insertion sort
	// Best case o(n), median case o(n^2), worst case o(n^2)
	//
	
	public static <T> void insertionSort(List<T> list) {
		for (int i=1;i<list.size();i++) {
			insert(list, i, list.get(i));
		}
	}
	
	private static <T> void insert(List<T> list, int index, T element) {
		int position = index-1;
		// For each element, start from its original position, move larger neighbors to the right
		while ( (position>=0) && ( ((Comparable)list.get(position)).compareTo(element) > 0) ) {
			list.set(position+1, list.get(position));
			position--;
		}
		// Put the element to the right of its first smaller neighbor
		list.set(position+1, element);
	}
	
	//
	// Utility method to check if a list is sorted
	//
	public static <T> boolean isSorted(List<T> list) {
		for (int i=0;i<list.size()-1;i++) {
			T left = list.get(i);
			T right = list.get(i+1);
			if ( ((Comparable)left).compareTo(right) > 0 ) {
				return false;
			}
		}
		return true;
	}
}
