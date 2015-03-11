package com.mysortandsearch;

import java.util.ArrayList;
import java.util.List;

public class DistributionSort<T extends HasAnIntegerKey> {

	//
	// Count sort : sort a list of n elements with k integer keys (k<<n)
	// Best case o(n), median case o(n), worst case o(n)
	//
	public static <T> List<T> countSort(List<T> list, int maxValue) {
		if (maxValue < 0) {
			return null;
		}
		// Walk through the list and count occurrences
		int[] counters = new int[maxValue + 1];
		for (int i = 0; i < list.size(); i++) {
			T element = list.get(i);
			counters[((HasAnIntegerKey) element).getKey()]++;
		}
		// Compute the start index of each key
		int total = 0;
		for (int i = 0; i <= maxValue; i++) {
			int counter = counters[i];
			counters[i] = total;
			total += counter;
		}
		// Walk through the list, build a new list and put each element at the
		// correct index based on its key
		// Note: the initial order of elements with the same key will be
		// preserved (stable search)
		List<T> newList = new ArrayList<T>(list);
		for (int i = 0; i < list.size(); i++) {
			int key = ((HasAnIntegerKey) list.get(i)).getKey();
			newList.set(counters[key], list.get(i));
			counters[key]++;
		}
		return newList;
	}
}
