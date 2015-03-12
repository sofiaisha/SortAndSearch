package com.mysortandsearch;

import java.util.List;

public class BinarySearch<T extends Comparable<T>> {

	// Binary search
	// Best case o(1), median case o(log n), worst case o(log n)
	// Note: this only works for sorted lists.
	
	// Iterative version

	@SuppressWarnings("unchecked")
	public static <T> boolean binarySearch(List<T> list, T t) {
		if ((list == null) || (t == null)) {
			return false;
		}
		int low = 0;
		int high = list.size() - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			T element = list.get(mid);
			if (element.equals(t)) {
				return true;
			}
			if (((Comparable<T>) t).compareTo(element) < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}
	
	// Recursive version
	
	public static <T> boolean binarySearchRecursive(List<T> list, T t) {
		if ((list == null) || (t == null)) {
			return false;
		}
		return binarySearchRecursive_internal(list, t, 0, list.size()-1);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> boolean binarySearchRecursive_internal(List<T> list, T t, int low, int high) {
		if (low > high) {
			return false;
		}
		int mid = (high + low) / 2;
		T element = list.get(mid);
		if (element.equals(t)) {
			return true;
		}
		if (((Comparable<T>) t).compareTo(element) < 0) {
			return binarySearchRecursive_internal(list, t, low, mid-1);
		} else {
			return binarySearchRecursive_internal(list, t, mid+1, high);
		}
	}
}
